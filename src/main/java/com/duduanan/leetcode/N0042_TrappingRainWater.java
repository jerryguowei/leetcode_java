package com.duduanan.leetcode;

/***
 * 42. Trapping Rain Water
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it can trap after raining.
 * Example 1:
 */
public class N0042_TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] left = new int[n];
        int[] right = new int[n];
        for(int i = 0; i < n; i++){
            left[i] = Math.max(height[i], (i > 0 ? left[i-1] : 0));
        }
        for(int i = n - 1;  i >= 0; i--){
            right[i] = Math.max(height[i], (i < n -1 ? right[i + 1] : 0));
        }
        int res = 0;
        for(int i = 0; i < n; i++) {
            res = res +  Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
