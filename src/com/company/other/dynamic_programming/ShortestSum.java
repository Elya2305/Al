package com.company.other.dynamic_programming;

import java.util.*;

public class ShortestSum {
    public static void main(String[] args) {
//        int[] arr = new int[]{2, 3, 5};
//        int targetSum = 8;

        int[] arr = new int[]{1, 2, 5, 25};
        int targetSum = 100;

        ShortestSumSolution2 solution = new ShortestSumSolution2();
        System.out.println(Arrays.toString(solution.bestSum(targetSum, arr)));
    }
}


// todo can I add cache somewhere here as well?
// seems it's a little problematic because it uses state over all calls...
class ShortestSumSolution {

    // 7, [5,3,4,7] -> 7?
    // 8, [2,3,5] -> [3,5]
    public int[] bestSum(int targetSum, int[] arr) {
        List<Integer> res = new ArrayList<>();
        bestSum(targetSum, arr, new ArrayList<>(), res);
        return res.stream().mapToInt(o -> o).toArray();
    }

    private void bestSum(int targetSum, int[] arr, List<Integer> curr, List<Integer> result) {
        if (targetSum == 0) {
            if (curr.size() < result.size() || result.isEmpty()) {
                result.clear();
                result.addAll(curr);
                return;
            }
        }
        if (targetSum < 0) return;

        for (int i = 0; i < arr.length; i++) {
            curr.add(arr[i]);
            bestSum(targetSum - arr[i], arr, curr, result);
            curr.remove(curr.size() - 1);
        }
    }
}

class ShortestSumSolution2 {
    public int[] bestSum(int targetSum, int[] arr) {
        List<Integer> res = bestSumInternal(targetSum, arr, new HashMap<>());
        return res.stream().mapToInt(o -> o).toArray();
    }

    private List<Integer> bestSumInternal(int targetSum, int[] num, Map<Integer, List<Integer>> cache) {
        if (targetSum == 0) return new ArrayList<>();
        if (targetSum < 0) return null;
        if (cache.get(targetSum) != null) return cache.get(targetSum);

        List<Integer> shortestCombination = null;

        for (int i = 0; i < num.length; i++) {
            List<Integer> reminderCombination = bestSumInternal(targetSum - num[i], num, cache);

            if (reminderCombination != null) {
                List<Integer> combination = new ArrayList<>(reminderCombination); // O(m)
                combination.add(num[i]);
                if (shortestCombination == null || combination.size() < shortestCombination.size()) {
                    shortestCombination = combination;
                }
            }
        }

        cache.put(targetSum, shortestCombination);
        return shortestCombination;
    }
}

// n - nums.length; m - target
// Brute Force: O(n^m * m), S(m^2) - m stack calls * combination storage
// Memoized: O(n*m), S(m*m)
