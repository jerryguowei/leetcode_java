package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N0322_CoinChange {
    @Test
    public void test() {
        int[] coins = {1, 2, 5};
        Assertions.assertEquals(3, coinChange(coins, 11));
    }
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            for(int c : coins){
                if(c > i) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i-c]);
            }
        }
        if(dp[amount] > amount) return -1;
        return dp[amount];
    }
}
