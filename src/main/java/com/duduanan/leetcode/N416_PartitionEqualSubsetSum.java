package com.duduanan.leetcode;

import java.util.Arrays;

public class N416_PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean dp[] = new boolean[target + 1];
        dp[0] = true;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = target; j >= 1 && j >= nums[i-1]; j--) {
                dp[j] |= dp[j - nums[i - 1]];
            }
            if(dp[target] == true) return true;
        }
        return dp[target];
    }

    public boolean canPartition1(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if(sum % 2 != 0) return false;
        int target = sum / 2;
        boolean dp[][] = new boolean[nums.length + 1][target + 1];
        for(int i = 0; i <= nums.length; i++) dp[i][0] = true;

        for(int i = 1; i <= nums.length; i++) {
            for(int j = 1; j <= target; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= nums[i - 1]) dp[i][j] |= dp[i-1][j - nums[i - 1]];
            }
        }
        return dp[nums.length][target];
    }
}
