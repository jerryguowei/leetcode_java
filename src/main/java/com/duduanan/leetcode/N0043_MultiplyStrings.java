package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 43. Multiply Strings
 * Medium
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class N0043_MultiplyStrings {

    @Test
    public void test() {
        String nums1 = "123", num2 = "456";
        Assertions.assertEquals("56088", multiply(nums1, num2));
    }
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        char[] num1Array = num1.toCharArray();
        char[] num2Array = num2.toCharArray();
        int[] res = new int[num1Array.length + num2Array.length];

        for(int i = num1Array.length - 1; i >=0; i--) {
            int c =  ((int)(num1Array[i] - '0'));
            int k =  num2Array.length + i;
            int carry = 0;

            for(int j = num2Array.length - 1; j >= 0; j--) {
                int d = ((int)(num2Array[j] - '0'));
                int val = d * c + carry + res[k];
                res[k] = val % 10;
                carry = val / 10;
                k--;
            }
            while(carry != 0){
                res[k] = carry % 10;
                carry = carry / 10;
                k--;
            }
        }
        String str = "";
        boolean flag = false;
        for(int val : res){
            if(val == 0 && flag == false){
                continue;
            } else {
                flag = true;
                str += val;
            }
        }
        return str;
    }
}
