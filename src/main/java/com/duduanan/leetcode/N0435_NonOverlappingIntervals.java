package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class N0435_NonOverlappingIntervals {

    @Test
    public void test() {
        int[][] intervals= {{1,2},{2,3},{3,4},{1,3}};
        Assertions.assertEquals(1, eraseOverlapIntervals(intervals));
    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int i = 0 ,j = i+1;
        int res = 0;
        while(j < intervals.length) {
            if(isOverlapping(intervals[i], intervals[j])){
                res++;
            } else {
                i = j;
            }
            j++;
        }
        return res;
    }

    boolean isOverlapping(int[] a, int[] b){
        if(b[0]<a[1] &&b[1] > a[0]){
            return true;
        }
        return false;
    }
}
