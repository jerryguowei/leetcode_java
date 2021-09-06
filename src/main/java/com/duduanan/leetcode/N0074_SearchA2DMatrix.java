package com.duduanan.leetcode;

/***
 * 74. Search a 2D Matrix
 * Medium
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 */
public class N0074_SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = 0,  r =  n * m - 1;
        while(l < r) {
            int mid = l + r >> 1;
            if(matrix[mid / m][mid % m] >= target) r = mid;
            else l = mid + 1;
        }
        if(matrix[l/m][l%m] == target) return true;
        return false;
    }
}
