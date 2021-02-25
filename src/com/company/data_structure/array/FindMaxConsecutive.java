package com.company.data_structure.array;

public class FindMaxConsecutive {
    public static void main(String[] args) {

    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int[] sizes = new int[nums.length];
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                sizes[i] = count;
                count = 0;
                continue;
            }
            count++;
        }
        if (count != 0) {
            sizes[nums.length - 1] = count;
        }
        int max = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i] > max) {
                max = sizes[i];
            }
        }
        return max;
    }

    public static int findMaxConsecutiveOnesRight(int[] nums) {
        int max = 0;
        int current = 0;
        for (int i : nums) {
            if (i == 1) {
                current++;
            } else {
                if (current > max) {
                    max = current;
                }
                if (max >= nums.length / 2) {
                    return max;
                }
                current = 0;
            }
        }
        return Math.max(max, current);
    }

}
