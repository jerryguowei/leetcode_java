package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 * Medium
 * Share
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *
 */
public class N0047_Permutations2 {
    @Test
    public void test(){
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        helper(res, curr, nums, visited);
        return res;
    }


    public void helper(List<List<Integer>> res, List<Integer> curr, int[] nums, boolean[] visited){
        if(curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        Set<Integer> choose = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            if(visited[i]) continue;
            if(choose.contains(nums[i])) continue;
            curr.add(nums[i]);
            choose.add(nums[i]);
            visited[i] = true;
            helper(res, curr, nums,visited);
            curr.remove(curr.size() - 1);
            visited[i] = false;
        }
    }
}
