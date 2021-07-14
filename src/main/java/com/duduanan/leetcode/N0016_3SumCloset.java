package com.duduanan.leetcode;

import java.util.Arrays;

public class N0016_3SumCloset {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++) {
            int lo = i + 1;
            int hi = nums.length - 1;
            while(lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if(sum > target)  hi--;
                else if(sum < target) lo++;
                else {
                    return target;
                }
                if(Math.abs(sum - target) < Math.abs(result - target)) result = sum;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        N0016_3SumCloset t3SumCloset16 = new N0016_3SumCloset();
        System.out.println(t3SumCloset16.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }
}
/*
* 16. 3Sum Closest
Medium

3427

178

Add to List

Share
Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).


Constraints:

3 <= nums.length <= 10^3
-10^3 <= nums[i] <= 10^3
-10^4 <= target <= 10^4
Accepted
596,383
Submissions
1,284,808
*
* **/

