package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 90. Subsets II
 * Medium
 * Given an integer array nums that may contain duplicates, return all possible subsets (the power set).
 *
 * The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 *
 */
public class N0090_Subsets2 {

    @Test
    public void test() {
        int[] nums = {1,2,2};
        System.out.println(subsetsWithDup(nums));
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<>(), nums, 0);

        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int k) {
        res.add(new ArrayList<>(curr));
        for(int j = k; j < nums.length; j++) {
            if(j != k && nums[j] == nums[j-1]) continue;
            curr.add(nums[j]);
            helper(res, curr, nums, j+1);
            curr.remove(curr.size() - 1);
        }
    }
}
