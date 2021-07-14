package com.duduanan.leetcode;

public class N0053_MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int f = nums[0];
        int max = f;
        for(int i = 1; i < nums.length; i++){
            f = Math.max(nums[i], f + nums[i]);
            max=Math.max(max, f);

        }
        return max;
    }
}

/*  f[0-->n]
    f(i) = max(ai, f(i-1) + ai);
    max(f);
     Kadane's algorithm.
 */
/*
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.



        Example 1:

        Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
        Output: 6
        Explanation: [4,-1,2,1] has the largest sum = 6.
        Example 2:

        Input: nums = [1]
        Output: 1
        Example 3:

        Input: nums = [5,4,-1,7,8]
        Output: 23


        Constraints:

        1 <= nums.length <= 3 * 104
        -105 <= nums[i] <= 105
    Follow up: If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
        */