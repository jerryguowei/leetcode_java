package com.duduanan.leetcode;

/***
 * 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 * Given a m x n matrix mat and an integer threshold. Return the maximum side-length of a
 * square with a sum less than or equal to threshold or return 0 if there is no such square.
 */
public class N1292_MaximumSideLengthOfSwqureWithSumLessThanOrEqualToThreshold {
    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        //build prefix sum;
        int[][] p =  new int[ m + 1][n + 1];
        for(int i = 1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + mat[i-1][j-1];
            }
        }
        // System.out.println(Arrays.deepToString(p));
        int high = Math.min(m,n);
        int low = 1;
        int mid = 0;
        while(low <= high) {
            mid = low + (high - low) / 2;
            if(valid(mat, p, mid, threshold)) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }
    private boolean valid(int[][] mat, int[][] p, int width, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int sum = 0;
        for(int i = 1; i <= m - width + 1; i++) {
            for(int j = 1; j <= n - width + 1; j++) {
                int x1 = i, y1 = j, x2 = i + width - 1, y2 = j + width - 1;
                sum = p[x2][y2] - p[x2][y1 - 1] - p[x1-1][y2] + p[x1-1][y1-1];
                if(sum <= threshold) return true;
            }
        }
        return false;
    }
}
