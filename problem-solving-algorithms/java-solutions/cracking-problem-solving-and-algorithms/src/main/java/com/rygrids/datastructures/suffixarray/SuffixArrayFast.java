/**
 * Suffix array construction implementation.
 *
 * Time Complexity: O(nlog(n))
 *
 * @author William Fiset, william.alexandre.fiset@gmail.com
 */
package com.rygrids.datastructures.suffixarray;

public class SuffixArrayFast extends SuffixArray {

  int[] sa2, rank, tmp, c;

  public SuffixArrayFast(String text) {
    super(toIntArray(text), DEFAULT_ALPHABET_SHIFT, DEFAULT_ALPHABET_SIZE);
  }

  public SuffixArrayFast(int[] text) {
    super(text, DEFAULT_ALPHABET_SHIFT, DEFAULT_ALPHABET_SIZE);
  }

  // TODO(williamfiset): Get rid of these constructors in favor of
  // automatically detecting the alphabet size shift required
  public SuffixArrayFast(String text, int shift) {
    super(toIntArray(text), shift, DEFAULT_ALPHABET_SHIFT);
  }
  public SuffixArrayFast(int[] text, int shift) {
    super(text, shift, DEFAULT_ALPHABET_SIZE);
  }

  // Designated constructor
  public SuffixArrayFast(int[] text, int shift, int alphabetSize) {
    super(text, shift, alphabetSize);
  }

  @Override protected void construct() {
    
    sa = new int[N];
    sa2 = new int[N];
    rank = new int[N];
    c = new int[Math.max(alphabetSize, N)];
    
    int i, p, r;
    for (i=0; i<N; ++i) c[rank[i] = T[i]]++;
    for (i=1; i<alphabetSize; ++i) c[i] += c[i-1];
    for (i=N-1; i>=0; --i) sa[--c[T[i]]] = i;
    for (p=1; p<N; p <<= 1) {
      for (r=0, i=N-p; i<N; ++i) sa2[r++] = i;
      for (i=0; i<N; ++i) if (sa[i] >= p) sa2[r++] = sa[i] - p;
      java.util.Arrays.fill(c, 0, alphabetSize, 0);
      for (i=0; i<N; ++i) c[rank[i]]++;
      for (i=1; i<alphabetSize; ++i) c[i] += c[i-1];
      for (i=N-1; i>=0; --i) sa[--c[rank[sa2[i]]]] = sa2[i];
      for (sa2[sa[0]] = r = 0, i=1; i<N; ++i) {
          if (!(rank[sa[i-1]] == rank[sa[i]] &&
              sa[i-1]+p < N && sa[i]+p < N &&
              rank[sa[i-1]+p] == rank[sa[i]+p])) r++;
          sa2[sa[i]] = r;
      } tmp = rank; rank = sa2; sa2 = tmp;
      if (r == N-1) break; alphabetSize = r + 1;
    }
  }

  public static void main(String[] args) {
    SuffixArrayFast sa = new SuffixArrayFast("ABBABAABAA");
    System.out.println(sa);
  }

}
