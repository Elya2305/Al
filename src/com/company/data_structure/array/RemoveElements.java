package com.company.data_structure.array;

import java.util.Arrays;

/**
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 */
public class RemoveElements {
    public static void main(String[] args) {
        System.out.println(removeElementRight(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }

    public static int removeElement(int[] nums, int val) {
        int totalRemove = 0;
        for (int i = 0; i + totalRemove < nums.length; i++) {
            if (nums[i] == val) {
                while (nums[nums.length - totalRemove - 1] == val && i < nums.length - totalRemove - 1) {
                    totalRemove++;
                }
                nums[i] = nums[nums.length - totalRemove - 1];
                nums[nums.length - totalRemove - 1] = val;
                totalRemove++;
            }
        }
        return nums.length - totalRemove;
    }

    public static int removeElementRight(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }
}
