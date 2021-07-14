package com.duduanan.leetcode;

public class N0201_BitwiseANDOfNumberRange {
    public int rangeBitwiseAnd(int left, int right) {
        int count = 0;
        int diff = right - left;
        if(diff == 0) return left;
        while(diff != 1){
            diff = diff >>> 1;
            count++;
        }
        count++;
        left = (left >>> count) << count;
        right = (right >>> count) << count;
        return left & right;
    }
    public static void  main(String[] args) {
        N0201_BitwiseANDOfNumberRange bitwiseANDOfNumberRange201 = new N0201_BitwiseANDOfNumberRange();
        int result =bitwiseANDOfNumberRange201.rangeBitwiseAnd(5, 7);
        System.out.println(result);
    }
}
