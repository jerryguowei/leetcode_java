package com.duduanan.leetcode;

/**
 * 793. Preimage Size of Factorial Zeroes Function
 * Hard
 * Let f(x) be the number of zeroes at the end of x!. Recall that x! = 1 * 2 * 3 * ... * x and by convention, 0! = 1.
 *
 * For example, f(3) = 0 because 3! = 6 has no zeroes at the end, while f(11) = 2 because 11! = 39916800 has two zeroes at the end.
 * Given an integer k, return the number of non-negative integers x have the property that f(x) = k.
 */
public class N0793_PreimageSizeOfFactorialZeroesFunction {
    public int preimageSizeFZF(int k) {
        return (int)(highBond(k) - lowerBond(k) + 1);
    }

    private long trailingZeroes(long n) {
        long res = 0;
        for (long d = n; d / 5 > 0; d = d / 5) {
            res += d / 5;
        }
        return res;
    }

    private long lowerBond(long k) {
        long low = 0;
        long hi = Long.MAX_VALUE;
        while(low < hi) {
            long mid =  low + (hi-low)/2;
            long t = trailingZeroes(mid);
            if(t > k) {
                hi = mid;
            } else if(t < k){
                low = mid + 1;
            } else {
                hi= mid;
            }
        }
        System.out.println(low);
        return low;
    }

    private long highBond(long k) {
        long low = 0;
        long hi = Long.MAX_VALUE;
        while(low < hi) {
            long mid =  low + (hi-low)/2;
            long t = trailingZeroes(mid);
            if(t > k) {
                hi = mid;
            } else if(t < k){
                low = mid + 1;
            } else {
                low= mid + 1;
            }
        }
        return low -1 ;
    }
}
