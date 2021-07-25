package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 516. Longest Palindromic Subsequence
 * Medium
 * Given a string s, find the longest palindromic subsequence's length in s.
 * A subsequence is a sequence that can be derived from another sequence by deleting some or no elements without changing the order of the remaining elements.
 */
public class N0516_LongestPalindromicSubsequence {
    @Test
    public void test() {
        String s = "bbbab";
        Assertions.assertEquals(4, longestPalindromeSubseq(s));
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int i = s.length() - 2; i >=0; i--) {
            for(int j =  i + 1; j < n; j++){
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }
}
