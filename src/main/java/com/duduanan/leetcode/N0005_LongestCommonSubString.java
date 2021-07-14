package com.duduanan.leetcode;

public class N0005_LongestCommonSubString {

    public String longestPalindrome(String s) {
        int m = 0, n = 0;

        for(int i = 0; i < s.length(); i++) {
            int a=i, b = i;
            while(a >=0 && b < s.length() && s.charAt(a) == s.charAt(b)) {
                a--;
                b++;
            }
            if((b-1) - (a+1) > n-m){
                m = a + 1;
                n = b -1;
            }
            // System.out.println(i + "#" + a + ":" + b);
            a=i ;
            b = i+1;
            while(a>=0 && b< s.length() && s.charAt(a) == s.charAt(b)){
                a--; b++;
            }
            if((b-1) - (a+1) > n-m){
                m = a + 1;
                n = b -1;
            }
        }
        return s.substring(m, n + 1);
    }
    public static void main(String[] args) {
        N0005_LongestCommonSubString longestCommonSubString5 = new N0005_LongestCommonSubString();
        String result = longestCommonSubString5.longestPalindrome("babad");
        System.out.println(result);
    }
}

/***
 * Given a string s, return the longest palindromic substring in s.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 * Example 3:
 *
 * Input: s = "a"
 * Output: "a"
 * Example 4:
 *
 * Input: s = "ac"
 * Output: "a"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consist of only digits and English letters (lower-case and/or upper-case),
 **/