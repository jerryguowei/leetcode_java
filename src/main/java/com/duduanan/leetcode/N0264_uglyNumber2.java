package com.duduanan.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 264. Ugly Number II
 * Medium
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *
 * Given an integer n, return the nth ugly number.
 *
 *
 */
public class N0264_uglyNumber2 {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n + 1];
        int p2 = 1, p3 = 1, p5 = 1;
        dp[1] = 1;

        for(int i = 2; i <=n; i++) {
            int v2 = dp[p2] * 2;
            int v3 = dp[p3] * 3;
            int v5 = dp[p5] * 5;
            int min = Math.min(v2, Math.min(v3, v5));
            dp[i] = min;
            if(min == v2) p2++;
            if(min == v3) p3++;
            if(min == v5) p5++;
        }
        return dp[n];
    }
    public int nthUglyNumber1(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1l);
        set.add(1l);
        int ugly = 0;
        for(int i = 0; i < n; i++) {
            long cur = pq.poll();
            ugly = (int) cur;
            for(int f : factors) {
                long next = cur * f;
                if(set.add(next)){
                    pq.offer(next);
                }
            }
        }
        return ugly;
    }
}
