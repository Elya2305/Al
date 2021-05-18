package com.company.data_structure.string;

import java.util.*;

public class LongestStringChain {
    public static void main(String[] args) {
        System.out.println(longestStrChain2(new String[]{"abcd", "abc", "bcd", "abd", "ab", "ad", "b"}));

    }

    public static int longestStrChain2(String[] words) {
        Map<String, Integer> dp = new HashMap<>();

        // Sorting the list in terms of the word length.
        Arrays.sort(words, (a, b) -> a.length() - b.length());

        int longestWordSequenceLength = 1;

        for (String word : words) {
            int presentLength = 1;
            // Find all possible predecessors for the current word by removing one letter at a time.
            for (int i = 0; i < word.length(); i++) {
                StringBuilder temp = new StringBuilder(word);
                temp.deleteCharAt(i);
                String predecessor = temp.toString();
                int previousLength = dp.getOrDefault(predecessor, 0);
                presentLength = Math.max(presentLength, previousLength + 1);
            }
            dp.put(word, presentLength);
            longestWordSequenceLength = Math.max(longestWordSequenceLength, presentLength);
        }
        return longestWordSequenceLength;
    }

    private static int dfs(Set<String> words, Map<String, Integer> memo, String currentWord) {
        // If the word is encountered previously we just return its value present in the map (memoization).
        if (memo.containsKey(currentWord)) {
            return memo.get(currentWord);
        }
        // This stores the maximum length of word sequence possible with the 'currentWord' as the
        int maxLength = 1;
        StringBuilder sb = new StringBuilder(currentWord);

        // creating all possible strings taking out one character at a time from the `currentWord`
        for (int i = 0; i < currentWord.length(); i++) {
            sb.deleteCharAt(i);
            String newWord = sb.toString();
            // If the new word formed is present in the list, we do a dfs search with this newWord.
            if (words.contains(newWord)) {
                int currentLength = 1 + dfs(words, memo, newWord);
                maxLength = Math.max(maxLength, currentLength);
            }
            sb.insert(i, currentWord.charAt(i));
        }
        memo.put(currentWord, maxLength);

        return maxLength;
    }

    public static int longestStrChain(String[] words) {
        Map<String, Integer> memo = new HashMap<>();
        Set<String> wordsPresent = new HashSet<>();
        Collections.addAll(wordsPresent, words);
        int ans = 0;
        for (String word : words) {
            ans = Math.max(ans, dfs(wordsPresent, memo, word));
        }
        return ans;
    }
}

/*
public class LongestStringChain {
    public static void main(String[] args) {
//        System.out.println(oneChar("bdca", "dca"));
//        System.out.println(oneChar("dca", "ca"));
//        System.out.println(oneChar("ca", "a"));
        System.out.println(longestStrChain(new String[]{"bdca","bda","ca","dca","a"}));
//        System.out.println(longestStrChain(new String[]{"a","b","ba","bca","bda","bdca"}));
//        System.out.println(longestStrChain(new String[]{"bca", "bbb", "ac", "c"}));

    }

    public static int longestStrChain(String[] words) {
        sort(words);

        int max = 0;

        int curr = 0;
        System.out.println(Arrays.toString(words));
        while (curr < words.length) {
            System.out.println("==================");
            int next = curr;
            int currMax = 1;
            for (int i = curr + 1; i < words.length; i++) {
                System.out.println(words[next] + " " + words[i]);
//                System.out.println("CURRENT: " + words[curr]);
                if (words[next].length() - words[i].length() == 1) {
                    if (oneChar(words[next], words[i])) {
                        currMax++;
                        next = i;
                    }
                }
            }
            if (currMax > max) max = currMax;
            if (max == words[curr].length()) break;
            curr++;
        }

        return max;
    }

    private static boolean oneChar(String val1, String val2) {
        char[] chars1 = val1.toCharArray();
        char[] chars2 = val2.toCharArray();

        boolean inserted = false;
        int index1 = 0;
        int index2 = 0;

        while (index1 < val1.length() && index2 < val2.length()) {
            if (chars1[index1] != chars2[index2]) {
                if (inserted) return false;
                inserted = true;
                index1++;
                continue;
            }
            index1++;
            index2++;
        }
        return inserted || index1 == val1.length() - 1;
    }

    */
/**
 * selection sort
 *//*

    private static void sort(String[] words) {
        for (int i = 0; i < words.length; i++) {
            int max = i;
            for (int j = i; j < words.length; j++) {
                if (words[j].length() > words[max].length()) {
                    max = j;
                }
            }
            String temp = words[i];
            words[i] = words[max];
            words[max] = temp;
        }
    }
}
*/
