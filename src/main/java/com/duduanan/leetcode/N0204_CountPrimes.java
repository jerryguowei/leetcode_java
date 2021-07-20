package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 204. Count Primes
 * Easy
 * Count the number of prime numbers less than a non-negative number,
 */

public class N0204_CountPrimes {

    @Test
    public void test_countPrimes() {
        int n = 10;
        Assertions.assertEquals(4, countPrimes(n));
    }

    public int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        for(int i = 2; i*i <= n; i++){
            if(isPrim[i]){
                for(int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        int count = 0;
        for(int i = 2; i < n ; i++){
            if(isPrim[i]) count++;
        }
        return count;
    }

    public boolean isPrime(int k) {
        if(k < 2) return false;
        for(int i = 2; i * i <= k; i++) {
            if(k %i == 0) return false;
        }
        return true;
    }
}
