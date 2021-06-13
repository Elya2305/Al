package com.company.sorting;

import java.util.Arrays;

/**
 * Runtime: O(n log(n)) avg, worst case: o(n^2)
 * Memory: O(log(n))
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {182, 646, 545, 384, 89, 458, 633, 357, 569, 258};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = rearrange(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int rearrange(int[] arr, int low, int high) {
        int pivotElement = arr[high];
        int pointer = low;

        for (int i = low; i < high; i++) {
            if (arr[i] < pivotElement) {
                swap(arr, i, pointer);
                pointer++;
            }
        }
        swap(arr, pointer, high);
        return pointer;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
