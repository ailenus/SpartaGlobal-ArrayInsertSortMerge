package com.spartaglobal;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ArrayInsertTest {

    private final int BOUND = Integer.MAX_VALUE;
    private final int LENGTH = 100_000;

    private int[] input = App.generateRandomIntArray(LENGTH, BOUND);
    private int value = new Random().nextInt(BOUND);

    private int[] result = new int[LENGTH + 1];

    @Before
    public void initialise() {
        System.arraycopy(input, 0, result, 0, LENGTH);
        result[LENGTH] = value;
        Arrays.sort(result);
    }

    @Test
    public void testInsert1() {
        assertTrue(Arrays.equals(ArrayInsert.insert1(input, value), result));
    }

    @Test
    public void testInsert2() {
        assertTrue(Arrays.equals(ArrayInsert.insert2(input, value), result));
    }

}
