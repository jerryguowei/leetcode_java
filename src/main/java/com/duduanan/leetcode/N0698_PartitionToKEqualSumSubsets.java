package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 698. Partition to K Equal Sum Subsets
 * Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.
 */
public class N0698_PartitionToKEqualSumSubsets {
    @Test
    public void test() {
        int[] nums = {4,3,2,3,5,2,1};
        int k = 4;
        Assertions.assertTrue(canPartitionKSubsets(nums, k));
    }

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int a : nums) sum += a;
        int target = sum / k;
        if (sum % k != 0) return false;
        boolean[] used = new boolean[nums.length];
        return backtrack(k, nums, 0, used, 0, target);
    }

    private boolean backtrack(int k, int[] nums, int index, boolean[] used, int currentValue, int target) {
        if (k == 0) {
            return true;
        }
        if (currentValue == target) {
            return backtrack(k - 1, nums, 0, used, 0, target);
        }
        for (int i = index; i < nums.length; i++) {
            if (used[i]) continue;
            if (currentValue + nums[i] > target) continue;
            used[i] = true;
            currentValue += nums[i];
            if (backtrack(k, nums, i + 1, used, currentValue, target)) {
                return true;
            }
            used[i] = false;
            currentValue -= nums[i];
        }
        return false;
    }
}
