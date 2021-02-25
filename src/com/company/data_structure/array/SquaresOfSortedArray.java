package com.company.data_structure.array;

import java.util.Arrays;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * return an array of the squares of each number sorted in non-decreasing order.
 */
public class SquaresOfSortedArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquaresRight(new int[]{5, 6, 3})));
    }

    /*
     * insertion sort
     * */
    public static int[] sortedSquares(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                for (int j = i + 1; j > 0; j--) {
                    if (nums[j - 1] < nums[j]) break;
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }

    public static int[] sortedSquaresRight(int[] A) {
        int n = A.length;
        int[] result = new int[n];
        int i = 0, j = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                result[p] = A[i] * A[i];
                i++;
            } else {
                result[p] = A[j] * A[j];
                j--;
            }
        }
        return result;
    }
}
