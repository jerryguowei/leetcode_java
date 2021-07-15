package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/* Easy
 * Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums.
 * If target exists, then return its index. Otherwise, return -1.
 * You must write an algorithm with O(log n) runtime complexity.
 *
 * Solution:
 *         1.
 */
public class N0704_BinarySearch {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while(l <= r ) {
            int m = (l + r) / 2;
            if(nums[m] == target)
                return m;
            if(nums[m] < target)
                l = m + 1;
            else
                r = m -1;
        }
        return -1;
    }
    @Test
    public void test_iterator() {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = search(nums, 9);
        Assertions.assertEquals(4, result);
        System.out.println(result);

    }

    private int binarySearch(int nums[], int l, int r, int x) {
        if(r >= l) {
            int m = (l + r) / 2;
            if(nums[m] == x) return m;
            if(nums[m] > x) {
                return binarySearch(nums, l, m-1, x);
            } else
                return binarySearch(nums, m + 1, r, x);
        }
        return -1;
    }
    @Test
    public void test_tree(){
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = binarySearch(nums, 0, nums.length-1, target);
        Assertions.assertEquals(4, result);
        System.out.println(result);
    }

    private int searchUpper(int nums[], int x) {
        int l = 0;
        int r = nums.length;
        while (l < r) {
            int m = (l + r) / 2;
            if(nums[m] == x)
                return m;
            if(nums[m] < x)
                l = m + 1;
            else
                r = m;
        }
        return -1;
    }
}
