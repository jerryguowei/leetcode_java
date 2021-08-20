package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/**
 * 215. Kth Largest Element in an Array
 * Medium
 * Given an integer array nums and an integer k, return the kth largest element in the array.
 *
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 */
public class N0215_KthLargestElementInAnArray {

    @Test
    public void test() {
        int nums[] = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(findKthLargest(nums,k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums) {
            pq.offer(num);
            if(pq.size() > k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
