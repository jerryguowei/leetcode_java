package com.duduanan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/***
 * 496. Next Greater Element I
 * The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.
 *
 * You are given two distinct 0-indexed integer arrays nums1 and nums2, where nums1 is a subset of nums2.
 *
 * For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2. If there is no next greater element, then the answer for this query is -1.
 *
 * Return an array ans of length nums1.length such that ans[i] is the next greater element as described above.
 */
public class N0496_NextGreaterElement1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++ ){
            map.put(nums1[i], i);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i = nums2.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() < nums2[i]) stack.pop();
            Integer idx = map.get(nums2[i]);
            if(idx != null) {
                if(stack.isEmpty()) {
                    res[idx] = -1;
                } else {
                    res[idx] = stack.peek();
                }
            }
            stack.push(nums2[i]);
        }
        return res;
    }
}
