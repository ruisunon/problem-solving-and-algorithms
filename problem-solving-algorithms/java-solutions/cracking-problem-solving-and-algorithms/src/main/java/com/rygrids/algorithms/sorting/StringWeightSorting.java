package com.rygrids.algorithms.sorting;


import java.util.Arrays;
import java.util.stream.Collectors;

public class StringWeightSorting {

    public static String orderWeight(String strng) {

        String[] words = strng.split(" ");

        return Arrays.stream(words)
                .map(String::trim)
                .sorted((a, b) -> {

                    int result;

                    result = Integer.compare(sumAllDigits(a), sumAllDigits(b));

                    if (result == 0)
                        result = a.compareTo(b);

                    return result;
                })
                .collect(Collectors.joining(" "));
    }

    private static int sumAllDigits(String number) {

        int sum = 0;

        for(int i = 0; i < number.length(); i++)
            sum += Character.getNumericValue(number.charAt(i));

        return sum;
    }
}