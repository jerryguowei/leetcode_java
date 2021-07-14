package com.duduanan.leetcode;

public class N0063_UniquePathTwo {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] r = new int[m][n];
        int temp = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {
                if(obstacleGrid[m - i][n - j] == 1){
                    temp = 0;
                } else if(i == 1 && j ==1){
                    temp = 1;
                } else {
                    temp = (i > 1 ? r[i-2][j-1] : 0) + (j > 1 ? r[i-1][j-2] : 0);
                }
                r[i-1][j-1] = temp;
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        N0063_UniquePathTwo uniquePaths63 = new N0063_UniquePathTwo();
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};
        int n = uniquePaths63.uniquePathsWithObstacles(obstacleGrid);

        System.out.println(n);
    }
}

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * An obstacle and space is marked as 1 and 0 respectively in the grid.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * Output: 2
 * Explanation: There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 * Example 2:
 *
 *
 * Input: obstacleGrid = [[0,1],[0,0]]
 * Output: 1
 *
 *
 * Constraints:
 *
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] is 0 or 1.
 */
