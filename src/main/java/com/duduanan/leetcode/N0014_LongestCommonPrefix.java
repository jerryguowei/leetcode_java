package com.duduanan.leetcode;

public class N0014_LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        String common = strs[0];
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < strs.length; i++) {
            if(strs[i].equals(common)) continue;
            int j = 0;
            while(j < common.length() && j < strs[i].length() && common.charAt(j) == strs[i].charAt(j)) {
                sb.append(common.charAt(j));
                j++;
            }
            if(j == 0) return "";
            common = sb.toString();
            sb.setLength(0);
        }
        return common;
    }

    public static void main(String[] args) {
        N0014_LongestCommonPrefix longestCommonPrefix = new N0014_LongestCommonPrefix();
        String[] strs = new String[]{"flower","flow","flight"};
        System.out.println(longestCommonPrefix.longestCommonPrefix(strs));
    }
}
/**
 * 14. Longest Common Prefix
 * Easy
 *
 * 4364
 *
 * 2275
 *
 * Add to List
 *
 * Share
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 *
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 *
 *
 * */
