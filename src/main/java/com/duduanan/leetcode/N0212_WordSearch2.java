package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 212. Word Search II
 * Hard
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 */
public class N0212_WordSearch2 {
    class Node {
        Node[] children;
        String word;
        int count = 0;
        public Node(){
            children = new Node[26];
        }
    }
    public void insert(Node curr, String word) {
        Node node = curr;
        for(char c : word.toCharArray()) {
            int idex = c - 'a';
            if(node.children[idex] == null){
                node.children[idex] = new Node();
                node.count++;
            }
            node = node.children[idex];
        }
        node.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = new Node();
        for(String w : words){
            insert(root, w);
        }
        int n = board.length,m = board[0].length;
        List<String> res = new ArrayList<>();
        boolean[][] visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j<m; j++) {
                backtrack(board, i, j, res, root, visited);
            }
        }
        return res;
    }
    private void backtrack(char[][] board, int i, int j, List<String> res, Node node, boolean[][] visited){
        int n = board.length;
        int m = board[0].length;
        if(i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || node.count == 0) return;
        if(node.children[board[i][j] - 'a'] == null) return;

        Node child = node.children[board[i][j] - 'a'];
        if(child.word != null){
            res.add(child.word);
            child.word = null;
        }
        visited[i][j] = true;
        backtrack(board, i+1, j, res, child, visited);
        backtrack(board, i-1, j, res, child, visited);
        backtrack(board, i, j+1, res, child, visited);
        backtrack(board, i, j-1, res, child, visited);
        visited[i][j] = false;
        if(child.count == 0) {
            node.count--;
        }
    }
}

//self solution, not good.
class Solution {
    private Set<String> res = new HashSet<>();
    private Set<String> wordSet = new HashSet<>();
    private int n = 0;
    private int m = 0;
    public List<String> findWords(char[][] board, String[] words) {
        for(String w : words){
            wordSet.add(w);
        }
        n = board.length;
        m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j<m; j++){
                boolean[][] visited = new boolean[n][m];
                backtrack(board, i, j, "", visited);
            }
        }
        return new ArrayList<>(res);
    }
    private void backtrack(char[][] board, int i, int j, String tmp, boolean[][] visited){
        if(wordSet.contains(tmp)){
            res.add(tmp);
        }
        if(i < 0 || i >= n || j < 0 || j >= m) return;
        if(visited[i][j]) return;
        if(tmp.length() >= 10){
            return;
        }
        char c = board[i][j];
        visited[i][j] = true;
        tmp += c;
        backtrack(board, i+1, j, tmp, visited);
        backtrack(board, i-1, j, tmp, visited);
        backtrack(board, i, j+1, tmp, visited);
        backtrack(board, i, j-1, tmp, visited);
        visited[i][j] = false;
    }
}