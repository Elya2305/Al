package com.company.data_structure.string;

public class Permutation {
    public static void main(String[] args) {
        System.out.println(isPermutation("abc", "abc"));
        System.out.println(isPermutation("bac", "abc"));
        System.out.println(isPermutation("aabc", "abc"));
        System.out.println(isPermutation("cab", "abc"));
        System.out.println(isPermutation("aaa", "aba"));
    }

    /**
     * O(n)
     */
    private static boolean isPermutation(String val1, String val2) {
        if (val1.length() != val2.length()) return false;
        int[] buffer = new int[128];
        for (int i = 0; i < val1.length(); i++) {
            buffer[val1.charAt(i)] = buffer[val1.charAt(i)] + 1;
            buffer[val2.charAt(i)] = buffer[val2.charAt(i)] - 1;
        }
        for (int i : buffer) {
            if (i != 0) return false;
        }
        return true;
    }
}
