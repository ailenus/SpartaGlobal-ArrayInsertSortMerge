package com.spartaglobal;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class ArrayInsertTest {

    private int[] input;
    private int value;
    private int[] result;

    private void initialise(int length, int bound) {
        input = App.generateRandomIntArray(length, bound);
        value = new Random().nextInt(bound);
        result = new int[length + 1];

        System.arraycopy(input, 0, result, 0, length);
        result[length] = value;
        Arrays.sort(result);
    }

    private boolean test1(int[] input, int value, int[] result) {
        return Arrays.equals(ArrayInsert.insert1(input, value), result);
    }

    private boolean test2(int[] input, int value, int[] result) {
        return Arrays.equals(ArrayInsert.insert2(input, value), result);
    }

    @Test
    public void testInsert1Large() {
        initialise(100_000, Integer.MAX_VALUE);
        assertTrue(test1(input, value, result));
    }

    @Test
    public void testInsert1Zero() {
        initialise(0, 1);
        assertTrue(test1(input, value, result));
    }

    @Test
    public void testInsert2Large() {
        initialise(100_000, Integer.MAX_VALUE);
        assertTrue(test2(input, value, result));
    }

    @Test
    public void testInsert2Zero() {
        initialise(0, 1);
        assertTrue(test2(input, value, result));
    }

}
