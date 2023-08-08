package com.company.other.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubsetWithDuplicates {
    public static void main(String[] args) {
        RememberSolutionWithoutDuplicates solution = new RememberSolutionWithoutDuplicates();

        System.out.println(solution.subsetsWithDup(new int[]{1, 2, 3}));
    }
}

class RememberSolutionWithoutDuplicates {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
//        subsetsIncorrect(result, new ArrayList<>(), new HashMap<>(), nums, 0);
        subsetsCorrect(result, new ArrayList<>(), new HashMap<>(), nums, 0);
        return result;
    }

    // correct [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    private void subsetsCorrect(List<List<Integer>> result, List<Integer> subset, Map<String, Boolean> considered, int[] nums, int start) {
        result.add(new ArrayList<>(subset));

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetsCorrect(result, subset, considered, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }


    // not correct [[1, 2, 3], [1, 3], [2, 3], [3]]
    private void subsetsIncorrect(List<List<Integer>> result, List<Integer> subset, Map<String, Boolean> considered, int[] nums, int start) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            subset.add(nums[i]);
            subsetsIncorrect(result, subset, considered, nums, i + 1);
            subset.remove(subset.size() - 1);
        }
    }
}
