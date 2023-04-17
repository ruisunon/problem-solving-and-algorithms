package net.interviews.revisit.algorithms;

import java.util.Arrays;

public class ArrayTest {
	public static void main(String args[]) {
		Integer[] input = new Integer[]{1, 2, 3, 4, 5}; 
		System.out.printf("Does array %s has %s? %b %n", Arrays.toString(input), 5, isExists(input, 5)); 
		String[] names = new String[]{"JP", "KP", "RP", "OP", "SP"}; 
		System.out.printf("Does array %s has %s? %b %n", Arrays.toString(names), "JP", isExists(names, "JP")); 
		System.out.printf("Does array %s has %s? %b %n", Arrays.toString(names), "OP", contains(names, "OP")); 
	}
	
   public static<T> boolean isExists(final T[] array, final T object) {
	   return Arrays.asList(array).contains(object);
   }
   
   public static <T> boolean contains(final T[] array, final T v) {
	   for(final T e: array) {
		   if( e==v || v!=null && v.equals(e)) {
			   return true;
		   }
	   }
	   return false;
   }
}
