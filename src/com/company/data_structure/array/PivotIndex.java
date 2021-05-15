package com.company.data_structure.array;

public class PivotIndex {
    /**
     * O(n^2)
     */
    public int pivotIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int j = 0; j < i; j++) {
                sumLeft += nums[j];
            }
            for (int k = i + 1; k < nums.length; k++) {
                sumRight += nums[k];
            }
            if (sumLeft == sumRight) {
                return i;
            }
        }
        return -1;
    }

    public int pivotIndex2(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums) sum += x;
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]) return i;
            leftsum += nums[i];
        }
        return -1;
    }
}
