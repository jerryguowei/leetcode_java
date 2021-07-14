package com.duduanan.leetcode;

public class N0153_FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int index = findMin(nums, 0, nums.length -1);
        return nums[index];
    }

    public int findMin(int[] nums, int lo, int hi) {
        int mid = (lo + hi) / 2;
        int prev = mid -1;
        int next = mid + 1;
        if(prev == -1) {
            prev = nums.length - 1;
        }
        if(nums[prev] >= nums[mid] && (next >= nums.length || nums[mid] <= nums[next])){
            return mid;
        } else {
            int index = -1;
            if(mid > lo) {
                index = findMin(nums, lo, mid);
            }

            if(index < 0 && mid+1 <= hi){
                index = findMin(nums, mid+1, hi);
            }
            return index;
        }
    }
    public static void main(String[] args) {
        N0153_FindMinimumInRotatedSortedArray findMinimumInRotatedSortedArray153 = new N0153_FindMinimumInRotatedSortedArray();
        int result = findMinimumInRotatedSortedArray153.findMin(new int[]{3,4,5,1,2});
        System.out.println(result);
    }
}
