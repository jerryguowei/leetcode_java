package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * 118. Pascal's Triangle
 * Easy
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:
 */
public class N0118_PascalTriangle {

    @Test
    public void test() {
        int k = 5;
        List<List<Integer>> result = generate(k);
        System.out.println(result);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> first = new ArrayList<>(Arrays.asList(1));
        res.add(first);
        if(numRows == 1) return res;
        int i = 0;
        while(i < numRows-1) {
            List<Integer> last = res.get(i++);
            List<Integer> list  = new ArrayList<>();
            for(int j = 0; j <= i; j++) {
                int t = 0;
                if(j-1 >= 0 && j+1 <= last.size()) {
                    t = last.get(j-1) + last.get(j);
                } else if(j == 0) {
                    t = last.get(j);
                } else {
                    t  = last.get(j-1);
                }
                list.add(t);
            }
            res.add(list);
        }
        return res;
    }
}
