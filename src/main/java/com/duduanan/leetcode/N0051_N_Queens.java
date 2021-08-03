package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0051_N_Queens {

    @Test
    public void test() {
        int n = 4;
        System.out.println(solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] t : board){
            Arrays.fill(t, '.');
        }
        List<List<String>> res = new ArrayList<>();
        helper(res, board, 0, n);
        return res;
    }
    private void helper(List<List<String>> res, char[][] board, int row, int n){
        if(row == n){
            res.add(buildString(board));
            return;
        }
        for(int i = 0; i < n; i++){
            boolean valid = checkValid(board, row, i);
            if(!valid) continue;
            board[row][i] = 'Q';
            helper(res, board, row + 1, n);
            board[row][i] = '.';
        }
    }

    public List<String> buildString(char[][] board) {
        List<String> res = new ArrayList<>();
        for(char[] temp : board){
            res.add(new String(temp));
        }
        return res;
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
