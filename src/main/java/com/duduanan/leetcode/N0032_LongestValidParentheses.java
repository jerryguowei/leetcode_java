package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N0032_LongestValidParentheses {
    @Test
    public void test() {
        String s = "(()";
        Assertions.assertEquals(2, longestValidParentheses(s));
    }
    public int longestValidParentheses(String s) {
        if(s.isEmpty()) return 0;
        char[] chr = s.toCharArray();
        int[]  dp = new int[s.length()];
        dp[0] = 0;
        int max =0;
        for(int i = 1; i < chr.length; i++){
            char c = chr[i];
            if(c == '('){
                dp[i] = 0;
            } else {
                if(i-1 - dp[i-1] >= 0 && chr[i-1 -dp[i-1]] == '(') {
                    dp[i] = i - (i-1 - dp[i-1]) + 1 + (i-1 - dp[i-1]-1 >=0 ? dp[i-1 - dp[i-1]-1] : 0);
                } else {
                    dp[i] = 0;
                }
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}
