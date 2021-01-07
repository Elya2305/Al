package com.company.array;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[] {0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                nums[i] = nums[i + 1];
                nums[i + 1] = 0;
            }
        }
        System.out.println(Arrays.toString(nums));
    }
}
