package com.duduanan.extra.backtrack;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Nking {
    private List<List<List<Character>>> res = new ArrayList<>();

    @Test
    public void test() {
        List<List<List<Character>>> result = resolveQueen(8);
        for(int i = 0 ; i < result.size(); i++){
            for (int j = 0; j < result.get(i).size(); j++){
                System.out.println(result.get(i).get(j));
            }
            System.out.println("###########################");
        }
        System.out.println(result.size());
    }

    public List<List<List<Character>>>  resolveQueen(int n) {
        List<List<Character>> board = new ArrayList<>();
        for(int i = 0; i < n; i++){
            List<Character> temp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                temp.add('.');
            }
            board.add(temp);
        }
        backTrack(board, 0);
        return res;
    }

    public void backTrack(List<List<Character>> board, int row) {
        if(row == board.size()){
            res.add(deepCopy(board));
            return;
        }
        int n = board.size();
        for(int col = 0; col < n; col++) {
            if(!valid(board, col, row)) continue;
            board.get(row).set(col, 'Q');
            backTrack(board, row + 1);
            board.get(row).set(col, '.');
        }

    }

    private boolean valid(List<List<Character>> board, int col, int row) {
        //check if the same col have Q
        for(int i = 0; i < board.size(); i++){ //board.size() can change to row
            if(board.get(i).get(col) == 'Q') return false;
        }
        //check if left-top have Q;
        for(int i = row-1, j = col-1; i >= 0 && j >= 0; i--,j--){
            if(board.get(i).get(j) == 'Q') return  false;
        }
        //check if right-top have Q;
        for(int i = row - 1, j = col+1; i >=0 && j < board.size(); i--, j++){
            if(board.get(i).get(j) == 'Q') return  false;
        }
        return true;
    }

    public List<List<Character>> deepCopy(List<List<Character>> board) {
        List<List<Character>> deepCopy = new ArrayList<>();
        for(int i = 0 ; i <board.size(); i++) {
            List<Character> temp = new ArrayList<>();
            for(int j = 0; j < board.get(i).size();j ++) {
                temp.add(board.get(i).get(j));
            }
            deepCopy.add(temp);
        }
        return deepCopy;
    }
}
