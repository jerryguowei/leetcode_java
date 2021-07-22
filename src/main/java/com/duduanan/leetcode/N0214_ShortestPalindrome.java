package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 214. Shortest Palindrome
 * Hard
 * You are given a string s. You can convert s to a palindrome by adding characters in front of it.
 *
 * Return the shortest palindrome you can find by performing this transformation.
 *
 *
 */
public class N0214_ShortestPalindrome {

    @Test
    public void test() {
        String result = shortestPalindrome("aacecaaa");
        System.out.println(result);
    }
    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse().toString();
        int i = lps(temp);

        return new StringBuilder(s.substring(i)).reverse().toString() + s;
    }

    public int lps(String p) {
        int[] lps = new int[p.length()];
        lps[0] = 0;
        int l = 0, i = 1;
        while (i < p.length()) {
            if (p.charAt(l) == p.charAt(i)) {
                lps[i] = l + 1;
                i++;
                l++;
            } else {
                if(l > 0){
                    l = lps[l-1];
                } else {
                    i++;
                }
            }
        }
        return lps[p.length() - 1];
    }
}



class Solution_214 {
    public String shortestPalindrome(String s) {
        if(s.length() <= 1) return s;
        char[] charArray = s.toCharArray();
        int start = 1;

        for(int m = (charArray.length - 1) / 2; m >=0 ; m--) {
            int i = m -1, j = m+1;
            while(i >= 0 && j < charArray.length && charArray[i] == charArray[j]) {
                i--;
                j++;
            }
            if(i < 0) start = Math.max(start, j);

            i= m-1; j=m;
            while(i >= 0 && j <= charArray.length - 1 && charArray[i] == charArray[j]){
                i--;
                j++;
            }
            if(i < 0) start = Math.max(start, j);
            if(start > 1) break;
        }
        return (start < s.length() ? new StringBuilder(s.substring(start)).reverse() : "") + s;
    }
}