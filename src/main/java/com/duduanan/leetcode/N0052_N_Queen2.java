package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/***
 * 52. N-Queens II
 * Hard
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard
 * such that no two queens attack each other.
 * Given an integer n, return the number of distinct solutions to the n-queens puzzle.
 */
public class N0052_N_Queen2 {

    @Test
    public void test() {
        System.out.println(totalNQueens(4));
    }

    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] t : board){
            Arrays.fill(t, '.');
        }
        helper(board, 0, n);
        return count;
    }

    private void helper(char[][] board, int row, int n){
        if(row == n){
            count++;
            return;
        }
        for(int i = 0; i < n; i++){
            boolean valid = checkValid(board, row, i);
            if(!valid) continue;
            board[row][i] = 'Q';
            helper(board, row + 1, n);
            board[row][i] = '.';
        }
    }

    public boolean checkValid(char[][] board, int i, int j) {
        if(i == 0) return true;

        int m = i, n = j;
        while(m-1 >= 0){
            if(board[--m][j] == 'Q') return false;
        }
        m = i; n = j;
        while(m-1 >= 0 && n-1 >= 0) {
            if(board[--m][--n] == 'Q') return false;
        }
        m = i; n = j;
        while(m-1 >= 0 && n+1 < board.length){
            if(board[--m][++n] == 'Q') return false;
        }
        return true;
    }
}
