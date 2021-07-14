package com.duduanan.leetcode;

public class N070_ClimbingStairs {
    public static int climbStairs(int n) {
            if(n == 1) return 1;
            int[] r = new int[n + 1];
            r[1] = 1;
            r[2] = 2;

            for(int i = 3; i <= n; i++){
                r[i] = r[i-1] + r[i-2];
            }
            return r[n];
    }
    public static void  main(String[] args) {
        int n = 22;
        System.out.println(climbStairs(n));
    }
}


/**
 * 70. Climbing Stairs
 *
 * Add to List
 *
 * Share
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 *
 *
 * Constraints:
 *
 * 1 <= n <= 45
 **/
