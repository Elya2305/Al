package com.company.data_structure.array;

/**
 * Given an array nums of integers, return how many of
 * them contain an even number of digits.
 */
public class FindNumbers {
    public static void main(String[] args) {

    }

    public static int findNumbers(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (totalDigits(num) % 2 == 0) count++;
        }
        return count;
    }

    static int totalDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
