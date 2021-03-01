package com.company.data_structure.array;

/**
 * Given an array nums, write a function to move all 0's to
 * the end of it while maintaining the relative order of the non-zero elements.
 */
public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{0, 1, 0, 3, 12});
    }

    public static void moveZeroes(int[] nums) {
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zero == -1) {
                zero = i;
            }
            if (nums[i] != 0 && zero != -1) {
                nums[zero] = nums[i];
                nums[i] = 0;
                zero += 1;
            }
        }
    }
}
