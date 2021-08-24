package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

/***
 * 474. Ones and Zeroes
 * You are given an array of binary strings strs and two integers m and n.
 *
 * Return the size of the largest subset of strs such that there are at most m 0's and n 1's in the subset.
 *
 * A set x is a subset of a set y if all elements of x are also elements of y.
 */
public class N0474OnesAndZeros {

    @Test
    public void test() {
        String strs[] = {"10","0001","111001","1","0"};
        int m = 5, n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int N = strs.length;
        int[] zeroCount = new int[N];
        int[] oneCount = new int[N];
        for(int i = 0; i < strs.length; i++) {
            for(char c : strs[i].toCharArray()){
                if('1' == c) oneCount[i]++;
                else zeroCount[i]++;
            }
        }
        int[][] dp = new int[m + 1][ n + 1];
        for(int i = 1; i <= N; i++){
            int zero =  zeroCount[i-1];
            int one =  oneCount[i-1];
            for(int j = m; j >= zero; j--){
                for(int k = n; k >= one; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j-zero][k - one] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
