package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without
 * changing the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
public class N0300_LongestIncreaingSubsequence {
    @Test
    public void test() {
        int[] nums = {10, 9, 2, 5,3,7,101,18};
        Assertions.assertEquals(4, lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }

        //pocker
    public int lengthOfLIS1(int[] nums) {
        int[] top = new int[nums.length];
        int piles = 0;
        for(int i = 0; i < nums.length; i++) {
            int pocker = nums[i];
            int left = 0, right = piles;

            while(left < right) {
                int mid = (left + right) / 2;
                if(top[mid] >= pocker) {
                    right = mid;
                } else if(top[mid] < pocker) {
                    left = mid + 1;
                }
            }
            if(left == piles) piles++;
            top[left] = pocker;

        }

        return piles;
    }
}
