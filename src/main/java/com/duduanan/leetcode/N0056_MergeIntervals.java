package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. Merge Intervals
 * Medium
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the non-overlapping
 * intervals that cover all the intervals in the input.
 */
public class N0056_MergeIntervals {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        List<int[]> res = new ArrayList<>();
        int n = intervals.length;
        int start = intervals[0][0], end = intervals[0][1];

        for(int i = 1; i < n; i++) {
            if(intervals[i][0] <= end){
                end = Math.max(intervals[i][1], end);
            } else {
                int temp[] = {start, end};
                res.add(temp);
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        res.add(new int[]{start, end});
        return res.toArray(new int[0][0]);
    }
}
