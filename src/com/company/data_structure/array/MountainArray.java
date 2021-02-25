package com.company.data_structure.array;

public class MountainArray {
    public static void main(String[] args) {
        System.out.println(validMountainArray(new int[]{4, 3, 2, 1}));
    }

    public static boolean validMountainArray(int[] arr) {
        if (arr.length < 3 || arr[0] > arr[1]) return false;
        boolean stopDecrease = false;
        int previous = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == previous) return false;
            if (arr[i] < previous) {
                stopDecrease = true;
            }
            if (arr[i] > previous && stopDecrease) {
                return false;
            }
            previous = arr[i];
        }
        return stopDecrease;
    }
}
