package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 890. Find and Replace Pattern
 * Medium
 * Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.
 *
 * A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.
 *
 * Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.
 */
public class N0890_FindAndReplacePattern {
    @Test
    public void test() {
        String[] words = {"abc", "deq", "mee", "aqq", "dkd", "ccc"};
        String pattern = "abb";
        List<String> result = findAndReplacePattern(words, pattern);
        System.out.println(result);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        char[] p = pattern.toCharArray();
        char empty = (char) 0;
        List<String> res = new ArrayList<>();
        for(String w : words) {
            if(w.length() != p.length) continue;
            char[] temp = new char[26];
            char[] temp1 = new char[26];
            boolean has = true;
            for(int i = 0; i < p.length; i++){
                char c = w.charAt(i);
                if(temp[c - 'a'] == empty) {
                    temp[c-'a'] = p[i];
                } else if(temp[c-'a'] != p[i]){
                    has = false;
                    break;
                }
                if(temp1[p[i]- 'a'] == empty) {
                    temp1[p[i] -'a'] = c;
                } else if(temp1[p[i] - 'a'] != c){
                    has = false;
                    break;
                }
            }
            if(has) res.add(w);
        }
        return res;
    }
}
