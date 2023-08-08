package com.company.other.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String[] args) {
        SubsetSolution solution = new SubsetSolution();

        System.out.println(solution.subsets2(new int[]{1, 2, 3}));
    }
}

class SubsetSolution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(0, nums, result, new ArrayList<>());
        return result;
    }

    private void dfs(int i, int[] nums, List<List<Integer>> result, List<Integer> subset) {
        if (i >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }

        // decision to include nums[i]
        subset.add(nums[i]);
        dfs(i + 1, nums, result, subset);

        // decision NOT to include nums[i]
        subset.remove(subset.size() - 1);
        dfs(i + 1, nums, result, subset);
    }


    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(list, new ArrayList<>(), nums, 0);
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
}
