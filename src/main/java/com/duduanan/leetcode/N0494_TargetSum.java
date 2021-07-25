package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/***
 * 494. Target Sum
 * Medium
 * You are given an integer array nums and an integer target.
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 */
public class N0494_TargetSum {

    @Test
    public void test() {
        int nums[] = {1,1,1,1,1}, target = 3;
        Assertions.assertEquals(5, findTargetSumWays(nums,target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < target || (sum + target) % 2 == 1) {
            return 0;
        }
        return subsets(nums, (sum + target) / 2);
    }

    private int subsets(int[] nums, int sum) {
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = sum; j >= 0; j--) {
                if(j >= nums[i-1]){
                    dp[j] = dp[j] + dp[j - nums[i-1]];
                } else {
                    dp [j] = dp[j];
                }
            }
        }
        return dp[sum];
    }

//backtracking
//    private int count = 0;
//    public int findTargetSumWays(int[] nums, int target) {
//
//        helper(nums, 0, target);
//        return count;
//    }
//
//    public void helper(int[] nums, int k, int rest) {
//        if(k == nums.length){
//            if(rest == 0){
//                count++;
//            }
//            return;
//        }
//        int num = nums[k];
//        helper(nums, k + 1, rest -num);
//        helper(nums, k+1, rest + num);
//    }
}
