package com.spartaglobal;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

public class ArrayMergeTest {

    int[] input1;
    int[] input2;
    int[] result;

    private void initialise(int length1, int length2, int bound) {
        input1 = App.generateRandomIntArray(length1, bound);
        input2 = App.generateRandomIntArray(length2, bound);
        result = new int[length1 + length2];

        System.arraycopy(input1, 0, result, 0, length1);
        System.arraycopy(input2, 0, result, length1, length2);
        Arrays.sort(input1);
        Arrays.sort(input2);
        Arrays.sort(result);
    }

    private boolean test(int[] input1, int[] input2, int[] result) {
        return Arrays.equals(ArrayMerge.merge(input1, input2), result);
    }

    @Test
    public void testMergeLarge() {
        initialise(100_000, 100_000, Integer.MAX_VALUE);
        assertTrue(test(input1, input2, result));
    }

    @Test
    public void testMergeZero() {
        initialise(0, 0, 1);
        assertTrue(test(input1, input2, result));
    }

}
