package com.duduanan.leetcode;

/***
 * 36. Valid Sudoku
 * Medium
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
public class N0036_ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            boolean[] row = new boolean[9];
            boolean[] col = new boolean[9];
            boolean[] small = new boolean[9];
            for(int j = 0; j < board[0].length; j++){
                int a= (i/3) * 3 + j/3;
                int b = (i%3) * 3 + j %3;
                if(board[i][j] != '.' && row[board[i][j] -'1']){
                    return false;
                } else if(board[i][j] != '.') {
                    row[board[i][j] -'1'] = true;
                }
                if(board[j][i] != '.' && col[board[j][i] -'1']){
                    return false;
                } else if(board[j][i] != '.') {
                    col[board[j][i] -'1'] = true;
                }
                if(board[a][b] != '.'&&small[board[a][b] - '1']){
                    return false;
                } else if(board[a][b] != '.'){
                    small[board[a][b] - '1'] = true;
                }
            }
        }
        return true;
    }
}
