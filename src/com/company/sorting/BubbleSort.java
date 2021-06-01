package com.company.sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 3};
        recursiveBubbleSort(arr, 4);
        System.out.println(Arrays.toString(arr));
    }

    public void bubbleSort(int[] arr, int n) {
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void recursiveBubbleSort(int[] arr, int n) {
        if (n == 1) return;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        recursiveBubbleSort(arr, n - 1);
    }
}
