package com.duduanan.leetcode;

import java.util.Stack;

public class N0316_RemoveDuplicateLetters {

    public String removeDuplicateLetters(String s) {
        boolean[] inStack = new boolean[26];
        int[] lastIndex = new int[26];
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if(inStack[c - 'a']) continue;
            while(!stack.empty() && stack.peek() > c && lastIndex[stack.peek() - 'a'] > i) {
                inStack[stack.pop() - 'a'] = false;
            }

            stack.push(c);
            inStack[c - 'a'] = true;
        }

        StringBuilder sb = new StringBuilder();
        while(!stack.empty()){
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        N0316_RemoveDuplicateLetters removeDuplicateLetters316 = new N0316_RemoveDuplicateLetters();

        System.out.println(removeDuplicateLetters316.removeDuplicateLetters("bcabc"));
    }
}

/**
 * 316. Remove Duplicate Letters
 * Medium
 *
 * 2673
 *
 * 194
 *
 * Add to List
 *
 * Share
 * Given a string s, remove duplicate letters so that every letter appears once and only once. You must make sure your result is the smallest in lexicographical order among all possible results.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "bcabc"
 * Output: "abc"
 * Example 2:
 *
 * Input: s = "cbacdcbc"
 * Output: "acdb"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 104
 * s consists of lowercase English letters.
 *
 *
 * Note: This question is the same as 1081: https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 *
 * Accepted
 * 123,936
 * Submissions
 * 312,188
 * */
