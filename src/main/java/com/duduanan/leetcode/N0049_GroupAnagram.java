package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 49. Group Anagrams
 * Medium
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */

public class N0049_GroupAnagram {

    @Test
    public void test() {
        String strs[] = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(String temp : strs) {
            char[] chr = temp.toCharArray();
            Arrays.sort(chr);
            String s = new String(chr);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(temp);
        }
        return map.values().stream().collect(Collectors.toList());
    }
}
