package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N0003_LongestSubStringWithoutRepeatingCharacters {

    @Test
    public void test() {
        String s = "abcabcbb";
        Assertions.assertEquals(3, lengthOfLongestSubstring(s));
    }
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int res = 0;
        char[] sChar = s.toCharArray();
        int lo =0, hi = 0;
        while(hi < sChar.length) {
            char c = sChar[hi];
            count[c]++;
            if(count[c] > 1){
                res = Math.max(res, hi - lo);
                while(lo < hi){
                    char temp = sChar[lo++];
                    count[temp]--;
                    if(temp == c) break;
                }
            }
            hi++;
        }
        return Math.max(res, hi - lo);
    }
}
