package com.duduanan.leetcode;

import java.util.Arrays;

/**
 *
 * 410. Split Array Largest Sum
 * Given an array nums which consists of non-negative integers and an integer m,
 * you can split the array into m non-empty continuous subarrays.
 *
 * Write an algorithm to minimize the largest sum among these m subarrays.
 *
 */
public class N0410_splitArrayLargestSum {


    public int splitArray(int[] nums, int m) {
        int sum = Arrays.stream(nums).sum();
        int max = Arrays.stream(nums).max().getAsInt();
        int lo = max, hi = sum;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(valid(nums, m, mid))  hi = mid - 1;
            else lo = mid + 1;
        }
        return lo;
    }

    private boolean valid(int[] nums, int m, int subArraySum) {
        int curSum = 0, count = 1;
        for(int num : nums) {
            curSum += num;
            if(curSum > subArraySum) {
                curSum = num;
                count++;
                if(count > m) return false;
            }
        }
        return true;
    }
}
