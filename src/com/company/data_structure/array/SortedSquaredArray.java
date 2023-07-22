package com.company.data_structure.array;

import java.util.Arrays;

public class SortedSquaredArray {
}

class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, -1, 1, 2};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selectionSort(int[] arr) {
        int currentMinimumIndex;

        for (int i = 0; i < arr.length; i++) {
            currentMinimumIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[currentMinimumIndex]) {
                    currentMinimumIndex = j;
                }
            }
            swap(arr, i, currentMinimumIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}