package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N0026_RemoveDuplicatesFromSortedArray {
    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        Assertions.assertEquals(2, removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int lastIndex = 1;
        int val = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != val) {
                val = nums[i];
                if(i != lastIndex){
                    nums[lastIndex] = nums[i];
                }
                lastIndex++;
            }
        }
        return lastIndex;
    }

}

/****
 * 26. Remove Duplicates from Sorted Array
 * Easy
 * Share
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 */
