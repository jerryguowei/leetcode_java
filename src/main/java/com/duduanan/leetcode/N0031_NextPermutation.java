package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N0031_NextPermutation {
    @Test
    public void test()
    {
        int[] nums = {1, 1, 5};

        nextPermutation(nums);

        System.out.println(Arrays.toString(nums));
    }
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1])
        {
            i--;
        }
        if(i >= 0)
        {
            int j = nums.length -1;
            while(j > i && nums[j] <= nums[i])
            {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start)
    {
        int left = start, right = nums.length - 1;
        while(left < right)
        {
            swap(nums, left++, right--);
        }
    }

}
