package com.company.sorting;

public class Sort {
    public static void main(String[] args) {

    }
    /**
    * insertion algorithm
    *
    * (not checked)
    * */
    public static int[] sortedSquares(int[] nums) {
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
}
