package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 85. Maximal Rectangle
 * Hard
 * Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 *
 */
public class N0085_MaximalRectangle {

    @Test
    public void test() {
        char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
        Assertions.assertEquals(6, maximalRectangle(matrix));
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int max = 0;
        for(int i = 0; i < m ; i++) {
            for(int j = 0; j < n; j++) {
                heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
            }
            max = Math.max(max, maxR(heights));
        }
        return max;
    }
    private int maxR(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int max = 0;
        for(int i = 0; i < heights.length; i++) {
            while(!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                int prevH = heights[stack.pop()];
                int preWidth = i - (stack.isEmpty() ? 0 : stack.peek() + 1);
                max = Math.max(prevH * preWidth, max);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int prevH = heights[stack.pop()];
            int preWidth = heights.length - (stack.isEmpty() ? 0 : stack.peek() + 1);
            max = Math.max(max, prevH * preWidth);
        }
        return max;
    }
}
