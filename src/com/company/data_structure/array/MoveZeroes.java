package com.company.data_structure.array;

public class MoveZeroes {
    public static void main(String[] args) {
        moveZeroes(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
    }

    public static void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                int temp = 0;
                for (int j = i + 1; j < nums.length; j++) {
                    int a = nums[j];
                    nums[j] = temp;
                    temp = a;
                }
                i++;
            }
        }
    }
}
