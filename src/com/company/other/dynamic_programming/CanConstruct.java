package com.company.other.dynamic_programming;

public class CanConstruct {
    public static void main(String[] args) {
        String[] arr1 = new String[]{"def", "ab", "abc", "cd", "abcd"};
        String target1 = "abcdef";

        String[] arr2 = new String[]{"cde", "abf"};
        String target2 = "abcdef";

        String[] arr3 = new String[]{"e", "ee", "eee", "eeee", "eeeee", "eeeeee", "eeeeeee"};
        String target3 = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef";

        System.out.println(CanConstructSolution.canConstruct(arr1, target1));
        System.out.println(CanConstructSolution.canConstruct(arr2, target2));
        System.out.println(CanConstructSolution.canConstruct(arr3, target3));
    }
}


class CanConstructSolution {
    // [ab, abc, cd, def, abcd], abcdef -> true (abc + def)
    public static boolean canConstruct(String[] words, String target) {
        if (target.isEmpty()) {
            return true;
        }

        for (String word : words) {
            if (target.startsWith(word) || target.endsWith(word)) { //O(n)
                boolean canConstruct = canConstruct(words, target.replace(word, "")); //O(n)
                if (canConstruct) return true;
            }
        }

        return false;
    }
}

// O(n^m * m) -> O(n * m^2) if add cache
