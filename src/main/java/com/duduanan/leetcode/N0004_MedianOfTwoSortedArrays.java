package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

/**
 * 4. Median of Two Sorted Arrays
 * Hard
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 * The overall run time complexity should be O(log (m+n)).
 */
public class N0004_MedianOfTwoSortedArrays {
    public double finMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return finMedianSortedArrays(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, hi = m, nums1Mid = 0, nums2Mid = 0;
        while (low <= hi) {
            nums1Mid = (low + hi) / 2;
            nums2Mid = (m + n + 1) / 2 - nums1Mid;
            if(nums2Mid < n && nums1Mid > 0 && nums1[nums1Mid - 1] > nums2[nums2Mid]) {
                //left
                hi = nums1Mid - 1;
            } else if(nums2Mid > 0 && nums1Mid < m && nums2[nums2Mid-1] > nums1[nums1Mid]){
                //right
                low = nums1Mid + 1;
            } else {
                break;
            }
        }
        boolean isOdd = (nums1.length  + nums2.length ) % 2 == 1;
        if(isOdd){
            return Math.max(nums1Mid > 0 ? nums1[nums1Mid-1] : Integer.MIN_VALUE, nums2Mid > 0 ? nums2[nums2Mid-1]:Integer.MIN_VALUE);
        } else {
            return (Math.max(nums1Mid > 0 ? nums1[nums1Mid-1] : Integer.MIN_VALUE, nums2Mid > 0 ? nums2[nums2Mid-1] :Integer.MIN_VALUE)
                    + Math.min(nums1Mid < m ? nums1[nums1Mid]: Integer.MAX_VALUE, nums2Mid < n ? nums2[nums2Mid] : Integer.MAX_VALUE)) / 2.0d;
        }
    }

    @Test
    public void test() {
        int[] nums1 = {3,4,5,6,7,8};
        int[] nums2 = {1, 2};
        double result = finMedianSortedArrays(nums1,nums2);
        System.out.println(result);
    }

}
