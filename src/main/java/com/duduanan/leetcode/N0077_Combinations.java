package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * Given two integers n and k, return all possible combinations of k numbers out of the range [1, n].
 *
 * You may return the answer in any order.
 */
public class N0077_Combinations {

    @Test
    public void test() {
        int n = 4, k = 2;
        List<List<Integer>> result = combine(n,k);
        System.out.println(result);
    }
    private List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        if(k > n) return result;
        backtrack(new ArrayList<>(), k, 1, n);
        return result;
    }

    private void backtrack(List<Integer> current, int k, int index, int n){
        if(current.size() == k) {
            result.add(new ArrayList<>(current));
            return;
        }

        for(int i = index; i <= n; i++) {
            current.add(i);
            backtrack(current, k, i+1, n);
            current.remove(current.size()-1);
        }

    }
}
