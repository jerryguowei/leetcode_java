package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 * Medium
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 * Each number in candidates may only be used once in the combination.
 * Note: The solution set must not contain duplicate combinations.
 */
public class N0040_Combination2 {

    @Test
    public void test() {
       int candidates[] = {10,1,2,7,6,1,5}, target = 8;
       System.out.println(combinationSum2(candidates,target));
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, candidates, curr, target, 0);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] candidates,List<Integer> curr, int r, int index){
        if(r == 0){
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(r - candidates[i] < 0) continue;
            curr.add(candidates[i]);
            helper(res, candidates, curr, r - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}
