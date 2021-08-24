package com.duduanan.leetcode;

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 503. Next Greater Element II
 * Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]),
 * return the next greater number for every element in nums.
 *
 * The next greater number of a number x is the first greater number
 * to its traversing-order next in the array, which means you could search circularly to find its next greater number. If it doesn't exist, return -1 for this number.
 */
public class N0503_NextGreaterElement2 {
    public int[] nextGreaterElements1(int[] nums) {
        int[] res = new int[nums.length];
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = 2 * n - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() >= nums[i % n]) stack.pop();
            if(i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(nums[i % n]);
        }
        return res;
    }

    public int[] nextGreaterElements(int[] nums) {
        int[] copy = new int[nums.length * 2 - 1];
        int n = nums.length;
        for(int i = 0 ; i < copy.length; i++){
            copy[i] = nums[i % n];
        }
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for(int j = copy.length - 1; j >= 0; j--) {
            while(!stack.isEmpty() && stack.peek() <= copy[j]) stack.pop();
            if(j < n) {
                if(stack.isEmpty()) {
                    res[j] = - 1;
                } else {
                    res[j] = stack.peek();
                }
            }
            stack.push(copy[j]);
        }
        return res;
    }
}
