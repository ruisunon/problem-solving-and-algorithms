/**
 * Medium speed suffix array implementation.
 * Time Complexity: O(nlog^2(n))
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
package com.rygrids.datastructures.suffixarray;

import java.util.*;

public class SuffixArrayMed extends SuffixArray {

  // Helper class which sorts suffix ranks
  static class SuffixRankTuple implements Comparable <SuffixRankTuple> {

    int firstHalf, secondHalf, originalIndex;

    // Sort Suffix ranks first on the first half then the second half
    @Override public int compareTo(SuffixRankTuple other) {
      int cmp = Integer.compare(firstHalf, other.firstHalf);
      if (cmp == 0) return Integer.compare(secondHalf, other.secondHalf);
      return cmp;
    }

    @Override public String toString() {
      return originalIndex + " -> (" + firstHalf + ", " + secondHalf + ")";
    }

  }

  public SuffixArrayMed(String text) {
    super(toIntArray(text), DEFAULT_ALPHABET_SHIFT, DEFAULT_ALPHABET_SIZE);
  }

  public SuffixArrayMed(int[] text) {
    super(text, DEFAULT_ALPHABET_SHIFT, DEFAULT_ALPHABET_SIZE);
  }

  // TODO(williamfiset): Get rid of these constructors in favor of
  // automatically detecting the alphabet size shift required
  public SuffixArrayMed(String text, int shift) {
    super(toIntArray(text), shift, DEFAULT_ALPHABET_SHIFT);
  }
  public SuffixArrayMed(int[] text, int shift) {
    super(text, shift, DEFAULT_ALPHABET_SIZE);
  }

  // Designated constructor
  public SuffixArrayMed(int[] text, int shift, int alphabetSize) {
    super(text, shift, alphabetSize);
  }

  // Construct a suffix array in O(nlog^2(n))
  @Override protected void construct() {

    sa = new int[N];

    // Maintain suffix ranks in both a matrix with two rows containing the
    // current and last rank information as well as some sortable rank objects
    int[][] suffixRanks = new int[2][N];
    SuffixRankTuple[] ranks = new SuffixRankTuple[N];

    // Assign a numerical value to each character in the text
    for (int i = 0; i < N; i++) {
      suffixRanks[0][i] = T[i];
      ranks[i] = new SuffixRankTuple();
    }

    // O(log(n))
    for(int pos = 1; pos < N; pos *= 2) {

      for(int i = 0; i < N; i++) {
        SuffixRankTuple suffixRank = ranks[i];
        suffixRank.firstHalf  = suffixRanks[0][i];
        suffixRank.secondHalf = i+pos < N ? suffixRanks[0][i+pos] : -1;
        suffixRank.originalIndex = i;
      }

      // O(nlog(n))
      java.util.Arrays.sort(ranks);

      int newRank = 0;
      suffixRanks[1][ranks[0].originalIndex] = 0;

      for (int i = 1; i < N; i++ ) {

        SuffixRankTuple lastSuffixRank = ranks[i-1];
        SuffixRankTuple currSuffixRank = ranks[i];

        // If the first half differs from the second half
        if (currSuffixRank.firstHalf  != lastSuffixRank.firstHalf ||
            currSuffixRank.secondHalf != lastSuffixRank.secondHalf)
          newRank++;

        suffixRanks[1][currSuffixRank.originalIndex] = newRank;

      }

      // Place top row (current row) to be the last row
      suffixRanks[0] = suffixRanks[1];

      // Optimization to stop early
      if (newRank == N-1) break;

    }

    // Fill suffix array
    for (int i = 0; i < N; i++) {
      sa[i] = ranks[i].originalIndex;
      ranks[i] = null;
    }

    // Cleanup
    suffixRanks[0] = suffixRanks[1] = null;
    suffixRanks = null;
    ranks = null;

  }

  public static void main(String[] args) {

    // String[] strs = { "AAGAAGC", "AGAAGT", "CGAAGC" };
    // String[] strs = { "abca", "bcad", "daca" };
    // String[] strs = { "abca", "bcad", "daca" };
    // String[] strs = { "AABC", "BCDC", "BCDE", "CDED" };
    // String[] strs = { "abcdefg", "bcdefgh", "cdefghi" };
    // String[] strs = { "xxx", "yyy", "zzz" };
    // TreeSet <String> lcss = SuffixArrayMed.lcs(strs, 2);
    // System.out.println(lcss);

    // SuffixArrayMed sa = new SuffixArrayMed("abracadabra");
    // System.out.println(sa);
    // System.out.println(java.util.Arrays.toString(sa.sa));
    // System.out.println(java.util.Arrays.toString(sa.lcp));

    SuffixArrayMed sa = new SuffixArrayMed("ABBABAABAA");
    // SuffixArrayMed sa = new SuffixArrayMed("GAGAGAGAGAGAG");
    System.out.println(sa);


  }

}
