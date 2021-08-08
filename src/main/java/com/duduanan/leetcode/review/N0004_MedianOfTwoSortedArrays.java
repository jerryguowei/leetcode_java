package com.duduanan.leetcode.review;

public class N0004_MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        int left = 0, right = nums1.length;

        while(left <= right) {
            int midX = left + (right - left) / 2;
            int midY = (nums1.length + nums2.length + 1) / 2 - midX;

            int xLeft = midX == 0 ? Integer.MIN_VALUE : nums1[midX - 1];
            int xRight = midX == nums1.length ? Integer.MAX_VALUE : nums1[midX];
            int yLeft = midY == 0 ? Integer.MIN_VALUE : nums2[midY - 1];
            int yRight = midY == nums2.length ? Integer.MAX_VALUE : nums2[midY];

            if(xLeft <= yRight && xRight >= yLeft){
                if((nums1.length + nums2.length) % 2 == 0) return (Math.max(xLeft, yLeft) + Math.min(xRight,yRight)) / 2.0d;
                return Math.max(xLeft, yLeft);
            } else if(xLeft > yRight) {
                right = midX - 1;
            } else {
                left = midX + 1;
            }
        }

        return 0;
    }

}
