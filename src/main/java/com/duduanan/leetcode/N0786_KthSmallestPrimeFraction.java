package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

/***
 * 786. K-th Smallest Prime Fraction
 * Hard
 * You are given a sorted integer array arr containing 1 and prime numbers, where all the integers of arr are unique. You are also given an integer k.
 *
 * For every i and j where 0 <= i < j < arr.length, we consider the fraction arr[i] / arr[j].
 *
 * Return the kth smallest fraction considered. Return your answer as an array of integers of size 2, where answer[0] == arr[i] and answer[1] == arr[j].
 */
public class N0786_KthSmallestPrimeFraction {
    @Test
    public void test() {
        int arr[] = new int[]{1,2,3,5}, k = 3;
        Assertions.assertArrayEquals(new int[]{2,5}, kthSmallestPrimeFraction(arr, k));

    }
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> {
            return -(a[0]*b[1] - b[0]*a[1]);
        });

        for(int i = 0; i < arr.length; i++){
            for(int j =i+1; j < arr.length; j++){
                pq.add(new int[]{arr[i], arr[j]});
                if(pq.size() > k){
                    pq.remove();
                }
            }
        }
        int ans[];
        ans = pq.remove();
        return ans;
    }
}
