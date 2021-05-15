package com.company.data_structure.array;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 */
public class RotateArray {
    public static void main(String[] args) {
        rotate1(new int[]{1, 2, 3, 4, 5, 6, 7}, 10);
    }

    /**
     * Not a cool approach
     * memory - O(n)
     * time complexity - O(2*n) = O(n)
     */
    public static void rotate1(int[] nums, int k) {
        int[] temp = new int[nums.length];
        int startIndex = k % nums.length;

        for (int i = 0; i < temp.length; i++) {
            temp[i] = nums[i];
        }
        for (int num : temp) {
            nums[startIndex] = num;
            if (startIndex == nums.length - 1) {
                startIndex = 0;
            } else {
                startIndex++;
            }
        }
    }

    public static void rotate2(int[] nums, int k) {

    }
}
