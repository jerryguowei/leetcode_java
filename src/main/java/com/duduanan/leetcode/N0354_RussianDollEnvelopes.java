package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 354. Russian Doll Envelopes
 * Hard
 * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represents the width and the height of an envelope.
 * One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.
 * Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).
 * Note: You cannot rotate an envelope.
 *
 */
public class N0354_RussianDollEnvelopes {

    @Test
    public void test() {
        int[][] envelopes = {{5,4},{6,4},{6,7},{2,3}};
        Assertions.assertEquals(3, maxEnvelopes(envelopes));
    }
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) -> {
            if(a[0] != b[0]) return a[0] - b[0];
            return b[1] - a[1];
        });
        int height[] = new int[envelopes.length];
        for(int i = 0; i < envelopes.length; i++){
            height[i] = envelopes[i][1];
        }
        return longestIncrease(height);
    }

    public int longestIncrease(int[] nums) {
        int[] tops = new int[nums.length];
        int piles = 0;
        for(int i = 0; i < nums.length; i++){
            int pocker = nums[i];
            int low = 0, hi = piles;
            while(low < hi){
                int mid = (low + hi ) / 2;
                if(tops[mid] >= pocker){
                    hi = mid;
                } else if(tops[mid] < pocker){
                    low = mid + 1;
                }
            }
            if(low == piles) piles++;
            tops[low] = pocker;

        }
        return piles;
    }
}
