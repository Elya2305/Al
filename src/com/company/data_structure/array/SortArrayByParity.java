package com.company.data_structure.array;

import java.util.Arrays;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A,
 * followed by all the odd elements of A.
 * <p>
 * You may return any answer array that satisfies this condition.
 */
public class SortArrayByParity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArrayByParity(new int[]{3, 1, 2, 4})));
    }

    public static int[] sortArrayByParity(int[] A) {
        int lastParity = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0) {
                int temp = A[lastParity];
                A[lastParity++] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }
}
