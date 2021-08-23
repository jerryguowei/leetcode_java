package com.duduanan.leetcode;

/**
 * 518. Coin Change 2
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the number of combinations that make up that amount. If that amount of money cannot be made up by any combination of the coins, return 0.
 * You may assume that you have an infinite number of each kind of coin.
 * The answer is guaranteed to fit into a signed 32-bit integer.
 */
public class N0518_CoinChange2 {

    public int change(int amount, int[] coins) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1]; //nums of combination
        for(int i = 0; i <=n; i++) {
            dp[i][0] = 1;
        }
        for(int i = 1; i <=n; i++) {
            for(int j = 1; j <= amount; j++) {
                dp[i][j] = dp[i-1][j];
                if(j >= coins[i-1]) {
                    dp[i][j] += dp[i][j-coins[i-1]];
                }
            }
        }
        return dp[n][amount];
    }
}
