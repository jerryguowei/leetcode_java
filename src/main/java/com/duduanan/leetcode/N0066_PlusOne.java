package com.duduanan.leetcode;

public class N0066_PlusOne {
    public int[] plusOne(int[] digits) {
        int r = 1;
        int mod = 0;
        for(int i = digits.length - 1; i >= 0; i--){
            mod = (digits[i] + r) % 10;
            r = (digits[i] + r) / 10;
            digits[i] = mod;
        }
        if(r != 0){
            int[] result = new int[digits.length + 1];
            result[0] = r;
            for(int i = 1; i < result.length; i++){
                result[i] = digits[i-1];
            }
            return result;
        }  else {
            return digits;
        }
    }
}
