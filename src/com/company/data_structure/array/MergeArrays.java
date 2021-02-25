package com.company.data_structure.array;

import java.util.Arrays;

public class MergeArrays {
    public static void main(String[] args) {
        merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int index = 0, j = 0; index < m + n && j < n; index++) {
            if (nums1[index] > nums2[j]) {
                int toReplace = nums1[index];
                nums1[index] = nums2[j];
                nums2[j] = 0;
//                replace(nums2,  toReplace);
            }
//            if(nums1[index] == nums2[j]) j++;
            if (nums1[index] == 0) {
                nums1[index] = nums2[j++];
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

    }

//    private static void replace(int[] arr, int toReplace) {
//        if (arr.length == 1) {
//            arr[0] = toReplace;
//        }
//        for (int i = 0; i < arr.length - 1; i++) {
//            if (arr[i] == fromArr && arr[i + 1] > toReplace) {
//                arr[i] = toReplace;
//            }
//        }
//    }
}
