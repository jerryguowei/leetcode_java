package com.duduanan.leetcode;

/**
 *
 *34. Find First and Last Position of Element in Sorted Array
 * Medium
 * Share
 * Given an array of integers nums sorted in ascending order,
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 * You must write an algorithm with O(log n) runtime complexity.
 */
public class N0034_FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= target) r = mid;
            else l = mid + 1;
        }
        if (nums[l] != target) return new int[]{-1, -1};
        int x = l;
        l = 0;
        r = nums.length - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= target) l = mid;
            else r = mid - 1;
        }
        return new int[]{x, l};
    }
}
