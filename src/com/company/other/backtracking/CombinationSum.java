package com.company.other.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = new int[]{1, 2, 3};
        int target = 3;

        CombinationSumSolution solution = new CombinationSumSolution();
        System.out.println(solution.combinationSum(candidates, target)); // [[2,2,3],[7]]
    }
}

class CombinationSumSolution {

    // well... I've tried... Let's then just see how smart people are solving this.......
 /*   public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (sum > target) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[start]);
            sum += candidates[start];
            backtrack(result, combination, candidates, target, sum, start);

            sum -= combination.get(combination.size() - 1);
            combination.remove(combination.size() - 1);
            backtrack(result, combination, candidates, target, sum, start + 1);
        }
    }*/

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combination(result, new ArrayList<>(), candidates, target, 0, 0);
        return result;
    }


    private void combination(List<List<Integer>> result, List<Integer> combination, int[] candidates, int target, int sum, int start) {
        if (sum > target) return; //backtrack
        if (sum == target) {
            result.add(new ArrayList<>(combination)); //store the solution and backtrack
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (sum + candidates[i] > target) return; // small improvement for sorted array
            combination.add(candidates[i]);
            sum += candidates[i];
            combination(result, combination, candidates, target, sum, i); //try with this combination, whether it gives a solution or not.
            sum -= combination.get(combination.size() - 1);
            combination.remove(combination.size() - 1);
        }
    }
}
