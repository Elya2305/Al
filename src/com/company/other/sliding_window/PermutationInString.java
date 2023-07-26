package com.company.other.sliding_window;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInString {
    public static void main(String[] args) {
        MoreOptimalSolution test = new MoreOptimalSolution();
        System.out.println(test.checkInclusion("abc", "bbbca"));
    }
}

// O(n)
class MoreOptimalSolution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int left = 0;
        int right = s1.length() - 1;

        Map<Character, Integer> chars1 = initFromString(s1);
        Map<Character, Integer> chars2 = initFromString(s2.substring(0, right + 1));

        int i = 0;
        int matches = getMatchesNumber(chars1, chars2);

        while (++i < s2.length() && right + 1 < s2.length()) {
            if (matches == 26) return true;
            matches += removeChar(chars1, chars2, left, s2);
            matches += addChar(chars1, chars2, right + 1, s2);

            left++;
            right++;
        }
        return matches == 26;
    }

    private int removeChar(Map<Character, Integer> map1, Map<Character, Integer> map2, Integer index, String str) {
        boolean wasEqual = Objects.equals(map1.get(str.charAt(index)), map2.get(str.charAt(index)));
        map2.put(str.charAt(index), map2.get(str.charAt(index)) - 1);
        boolean nowEqual = Objects.equals(map1.get(str.charAt(index)), map2.get(str.charAt(index)));
        if (wasEqual && !nowEqual) {
            return -1;
        } else if (!wasEqual && nowEqual) {
            return 1;
        }
        return 0;
    }

    private int addChar(Map<Character, Integer> map1, Map<Character, Integer> map2, Integer index, String str) {
        boolean wasEqual = Objects.equals(map1.get(str.charAt(index)), map2.get(str.charAt(index)));
        map2.put(str.charAt(index), map2.getOrDefault(str.charAt(index), 0) + 1);
        boolean nowEqual = Objects.equals(map1.get(str.charAt(index)), map2.get(str.charAt(index)));
        if (wasEqual && !nowEqual) {
            return -1;
        } else if (!wasEqual && nowEqual) {
            return 1;
        }
        return 0;
    }

    private Map<Character, Integer> initFromString(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char ch : s.toCharArray()) {
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            chars.putIfAbsent(ch, 0);
        }

        return chars;
    }

    private int getMatchesNumber(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        int matches = 0;
        for (Map.Entry<Character, Integer> entry1 : map1.entrySet()) {
            if (Objects.equals(map2.get(entry1.getKey()), entry1.getValue())) {
                matches++;
            }
        }
        return matches;
    }
}

// O(26n) or not?
// S(n + m)
class O26SolutionWithHash {

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> chars1 = initFromString(s1);
        Map<Character, Integer> chars2 = new HashMap<>();
        int left = 0;
        int right = s1.length() - 1;
        int i = 0;

        while (i < s2.length()) {
            chars2.put(s2.charAt(i), chars2.getOrDefault(s2.charAt(i), 0) + 1);

            if (i == right) {
                if (isEqual(chars1, chars2)) {
                    return true;
                } else {
                    chars2.put(s2.charAt(left), chars2.get(s2.charAt(left)) - 1);
                    if (chars2.get(s2.charAt(left)) <= 0) {
                        chars2.remove(s2.charAt(left));
                    }
                    left++;
                    right++;
                }
            }
            i++;
        }
        return false;
    }

    private Map<Character, Integer> initFromString(String s) {
        Map<Character, Integer> chars = new HashMap<>();
        for (char ch : s.toCharArray()) {
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }

        return chars;
    }

    private boolean isEqual(Map<Character, Integer> map1, Map<Character, Integer> map2) {
        if (map1.size() != map2.size()) return false;

        for (Map.Entry<Character, Integer> entry1 : map1.entrySet()) {
            if (!Objects.equals(map2.get(entry1.getKey()), entry1.getValue())) {
                return false;
            }
        }
        return true;
    }
}


// what is the time/space complexity????
// O(n*m)
// S(n)
class VeryFirstSolution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> chars = new HashMap<>();
        initChars(chars, s1);

        int counter = 0;
        int i = 0;
        while (i < s2.length()) {
            Integer charCount = chars.get(s2.charAt(i));
            if (charCount != null && charCount > 0) {
                chars.put(s2.charAt(i), charCount - 1);
                counter++;
                i++;
                if (counter == s1.length()) return true;
            } else {
                i = i - counter + 1;
                counter = 0;
                initChars(chars, s1);
            }
        }

        return false;
    }

    private void initChars(Map<Character, Integer> chars, String s) {
        chars.clear();
        for (char ch : s.toCharArray()) {
            chars.put(ch, chars.getOrDefault(ch, 0) + 1);
        }
    }
}
