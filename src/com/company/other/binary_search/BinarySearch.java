package com.company.other.binary_search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
//        System.out.println(search(arr, 2));

//        System.out.println(6 % 4);
        System.out.println(7 / 4);
        System.out.println(7 / 3);
    }

    public static int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private static int search(int[] nums, int target, int left, int right) {
        if (left > right) return -1;
        int mid = (left + right) / 2;
        int value = nums[mid];
        if (value == target) return mid;

        if (value > target) {
            return search(nums, target, left, mid - 1);
        } else {
            return search(nums, target, mid + 1, right);
        }
    }
}
