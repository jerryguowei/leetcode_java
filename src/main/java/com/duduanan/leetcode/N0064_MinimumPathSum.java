package com.duduanan.leetcode;

public class N0064_MinimumPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] r = new int[m][n];
        int min = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i== 0 && j == 0) {
                    min = 0;
                } else {
                    min = Math.min((i > 0 ? r[i-1][j]: Integer.MAX_VALUE) , (j > 0 ? r[i][j-1] : Integer.MAX_VALUE));
                }
                min = grid[m-1-i][n-1-j] + min;
                r[i][j]=min;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1}, {4,2,1}};
        int min = minPathSum(grid);
        System.out.println(min);
    }
}


/**
 Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

 Note: You can only move either down or right at any point in time.



 Example 1:


 Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
 Output: 7
 Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.
 Example 2:

 Input: grid = [[1,2,3],[4,5,6]]
 Output: 12


 Constraints:

 m == grid.length
 n == grid[i].length
 1 <= m, n <= 200
 0 <= grid[i][j] <= 100
 **/