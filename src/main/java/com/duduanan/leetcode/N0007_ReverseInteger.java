package com.duduanan.leetcode;

/**
 * 7. Reverse Integer
 * Medium
 * Share
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1],
 * then return 0.
 * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
 */

public class N0007_ReverseInteger {

    public int reverse(int x) {
        boolean isNegative = x < 0;
        int res = 0;
        x = Math.abs(x);
        while(x > 0) {
            if(res > Integer.MAX_VALUE / 10) return 0;
            res = res * 10 + x % 10;
            x/=10;
        }
        if(isNegative) res *= -1;
        return res;
    }
}
