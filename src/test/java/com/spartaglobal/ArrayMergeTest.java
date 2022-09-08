package com.spartaglobal;

import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class ArrayMergeTest {

    private final int BOUND = Integer.MAX_VALUE;
    private final int LENGTH_1 = 100_000;
    private final int LENGTH_2 = 100_000;

    private int[] input1 = App.generateRandomIntArray(LENGTH_1, BOUND);
    private int[] input2 = App.generateRandomIntArray(LENGTH_2, BOUND);

    private int[] result = new int[LENGTH_1 + LENGTH_2];

    @Before
    public void initialise() {
        System.arraycopy(input1, 0, result, 0, LENGTH_1);
        System.arraycopy(input2, 0, result, LENGTH_1, LENGTH_2);

        Arrays.sort(input1);
        Arrays.sort(input2);
        Arrays.sort(result);
    }

    @Test
    public void testMerge() {
        assertTrue(Arrays.equals(ArrayMerge.merge(input1, input2), result));
    }

}
