package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 1922. Count Good Numbers
 * Medium
 *
 * A digit string is good if the digits (0-indexed) at even indices are even and the digits at odd indices are prime (2, 3, 5, or 7).
 * For example, "2582" is good because the digits (2 and 8) at even positions are even and the digits (5 and 2) at odd positions are prime.
 * However, "3245" is not good because 3 is at an even index but is not even.
 * Given an integer n, return the total number of good digit strings of length n. Since the answer may be large, return it modulo 109 + 7.
 *
 * A digit string is a string consisting of digits 0 through 9 that may contain leading zeros.
 *
 *
 */
public class N1922_CountGoodNumbers {

    @Test
    public void test() {
        long a = 50;
        System.out.println(countGoodNumbers(a));
    }

    long mod = 1000000007;
    public int countGoodNumbers(long n) {
        long a = n / 2;
        long b = n / 2 + n % 2;
        long result = (quickPow(4, a) * quickPow(5, b)) % mod;
        return (int) result;
    }

//    public long mypow(long a, long k) {
//        if(k == 0) return 1;
//        if( k % 2 == 1){
//            return (a * mypow(a, k -1)) % mod;
//        } else {
//            long half = mypow(a, k/2);
//            return (half * half) % mod;
//        }
//    }

    public long quickPow(long a, long k) {
        long res = 1;
        a %= mod;
        while(k > 0) {
            if((k&1) == 1) {
                res = (res * a) % mod;
            }
            a = (a * a) % mod;
            k = k >>> 1;
        }
        return res;
    }
}
