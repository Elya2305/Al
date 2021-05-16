package com.company.data_structure.string;

import java.util.Arrays;
import java.util.Locale;

public class PalindromePermutation {
    public static void main(String[] args) {
        System.out.println(Character.getNumericValue('B'));
        System.out.println(Character.getNumericValue('b'));
//        System.out.println(isPermutationOfPalindrome("Tasct Coa"));
    }

    private static boolean isPalindromePermutation(String val) {
        val = val.toLowerCase(Locale.ROOT).replace(" ", "");
        int[] buffer = new int[128];
        for (int i = 0; i < val.length(); i++) {
            buffer[val.charAt(i)] = buffer[val.charAt(i)] + 1;
        }
        int total1 = 0;

        for (int curr : buffer) {
            if (curr != 0 && curr != 1 && curr != 2) return false;
            if (curr == 1) total1++;
        }

        return total1 == 1 || total1 == 0;
    }

///////////////////////////////////// ANSWER ////////////////////////////////////////////////


    public static boolean isPermutationOfPalindrome(String phrase) {
        int[] table = buildCharFrequencyTable(phrase);
        return checkMaxOneOdd(table);
    }

    public static int getCharNumber(Character c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        int val = Character.getNumericValue(c);
        if (a <= val && val <= z) {
            return val - a;
        }
        return -1;
    }

    public static int[] buildCharFrequencyTable(String phrase) {
        int[] table = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
        for (char c : phrase.toCharArray()) {
            int x = getCharNumber(c);
            if (x != -1) {
                table[x]++;
            }
        }
        return table;
    }

    public static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;
        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) {
                    return false;
                }
                foundOdd = true;
            }
        }
        return true;
    }
}
