package com.company.data_structure.string;

import java.util.HashMap;
import java.util.Map;

public class IsUnique {
    public static void main(String[] args) {
        System.out.println(isUniqueWithoutDS("abc"));
        System.out.println(isUniqueWithoutDS("aabc"));

    }

    private static boolean isUnique(String val) {
        Map<Character, Boolean> totalChars = new HashMap<>();
        for (char i : val.toCharArray()) {
            Boolean present = totalChars.get(i);
            if (present != null) {
                return false;
            }
            totalChars.put(i, true);
        }
        return true;
    }
    private static boolean isUniqueCooler(String str) {
        if (str.length() > 128) {
            return false;
        }
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }
    private static boolean isUniqueWithoutDS(String val) {
        for (int i = 0; i < val.length(); i++) {
            for (int j = i + 1; j < val.length(); j++) {
                if (val.charAt(i) == val.charAt(j)) return false;
            }
        }
        return true;
    }

    private static boolean isUniqueAdvanced(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

}
