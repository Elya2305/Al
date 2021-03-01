package com.company.data_structure.array;

/**
 * Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int curr = nums[0];
        int availableIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != curr) {
                nums[availableIndex++] = nums[i];
                curr = nums[i];
            }
        }
        return availableIndex;
    }
}
