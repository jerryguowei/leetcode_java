package com.duduanan.leetcode;

import java.util.Arrays;

public class N1283_FindTheSmalllestDivisorGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = Arrays.stream(nums).max().getAsInt();
        int min = 1;
        int high = max;
        int low = min;
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(valid(nums, mid, threshold)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
    private boolean valid(int[] nums, int divisor, int threshold) {
        int count = 0;
        for(int num : nums) {
            count += (num / divisor + (( num % divisor != 0) ? 1 : 0));
            if(count > threshold) return false;
        }
        return true;
    }
}
