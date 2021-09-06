package com.duduanan.leetcode;

/**
 * 162. Find Peak Element
 * Medium
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞.
 * You must write an algorithm that runs in O(log n) time.
 */
public class N0162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(mid == 0 || nums[mid] >= nums[mid - 1])
                l = mid;
            else
                r = mid - 1;
        }
        return l;
    }
}
