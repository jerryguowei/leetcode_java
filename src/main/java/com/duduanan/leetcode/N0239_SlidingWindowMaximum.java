package com.duduanan.leetcode;

import java.util.*;

public class N0239_SlidingWindowMaximum {


    public static int[] maxSlidingWindow(int[] nums, int k) {
        int[] output = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>(k);
        for(int i = 0; i < nums.length; i++) {
            if(!deque.isEmpty() && deque.getFirst() < i -k + 1) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }
            deque.addLast(i);
            if(i >= k-1) {
                output[i+1-k] = nums[deque.getFirst()];
            }

        }
        return output;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));

    }

}
/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Example 3:
 *
 * Input: nums = [1,-1], k = 1
 * Output: [1,-1]
 * Example 4:
 *
 * Input: nums = [9,11], k = 2
 * Output: [11]
 * Example 5:
 *
 * Input: nums = [4,-2], k = 2
 * Output: [4]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 *
 *
 *
 * */

//public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] output = new int[nums.length - k + 1];
//        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
//        for(int i = 0; i < nums.length; i++){
//            int in = nums[i];
//
//            Integer count= treeMap.get(in);
//            if(count == null) count = 0;
//            count++;
//            treeMap.put(in, count);
//
//            if(i > k-1) {
//                int out = nums[i-k];
//                if(treeMap.get(out) <= 1){
//                    treeMap.remove(out);
//                } else {
//                    treeMap.put(out, treeMap.get(out) - 1);
//                }
//            }
//            if(i >= k-1){
//                int max = treeMap.lastKey();
//                output[i-k+1] = max;
//            }
//        }
//        return output;
//    }