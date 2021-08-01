package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 * Easy
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in nums.
 */
public class N0448_FindAllNumbersDisappearedInAnArray {

    @Test
    public void test() {
        int[] nums =  {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(findDisappearedNumbers(nums));
    }
    public List<Integer> findDisappearedNumbers(int[] nums) {

        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0)  nums[idx] = -nums[idx];
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) list.add(i + 1);
        }
        return list;
    }
}
