package com.company.other.dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllConstruct {
    public static void main(String[] args) {
        String[] arr = new String[]{"ab", "abc", "cd", "def", "abcd", "ef", "c"};
        String target = "abcdef";

        String[] arr2 = new String[]{"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa"};
        String target2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaz";

        AllConstructSolution solution = new AllConstructSolution();
        System.out.println(solution.allConstructWithCache(arr, target));
        System.out.println(solution.allConstructWithCache(arr2, target2));
    }
}

class AllConstructSolution {
    public List<List<String>> allConstruct(String[] words, String target) {
        if (target.isEmpty()) return List.of(new ArrayList<>());

        List<List<String>> res = new ArrayList<>();

        for (String word : words) {

            if (target.startsWith(word)) { //O(m)
                List<List<String>> tempRes = allConstruct(words, target.replace(word, ""));
                tempRes.forEach(o -> o.add(0, word)); // O(m^2)
                res.addAll(tempRes);
            }
        }

        return res;
    }

    public List<List<String>> allConstructWithCache(String[] words, String target) {
        return allConstructWithCache(words, target, new HashMap<>());
    }

    private List<List<String>> allConstructWithCache(String[] words, String target, Map<String, List<List<String>>> cache) {
        if (target.isEmpty()) return List.of(new ArrayList<>());
        if (cache.containsKey(target)) return cache.get(target);

        List<List<String>> res = new ArrayList<>();

        for (String word : words) {

            if (target.startsWith(word)) { //O(m)
                List<List<String>> tempRes = allConstruct(words, target.replace(word, ""));
                tempRes.forEach(o -> o.add(0, word)); // O(m^2)
                res.addAll(tempRes);
            }
        }

        cache.put(target, res);
        return res;
    }
}

// n - words.length, m - target.size()
// Brute Force: O(n^m * ...), S(m)  -- we don't include the size of the output
//// Memoized: O(n^m * ...), S(m)

/// we need to *generate* all possible options, so we can't avoid this time complexity.
// Memoization performs better for cases where we cannot generate anything.
