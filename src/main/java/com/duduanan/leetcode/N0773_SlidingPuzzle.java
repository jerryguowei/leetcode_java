package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/***
 * 773. Sliding Puzzle
 * Hard
 * On an 2 x 3 board, there are five tiles labeled from 1 to 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given the puzzle board board, return the least number of moves required so that the state of the board is solved.
 * If it is impossible for the state of the board to be solved, return -1.
 */
public class N0773_SlidingPuzzle {

    @Test
    public void test() {
       int result = slidingPuzzle(new int[][] {{1,2,3}, {4,0,5}});
       System.out.println(result);
    }


    private int[][] dic = new int[][] {
            {1,3},
            {0,2,4},
            {1,5},
            {0, 4},
            {1,3,5},
            {2,4}
    };

    public int slidingPuzzle(int[][] board) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }
        Queue<String> q1 = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q1.offer(sb.toString());
        visited.add(sb.toString());
        int step = 0;
        while(q1.size() > 0) {
            int sz = q1.size();
            for(int i = 0; i < sz; i++) {
                String cur = q1.poll();
                if(cur.equals("123450")) return step;
                Set<String> s = next(cur, visited);
                q1.addAll(s);
                visited.addAll(s);
            }
            step++;
        }
        return -1;
    }

    private Set<String> next(String cur, Set<String> visited) {
        int zeroIndex = 0;
        while(zeroIndex < cur.length()){
            if(cur.charAt(zeroIndex) == '0'){
                break;
            }
            zeroIndex++;
        }
        Set<String> result = new HashSet<>();
        for(int j : dic[zeroIndex]) {
            char[] c = cur.toCharArray();
            char temp = c[zeroIndex];
            c[zeroIndex] = c[j];
            c[j] = temp;
            String tr = new String(c);
            if(visited.contains(tr)) continue;
            result.add(tr);
        }
        return result;
    }
}
