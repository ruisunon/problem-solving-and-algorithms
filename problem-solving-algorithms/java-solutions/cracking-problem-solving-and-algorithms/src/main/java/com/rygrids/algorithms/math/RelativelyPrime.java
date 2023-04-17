/**
 * Test to see whether two numbers are relatively prime (coprime)
 *
 * Time Complexity: O(log(a+b))
 * 
 * @author William Fiset, william.alexandre.fiset@gmail.com
 **/
package com.rygrids.algorithms.math;

public class RelativelyPrime {

  // Find the greatest common factor between two numbers
  static long gcf(long a, long b) {
    return b == 0 ? a : gcf(b, a % b);
  }

  // Test to see whether two numbers are relatively prime (coprime)
  static boolean areCoprime(long a, long b) {
    return gcf(a, b) == 1;
  }

  public static void main(String[] args) {
    System.out.println(areCoprime(5, 7));   // true
    System.out.println(areCoprime(12, 18)); // false
  }

}
