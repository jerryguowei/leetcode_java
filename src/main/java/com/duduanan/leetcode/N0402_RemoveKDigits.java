package com.duduanan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/***
 * 402. Remove K Digits
 * Medium
 * Given string num representing a non-negative integer num, and an integer k,
 * return the smallest possible integer after removing k digits from num.
 */
public class N0402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();
        char[] numChar = num.toCharArray();
        for(int i = 0; i < numChar.length; i++) {
            char c = numChar[i];
            while(k > 0 && !stack.isEmpty() && stack.peek() > c){
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        while(k-- > 0){
            stack.pop();
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();
        while(sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        if(sb.length() == 0) return "0";
        return sb.toString();
    }
}
