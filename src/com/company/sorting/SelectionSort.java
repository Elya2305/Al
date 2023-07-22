package com.company.sorting;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4, 3, 2, 6, 7, 1};
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

class Program {
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
        int i = -1;
        int j = -1;

        while (i < array.size()) {
            if (array.get(i + 1).equals(sequence.get(j + 1))) {
                i++;
                j++;
            } else {
                i++;
            }

        }

        return j == sequence.size() - 1;
    }
}