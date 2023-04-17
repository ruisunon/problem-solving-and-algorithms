package com.rygrids.algorithms.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


public class StringWeightSortingTest {

    @Test
    public void BasicTests() {
        assertEquals("2000 103 123 4444 99",  StringWeightSorting.orderWeight("103 123 4444 99 2000"));
        assertEquals("11 11 2000 10003 22 123 1234000 44444444 9999",  StringWeightSorting.orderWeight("2000 10003 1234000 44444444 9999 11 11 22 123"));
    }
}