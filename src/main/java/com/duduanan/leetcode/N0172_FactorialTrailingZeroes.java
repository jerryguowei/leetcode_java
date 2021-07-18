package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * 172. Factorial Trailing Zeroes
 * Easy
 *
 * Share
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Follow up: Could you write a solution that works in logarithmic time complexity?
 */
public class N0172_FactorialTrailingZeroes {
    @Test
    public void test() {
        int n = 128;
        Assertions.assertEquals(31, trailingZeroes(n));
    }

    public int trailingZeroes(int n) {
        int res = 0;
        while((n = n/5) > 0){
            res += n;
        }
        return res;
    }
}
