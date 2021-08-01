package com.duduanan.leetcode;

import java.util.*;

/***
 * 398. Random Pick Index
 * Medium
 * Given an integer array nums with possible duplicates, randomly output the index of a given target number.
 * You can assume that the given target number must exist in the array.
 *
 * Implement the Solution class:
 *
 * Solution(int[] nums) Initializes the object with the array nums.
 * int pick(int target) Picks a random index i from nums where nums[i] == target.
 * If there are multiple valid i's, then each index should have an equal probability of returning.
 */
public class N0398_RandomPickIndex {

    Map<Integer, List<Integer>> map = new HashMap<>();
    public N0398_RandomPickIndex(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }
    }
    public int pick(int target) {
        Random rand = new Random();
        List<Integer> list = map.get(target);
        return list.get(rand.nextInt(list.size()));
    }
}
