package com.duduanan.extra;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class PrefixSum2Array {

    @Test
    public void test() {
        int[][] mat = {{1,1,3,2,4,3,2},{1,1,3,2,4,3,2},{1,1,3,2,4,3,2}};
        System.out.println(Arrays.deepToString(buildPrefixArray1(mat)));
    }

    public int[][] buildPrefixArray(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] p = new int[m + 1][n + 1];
        for(int i =1; i <= m; i++) {
            for(int j = 1; j <= n; j++) {
                p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + mat[i-1][j-1];
            }
        }
        return p;
    }
    public int[][] buildPrefixArray1(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] p = new int[m][n];
        for(int i = 0; i < n; i++){
            p[0][i] = ((i > 0 ? p[0][i-1] : 0) + mat[0][i]);
        }
        for(int i = 0; i < m; i++){
            p[i][0] = ((i > 0 ? p[i-1][0] : 0) + mat[i][0]);
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++ ) {
                p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] + mat[i][j];
            }
        }
        return p;
    }
}
