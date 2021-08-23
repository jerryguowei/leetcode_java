package com.duduanan.leetcode;

/***
 * 313. Super Ugly Number
 * Medium
 * A super ugly number is a positive integer whose prime factors are in the array primes.
 *
 * Given an integer n and an array of integers primes, return the nth super ugly number.
 *
 * The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class N0313_SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp  = new int[n];
        dp[0] = 1;
        int[] pos = new int[primes.length];

        for(int i = 1; i < n; i++) {
            int[] temp = new int[primes.length];
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++){
                temp[j] = primes[j] * dp[pos[j]];
                min = Math.min(min, temp[j]);
            }
            for(int j = 0; j < temp.length; j++){
                if(temp[j] == min) pos[j]++;
            }
            dp[i] =min;

        }
        return dp[n-1];
    }
}
