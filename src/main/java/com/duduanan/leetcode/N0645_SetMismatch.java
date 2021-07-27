package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * 645. Set Mismatch
 * Easy  the same as 448
 * You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 *
 * You are given an integer array nums representing the data status of this set after the error.
 *
 * Find the number that occurs twice and the number that is missing and return them in the form of an array.
 *
 *
 */
public class N0645_SetMismatch {

    @Test
    public void  test_SetMismatch() {
        int[] nums = {1, 2, 2, 4};
        int[] result = findErrorNums(nums);
        System.out.println(Arrays.toString(result));
    }


    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];

        for(int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]) - 1;
            if(nums[idx] > 0){
                nums[idx] *= -1;
            } else {
                result[0] = idx + 1;
            }
        }

        for(int i = 0; i <nums.length; i++) {
            if(nums[i] > 0) result[1] = i + 1;

        }
        return result;
    }
}
