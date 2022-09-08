package com.spartaglobal;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class App {

    public static void main(String[] args) {

        int[] array = generateRandomIntArray(10, 100);
        int value = new Random().nextInt(100);

        System.out.println("Array: " + Arrays.toString(array));
        System.out.println("Value: " + value);
        System.out.println("Inserted value into array and sorted: ");
        System.out.println(Arrays.toString(ArrayInsert.insert1(array, value)));
        System.out.println();

        int[] array1 = generateRandomIntArray(8, 200);
        Arrays.sort(array1);
        int[] array2 = generateRandomIntArray(12, 200);
        Arrays.sort(array2);

        System.out.println("Array 1 sorted: " + Arrays.toString(array1));
        System.out.println("Array 2 sorted: " + Arrays.toString(array2));
        System.out.println("Merged arrays 1 and 2 and sorted: ");
        System.out.println(Arrays.toString(ArrayMerge.merge(array1, array2)));

    }

    public static int[] generateRandomIntArray(int length, int bound) {
        return IntStream.generate(()
                -> new Random().nextInt(bound)).limit(length).toArray();

    }

}
