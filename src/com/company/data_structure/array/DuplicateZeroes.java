package com.company.data_structure.array;

public class DuplicateZeroes {
    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }

    // todo
    public static void duplicateZeros(int[] arr) {
        int prev = arr[0];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = prev;
            if (arr[i] == 0) {
            }
        }
    }
}
