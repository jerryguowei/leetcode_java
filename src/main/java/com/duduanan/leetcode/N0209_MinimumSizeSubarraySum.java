package com.duduanan.leetcode;

/**
 * 209. Minimum Size Subarray Sum
 * Medium
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target.
 * If there is no such subarray, return 0 instead.
 */
public class N0209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] s = new int[n + 1];
        for(int i = 1; i <= n; i++) s[i] = s[i-1] + nums[i-1];
        int l = 1, r = 1;
        int minRes = Integer.MAX_VALUE;
        while(l <= n && r <= n) {
            while(s[r] - s[l-1] >= target) {
                minRes = Math.min(r - l + 1, minRes);
                l++;
            }
            r++;
        }
        if(minRes == Integer.MAX_VALUE) return 0;
        return minRes;
    }
}
