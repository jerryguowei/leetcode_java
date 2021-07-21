package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class N0283_MoveZeroes {

    @Test
    public void test_moveZeroes() {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        Assertions.assertArrayEquals(new int[]{1,3,12,0,0}, nums);
    }
    public void moveZeroes(int[] nums) {
        int lastIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0 && lastIndex >= 0){
                if(lastIndex != i) {
                    int temp = nums[lastIndex];
                    nums[lastIndex] = nums[i];
                    nums[i] = temp;
                    lastIndex++;
                }
            } else if(nums[i] == 0 && lastIndex < 0){
                lastIndex = i;
            }
        }
    }
}
