package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class N0046_Permutations {

    @Test
    public void test() {
        int[] nums = {1,2,3};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
     }

    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        backtrack(new ArrayList<>(), nums, used);
        return result;
    }
    public void backtrack(ArrayList<Integer> select, int[] nums, boolean[] used){
        if(select.size() == nums.length){
            result.add(new ArrayList<>(select));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i]) continue;
            select.add(nums[i]);
            used[i] = true;
            backtrack(select, nums, used);
            select.remove(select.size() - 1);
            used[i] = false;
        }
    }
}
