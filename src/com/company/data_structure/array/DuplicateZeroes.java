package com.company.data_structure.array;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero, shifting the remaining elements to the right.
 * <p>
 * Note that elements beyond the length of the original array are not written.
 * <p>
 * Do the above modifications to the input array in place, do not return anything from your function.
 */
public class DuplicateZeroes {
    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }

    public static void duplicateZeros(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int temp = 0;
                for (int j = i + 1; j < arr.length; j++) {
                    int a = arr[j];
                    arr[j] = temp;
                    temp = a;
                }
                i++;
            }
        }
    }
}
