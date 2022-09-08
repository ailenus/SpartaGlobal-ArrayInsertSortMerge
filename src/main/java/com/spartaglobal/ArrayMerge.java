package com.spartaglobal;

public class ArrayMerge {

    // takes two sorted arrays and returns a merged sorted array
    public static int[] merge(int[] array1, int[] array2) {
        int length1 = array1.length;
        int length2 = array2.length;

        int[] result = new int[length1 + length2];

        int index1 = 0;
        int index2 = 0;
        int indexResult = 0;

        while (index1 < length1 && index2 < length2) {
            if (array1[index1] < array2[index2]) {
                result[indexResult] = array1[index1];
                indexResult++;
                index1++;
            } else {
                result[indexResult] = array2[index2];
                indexResult++;
                index2++;
            }
        }

        while (index1 < length1) {
            result[indexResult] = array1[index1];
            indexResult++;
            index1++;
        }

        while (index2 < length2) {
            result[indexResult] = array2[index2];
            indexResult++;
            index2++;
        }
    
        return result;
    }
    
}
