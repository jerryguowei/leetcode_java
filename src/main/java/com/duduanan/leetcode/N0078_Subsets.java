package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 78. Subsets
 * Medium
 * Given an integer array nums of unique elements, return all possible subsets (the power set).
 */
public class N0078_Subsets {

    @Test
    public void test() {
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = subsets(nums);
        System.out.println(result);
    }

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        backtrack(new ArrayList<>(), nums, 0);
        return result;

    }

    public void backtrack(List<Integer> select, int[] nums, int index) {
        if (index >= nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            List<Integer> copy = new ArrayList<>(select);
            copy.add(nums[i]);
            result.add(copy);
            backtrack(copy, nums, i + 1);
        }
    }
}
