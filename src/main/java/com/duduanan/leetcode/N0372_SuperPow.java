package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * 372. Super Pow
 * Medium
 * Your task is to calculate ab mod 1337 where a is a positive integer and b is an extremely large positive integer given in the form of an array.
 */
public class N0372_SuperPow {

    @Test
    public void test_superPow() {
        int a = 2147483647;
        int[] b = {2,0, 0};
        Assertions.assertEquals(1198, superPow(a, b));
    }

    private int mod = 1337;
    public int superPow(int a, int[] b) {
        int res = 1;
        for(int i = 0; i < b.length; i++) {
            res = (quickpow(res, 10) * quickpow(a, b[i])) % mod;
        }
        return res;
    }

    private int quickpow(int a, int k) {
        int res = 1;
        a %=mod;
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
