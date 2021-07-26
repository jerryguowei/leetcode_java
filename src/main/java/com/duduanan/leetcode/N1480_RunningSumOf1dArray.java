package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/***
 * 1480. Running Sum of 1d Array
 * Easy
 * Given an array nums. We define a running sum of an array as runningSum[i] = sum(nums[0]…nums[i]).
 *
 * Return the running sum of nums.
 */
public class N1480_RunningSumOf1dArray {
    @Test
    public void test() {
        int[] nums = {1, 2, 3, 4};
        Assertions.assertArrayEquals(new int[]{1, 3, 6, 10},runningSum(nums));
    }

    public int[] runningSum(int[] nums) {
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] + nums[i];
        }
        return nums;
    }
}
