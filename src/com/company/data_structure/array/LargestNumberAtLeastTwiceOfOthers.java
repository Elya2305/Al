package com.company.data_structure.array;

public class LargestNumberAtLeastTwiceOfOthers {

    /**
     * don't forget to read details;
     * 0 <= nums[i] <= 100!!!
     */
    public int dominantIndex(int[] nums) {
        if (nums.length == 1) return 0;

        int result = 0;
        int currMax = nums[0];
        int prevMax = nums[1];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > currMax) {
                prevMax = currMax;
                currMax = nums[i];
                result = i;
            } else {
                if (nums[i] > prevMax) {
                    prevMax = nums[i];
                }
            }

        }

        if (currMax >= prevMax * 2) {
            return result;
        }

        return -1;
    }

    public int dominantIndexBeautify(int[] nums) {
        int max = -1, index = -1, second = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                second = max;
                max = nums[i];
                index = i;
            } else if (nums[i] > second)
                second = nums[i];
        }
        return second * 2 <= max ? index : -1;
    }
}
