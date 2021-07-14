package com.duduanan.leetcode;

public class N0343_IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        int max = 1;
        for(int i= 2; i <=n; i++){
            for(int k = 1; k<= i-1; k++){
                max = Math.max(max, Math.max(k, dp[k]) * Math.max(i-k, dp[i-k]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
/***
 * Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.
 *
 * Return the maximum product you can get.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 * Example 2:
 *
 * Input: n = 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 *
 * Constraints:
 *
 * 2 <= n <= 58
 *
 */
