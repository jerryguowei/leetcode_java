package com.duduanan.leetcode;

public class N1963_MinimumNumberOfSwapstoMakeTheStringBalanced {
    public int minSwaps(String s) {
        char[] c = s.toCharArray();
        int q1 = 0;
        int right = 0;
        int i = 0;
        int res = 0;
        while(i <= c.length -1){
            if(right == c.length/2) break;
            if(c[i] == ']'){
                if(q1 <= 0){
                    res++;
                    q1++;
                    right++;
                } else {
                    q1--;
                }
            } else {
                right++;
                q1++;
            }
            i++;
        }
        return res;
    }
}
