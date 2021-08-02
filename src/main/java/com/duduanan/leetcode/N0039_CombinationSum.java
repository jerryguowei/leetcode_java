package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * Medium
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
 * where the chosen numbers sum to target. You may return the combinations in any order.
 * The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least
 * one of the chosen numbers is different.
 * It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations for the given input.
 */
public class N0039_CombinationSum {
    @Test
    public void test() {
        int candidates[] = {2,3,6,7}, target = 7;
        System.out.println(combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, curr,candidates, target, 0);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, int r, int index){
        if(r == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < nums.length; i++){
            int pick = nums[i];
            if(r - pick < 0) continue;
            curr.add(pick);
            helper(res, curr, nums, r - pick, i);
            curr.remove(curr.size() - 1);
        }
    }
}
