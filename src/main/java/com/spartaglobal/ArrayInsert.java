package com.spartaglobal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayInsert {

    // using libraries
    public static int[] insert1(int[] integers, int value) {
        List<Integer> integerList = new ArrayList<>();
        for (int integer : integers) {
            integerList.add(integer);
        }
        integerList.add(value);
        Collections.sort(integerList);
    
        return integerList.stream().mapToInt(Integer::intValue).toArray();
    }

    // manual quicksort implementation
    public static int[] insert2(int[] integers, int value) {
        int length = integers.length;
        int[] integersResult = new int[length + 1];
        System.arraycopy(integers, 0, integersResult, 0, integers.length);
        integersResult[length] = value;
    
        ArrayInsert.quicksort(integersResult, 0, length);
    
        return integersResult;
    }

    // private helper methods for quicksort
    private static void quicksort(int[] array, int begin, int end) {
        if (begin < end) {
            int partitionIndex = ArrayInsert.partition(array, begin, end);
    
            quicksort(array, begin, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int begin, int end) {
        int pivot = array[end];
        int index = (begin - 1);
    
        for (int i = begin; i < end; i++) {
            if (array[i] <= pivot) {
                index++;
                int temp = array[index];
                array[index] = array[i];
                array[i] = temp;
            }
        }
    
        int temp = array[index + 1];
        array[index + 1] = array[end];
        array[end] = temp;
    
        return index + 1;
    }
    
}
