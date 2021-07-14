package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0015_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> output = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int target = -nums[i];
            int low = i + 1;
            int hi = nums.length - 1;
            if(i == 0 || (i > 0 && nums[i-1] != nums[i])){
                while(low < hi) {
                    int sum = nums[low] + nums[hi];
                    if(sum < target){
                        low++;
                    } else if( sum > target){
                        hi--;
                    } else {
                        List<Integer> list = Arrays.asList(nums[i], nums[low], nums[hi]);
                        output.add(list);
                        while(low < hi && nums[low + 1] == nums[low]) low++;
                        while(low < hi && nums[hi-1] == nums[hi]) hi--;
                        low++;
                        hi--;
                    }
                }
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {-1,0,1,2,-1,-4};
        N0015_3Sum t3Sum15 = new N0015_3Sum();
        System.out.println(t3Sum15.threeSum(nums));
    }
}

/***
 * 15. 3Sum
 * Medium
 *
 * 11042
 *
 * 1104
 *
 * Add to List
 *
 * Share
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 *
 * Input: nums = []
 * Output: []
 * Example 3:
 *
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 * Accepted
 * 1,331,478
 * Submissions
 * 4,647,334
 */
