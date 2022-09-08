package com.spartaglobal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayInsert {

    // converting the array to a list first and then sorting using libraries
    public static int[] insert1(int[] array, int value) {
        List<Integer> list = new ArrayList<>();
        for (int integer : array) {
            list.add(integer);
        }
        list.add(value);
        Collections.sort(list);
    
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    // manual quicksort implementation
    public static int[] insert2(int[] array, int value) {
        int length = array.length;
        int[] result = new int[length + 1];
        System.arraycopy(array, 0, result, 0, array.length);
        result[length] = value;
    
        ArrayInsert.quicksort(result, 0, length);
    
        return result;
    }

    // private helper methods for quicksort
    private static void quicksort(int[] array, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(array, start, end);
    
            quicksort(array, start, partitionIndex - 1);
            quicksort(array, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int index = (start - 1);
    
        for (int i = start; i < end; i++) {
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
