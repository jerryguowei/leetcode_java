package com.duduanan.leetcode;

public class N1961_checkIfStringIsAPrifixOfArray {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        for(String w: words){
            sb.append(w);
            if(s.equals(sb.toString())){
                return true;
            }
            if(!s.startsWith(sb.toString())){
                return false;
            }
        }
        return s.equals(sb.toString());
    }
}
