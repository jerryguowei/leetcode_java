package com.duduanan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1,
 * return the area of the largest rectangle in the histogram.
 */
public class N0084_LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {



        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int preH = heights[stack.pop()];
                int preW = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                max = Math.max(preH * preW, max);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int preH = heights[stack.pop()];
            int preW = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
            max = Math.max(preH * preW, max);
        }
        return max;
    }
}
