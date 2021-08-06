package com.duduanan.leetcode.review;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class N0239_slidingWindowMaximum {

    @Test
    public void test() {
        int nums[] = {1,3,-1,-3,5,3,6,7}, k = 3;
//        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        Assertions.assertArrayEquals(new int[]{3,3,5, 5, 6,7}, maxSlidingWindow(nums, k));
    }

    public int[] maxSlidingWindow(int[] nums, int k){
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++) {
            int pick = nums[i];
            if(!deque.isEmpty() && deque.getFirst() < i - k + 1){
                deque.removeFirst();
            }
             while(!deque.isEmpty() && nums[deque.getLast()] <= pick) {
                deque.removeLast();
            }
            deque.addLast(i);

            if(i >=k-1){
                res[i-k+1] = nums[deque.getFirst()];
            }
        }
        return  res;
    }
}
