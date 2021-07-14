package com.duduanan.leetcode;
//TOP-down appoach
public class N0062_UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] r = new int[m][n];
        return doUnique(r, m, n);
    }
    public int doUnique(int[][] r, int m, int n) {
        if(m == 1 && n == 1){
            return 1;
        }
        int right = 0;
        int down = 0;
        if(m > 1) {
            if(r[m-2][n-1] > 0){
                right = r[m-2][n-1];
            } else {
                right = doUnique(r, m-1, n);
                r[m-2][n-1] = right;
            }
        }
        if(n > 1){
            if(r[m-1][n-2] > 0) {
                down = r[m-1][n-2];
            } else {
                down = doUnique(r, m, n-1);
                r[m-1][n-2] = down;
            }

        }
        return (right + down);
    }


    public int uniqPathsDownTop(int m, int n) {
        int[][] r = new int[m][n];
        int temp = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++) {

                if(i == 1 && j == 1) {
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
        N0062_UniquePaths uniquePaths62 = new N0062_UniquePaths();
        int n = uniquePaths62.uniquePaths(7, 3);
        System.out.println(n);
        int m = uniquePaths62.uniquePaths(7, 3);
        System.out.println(m);
    }

}

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 *
 * The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 *
 * How many possible unique paths are there?
 *
 *
 *
 * Example 1:
 *
 *
 * Input: m = 3, n = 7
 * Output: 28
 * Example 2:
 *
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Down -> Down
 * 2. Down -> Down -> Right
 * 3. Down -> Right -> Down
 * Example 3:
 *
 * Input: m = 7, n = 3
 * Output: 28
 * Example 4:
 *
 * Input: m = 3, n = 3
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= m, n <= 100
 * It's guaranteed that the answer will be less than or equal to 2 * 109.
 *
 *
 */
