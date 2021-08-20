package com.duduanan.leetcode;

public class N0033_SearchInRotaedSortedArray {
    public int search(int[] nums, int target) {

        int lo = 0, hi = nums.length;
        while(lo <  hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) return mid;

            if(nums[lo] < nums[mid]){
                if(target < nums[mid] && target >= nums[lo]){
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            } else {
                if(target >= nums[mid] && target <= nums[hi-1]){
                    lo = mid+1;
                } else {
                    hi = mid;
                }
            }
        }
        return -1;
    }
}
