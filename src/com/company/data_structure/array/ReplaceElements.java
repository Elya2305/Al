package com.company.data_structure.array;

import java.util.Arrays;

/**
 * Given an array arr, replace every element in that array with the greatest element among
 * the elements to its right, and replace the last element with -1.
 */
public class ReplaceElements {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }

    public static int[] replaceElements(int[] arr) {
        for (int i = 0; i < arr.length - 1; ) {
            int maxIndex = greatestIndex(i + 1, arr);
            for (int j = i; j < maxIndex; j++) {
                arr[j] = arr[maxIndex];
            }
            i = maxIndex;
        }
        arr[arr.length - 1] = -1;
        return arr;
    }

    private static int greatestIndex(int start, int[] arr) {
        int max = arr[start];
        int res = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                res = i;
            }
        }
        return res;
    }

    public static int[] replaceElementsRight(int[] A) {
        int mx = -1, n = A.length, a;
        for (int i = n - 1; i >= 0; --i) {
            a = A[i];
            A[i] = mx;
            mx = Math.max(mx, a);
        }
        return A;
    }
}
