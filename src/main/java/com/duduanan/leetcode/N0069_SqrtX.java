package com.duduanan.leetcode;

/**
 * 69. Sqrt(x)
 * Easy
 * Given a non-negative integer x, compute and return the square root of x.
 *
 * Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.
 *
 * Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.
 */
public class N0069_SqrtX {
    public int mySqrt(int x) {
        long l = 0, r = x;
        while(l < r) {
            long mid = l + r + 1 >> 1;
            if(mid * mid <= x) l = mid;
            else r = mid - 1;
        }
        return (int) l;
    }
}
