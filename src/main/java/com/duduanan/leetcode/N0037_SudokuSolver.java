package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class N0037_SudokuSolver {

    @Test
    public void test() {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                         {'6','.','.','1','9','5','.','.','.'},
                         {'.','9','8','.','.','.','.','6','.'},
                         {'8','.','.','.','6','.','.','.','3'},
                         {'4','.','.','8','.','3','.','.','1'},
                         {'7','.','.','.','2','.','.','.','6'},
                         {'.','6','.','.','.','.','2','8','.'},
                         {'.','.','.','4','1','9','.','.','5'},
                         {'.','.','.','.','8','.','.','7','9'}};
        solveSudoku1(board);
//      System.out.println(Arrays.deepToString(board));
    }

    private Map<Integer, Set<Character>> rowSetMap = new HashMap<>();
    private Map<Integer, Set<Character>> colSetMap = new HashMap<>();
    private Map<Integer, Set<Character>> smallSetMap = new HashMap<>();

    private void init(char[][] board) {
        for(int i = 0; i < 9; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();
            rowSetMap.put(i, rowSet);
            colSetMap.put(i, colSet);
            for(int j = 0; j < 9; j++){
                Integer smallNum = i / 3 + (j / 3) * 3;
                smallSetMap.putIfAbsent(smallNum, new HashSet<>());
                if(board[i][j] != '.') {
                    rowSet.add(board[i][j]);
                }
                if(board[j][i] != '.') {
                    colSet.add(board[j][i]);
                    smallSetMap.get(smallNum).add(board[j][i]);
                }
            }
        }
    }

    public void solveSudoku1(char[][] board) {
        init(board);
        backtrack1(board, 0, 0);
    }

    private boolean backtrack1(char[][] board, int i, int j){
        if(j == 9){
            return backtrack1(board, i+1, 0);
        }
        if(i == 9) return true;
        if(board[i][j] != '.') {
            return backtrack1(board, i, j+1);
        }
        for(char ch = '1'; ch <= '9'; ch++){
            if(!valid1(board, i, j, ch)) continue;


            board[i][j] = ch;
            add(i,j,ch);
            if(backtrack1(board, i, j+1)) {
                return true;
            }
            board[i][j] = '.';
            remove(i,j,ch);
        }
        return false;
    }
    private boolean valid1(char[][] board, int r, int c, char chr) {
        if(rowSetMap.get(r).contains(chr)) return false;
        if(colSetMap.get(c).contains(chr)) return false;
        Integer smallNum = c / 3 + (r / 3) * 3;
        if(smallSetMap.get(smallNum).contains(chr)) return false;
        return true;
    }
    private void add(int r, int c, char chr) {
        rowSetMap.get(r).add(chr);
        colSetMap.get(c).add(chr);
        Integer smallNum = c / 3 + (r / 3) * 3;
        smallSetMap.get(smallNum).add(chr);
    }
    private void remove(int r, int c, char chr) {
        rowSetMap.get(r).remove(chr);
        colSetMap.get(c).remove(chr);
        Integer smallNum = c / 3 + (r / 3) * 3;
        smallSetMap.get(smallNum).remove(chr);
    }





//    public void solveSudoku(char[][] board) {
//        boolean result =  backtrack(board, 0, 0);
//    }
//
//    private boolean backtrack(char[][] board, int i, int j){
//        if(j == 9){
//            return backtrack(board, i+1, 0);
//        }
//        if(i == 9) return true;
//        if(board[i][j] != '.') {
//            return backtrack(board, i, j+1);
//        }
//        for(char ch = '1'; ch <= '9'; ch++){
//            if(!valid(board, i, j, ch)) continue;
//            board[i][j] = ch;
//            if(backtrack(board, i, j+1)) {
//                return true;
//            }
//            board[i][j] = '.';
//        }
//        return false;
//    }
//
//    private boolean valid(char[][] board, int r, int c, char chr) {
//        for(int i = 0 ; i < 9; i++){
//            if(board[r][i] == chr) return false;
//            if(board[i][c] == chr) return false;
//            if(board[(r/3) * 3 + i / 3][(c/3) * 3 + i % 3] == chr) return false;
//        }
//        return true;
//    }
}
