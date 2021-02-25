package com.company.data_structure.array;

import java.util.HashSet;
import java.util.Set;

public class CheckIfExists {
    public static void main(String[] args) {
        System.out.println(checkIfExist2(new int[]{4,-7,11,4,18}));
    }

    /**
     * O(n*n)
     */
    public static boolean checkIfExist(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] == 2 * arr[j] || arr[j] == 2 * arr[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean checkIfExist2(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(j * 2)) return true;
            if (j % 2 == 0) {
                if (set.contains(j / 2)) return true;
            }
            set.add(j);
        }
        return false;
    }
}
