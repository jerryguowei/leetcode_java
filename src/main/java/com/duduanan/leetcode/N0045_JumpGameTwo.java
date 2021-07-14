package com.duduanan.leetcode;

public class N0045_JumpGameTwo {
    public static void  main(String[] args) {
        int[] nums = {2,3,1,1,4};

        N0045_JumpGameTwo jumpGameTwo45 = new N0045_JumpGameTwo();
        System.out.println(jumpGameTwo45.jump(nums));

    }

    public int jump(int[] nums) {

        int position = nums.length - 1;
        int min = nums.length - 1;
        int i  = nums.length - 2;
        int count = 0;
        while(position > 0) {
            while(i >=0 && position - i <=1000){
                if(nums[i] >= position - i){
                    min = i;
                }
                i--;
            }
            i= min - 1;
            position = min;
            count++;
        }
        return count;
    }


        public int jump1(int[] nums) {
            int maxIndexReachable=0,end=0,jumps=0;
            for(int i=0;i<nums.length-1 && end<nums.length-1;i++){
                maxIndexReachable=Math.max(maxIndexReachable,nums[i]+i);
                if(end==i){
                    jumps++;
                    end=maxIndexReachable;
                }
            }
            return jumps;
        }

}
/***
 * 45. Jump Game II
 * Medium
 *
 * 4580
 *
 * 194
 *
 * Add to List
 *
 * Share
 * Given an array of non-negative integers nums, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * You can assume that you can always reach the last index.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: nums = [2,3,0,1,4]
 * Output: 2
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 *
 */