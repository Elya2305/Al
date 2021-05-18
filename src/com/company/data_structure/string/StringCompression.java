package com.company.data_structure.string;

import java.util.Arrays;

public class StringCompression {
    public static void main(String[] args) {
        System.out.println(compress("aabcccccaaa"));
//        System.out.println((char) ('0' + 1));

    }

    private static String compress2(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

            /* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    private static String compress(String val) {
        if (val.length() == 1) return val;

        int total = 1;
        char cur = val.charAt(0);
        for (int i = 1; i < val.length() - 1; i++) {
            if (cur != val.charAt(i)) {
                total++;
                cur = val.charAt(i);
            }
        }

        char[] newChars = new char[total * 2];

        int index = 0;
        int counter = 1;
        cur = val.charAt(0);

        for (int i = 1; i < val.length(); i++) {
            if (cur != val.charAt(i)) {
                newChars[index++] = cur;
                newChars[index++] = (char) ('0' + counter);
                cur = val.charAt(i);
                counter = 0;
            }
            counter++;
        }

        newChars[total * 2 - 2] = cur;
        newChars[total * 2 - 1] = (char) ('0' + counter);
        return new String(newChars);
    }
}
