package com.company.sorting;

import java.util.Arrays;

public class BubbleSort2 {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 6, 7, 1};
        bubbleSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort2(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    public static void bubbleSort(int[] arr) {
        for (int j = arr.length - 1; j >= 0; j--) {
            for (int i = 0; i < arr.length - 1; i++) {
                if (i == j) break;
                if (arr[i] > arr[i + 1]) {
                    swap(arr, i, i + 1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
