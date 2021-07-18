package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 136. Single Number
 * Easy
 * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class N0136_SingleNumber {
    @Test
    public void test() {
        int[] nums = {2,2,1};
        Assertions.assertEquals(1, singleNumber(nums));
    }
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
