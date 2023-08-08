package com.company.other.backtracking;

import java.util.*;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int[] nums2 = new int[]{1, 2, 3};

        Map<String, Boolean> map = new HashMap<>();

        map.put(Arrays.toString(nums), true);
        map.put(Arrays.toString(nums2), true);

        System.out.println(map);

//        System.out.println(Arrays.equals(nums, nums2));

//        PermutationsSolution1 solution1 = new PermutationsSolution1();
//        solution1.permute(nums);
//
//        PermutationsSolution2 solution2 = new PermutationsSolution2();
//        System.out.println(solution2.permute2(nums));
    }
}

// not optimal one, but I did it myself
class PermutationsSolution1 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permute(result, new ArrayList<>(), nums, new ArrayList<>());
        return result;
    }

    private void permute(List<List<Integer>> result, List<Integer> temp, int[] nums, List<Integer> included) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int num : nums) {
            if (!included.contains(num)) {
                temp.add(num);
                included.add(num);

                permute(result, temp, nums, included);

                temp.remove(temp.size() - 1);
                included.remove(included.size() - 1);
            }
        }
    }
}

class PermutationsSolution2 {

    // okay, now I see why python is better for algorithm problems...
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.length == 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(List.of(nums[0])));
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            int n = nums[0];
            int[] popedArray = Arrays.copyOfRange(nums, 1, nums.length);
            var perms = permute(popedArray);

            for (var perm : perms) {
                perm.add(n);
                result.add(perm);
            }
            nums = Arrays.copyOf(popedArray, popedArray.length + 1);
            nums[nums.length - 1] = n;
        }
        return result;
    }


    public List<List<Integer>> permute2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return permute2(list);
    }

    private List<List<Integer>> permute2(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums.size() == 1) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(nums);
            return res;
        }

        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(0);
            nums.remove(0); // todo mb replace with queue?
            var perms = permute2(new ArrayList<>(nums));

            for (var perm : perms) {
                perm.add(n);
                result.add(perm);
            }
            nums.add(n);
        }
        return result;
    }
}
