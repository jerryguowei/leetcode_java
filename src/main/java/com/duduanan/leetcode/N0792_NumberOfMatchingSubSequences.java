package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N0792_NumberOfMatchingSubSequences {

    @Test
    public void test() {
        String s = "dsahjpjauf", words[] = { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" };
        System.out.println(numMatchingSubseq(s, words));
    }
    public int numMatchingSubseq(String s, String[] words) {
        List<StringBuilder>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; i++) {
            heads[i] = new ArrayList<>();
        }
        for (String word : words) {
            heads[word.charAt(0) - 'a'].add(new StringBuilder(word));
        }
        int count = 0;
        for (char c : s.toCharArray()) {
            List<StringBuilder> sameFirstCharList = heads[c - 'a'];
            if (sameFirstCharList == null || sameFirstCharList.isEmpty()) continue;
            heads[c - 'a'] = new ArrayList<>();
            for (StringBuilder w : sameFirstCharList) {
                if (w.length() == 1) {
                    count++;
                    continue;
                }
                w.deleteCharAt(0);
                heads[w.charAt(0) - 'a'].add(w);
            }
        }
        return count;
    }
}
