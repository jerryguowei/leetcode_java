package com.duduanan.leetcode;

public class N0392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {

        int j = 0;
        int i = 0;
        for(; i < s.length(); i++) {
            char c = s.charAt(i);
            boolean found = false;
            while(j < t.length())  {
                if(t.charAt(j++) == c) {
                    found = true;
                    break;
                }
            }
            if(!found) return false;
        }
        return i == s.length();
    }
    public static void main(String[] args) {
        N0392_IsSubsequence isSubsequence392 = new N0392_IsSubsequence();
        System.out.println(isSubsequence392.isSubsequence("abc", "ahbgdc"));
    }
}
/**
 * 392. Is Subsequence
 * Easy
 *
 * 2598
 *
 * 243
 *
 * Add to List
 *
 * Share
 * Given two strings s and t, return true if s is a subsequence of t, or false otherwise.
 *
 * A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc", t = "ahbgdc"
 * Output: true
 * Example 2:
 *
 * Input: s = "axc", t = "ahbgdc"
 * Output: false
 *
 *
 * Constraints:
 *
 * 0 <= s.length <= 100
 * 0 <= t.length <= 104
 * s and t consist only of lowercase English letters.
 *
 *
 * Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 * Accepted
 * 307,633
 * Submissions
 * 618,460
 *
 *
 * */