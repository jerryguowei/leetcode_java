package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 191. Number of 1
 * easy
 * Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the same, whether it is signed or unsigned.
 * In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input represents the signed integer. -3.
 */
public class N0191_NumberOf1Bits {

    @Test
    public void test() {
        int n = 0b00000000000000000000000000011011;
        Assertions.assertEquals(4, hammingWeight(n));
    }
    public int hammingWeight(int n) {
        int count = 0;
        // while(n != 0) {
        //     n = n & (n-1);
        //     count++;
        // }
        // return ;

        while(n != 0){
            if((n&1) != 0){
                count++;
            }
            n = n >>> 1;
        }
        return count;
    }
}
