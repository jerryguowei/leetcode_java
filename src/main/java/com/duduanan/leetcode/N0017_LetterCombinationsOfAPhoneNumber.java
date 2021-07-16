package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0017_LetterCombinationsOfAPhoneNumber {

    private Map<Character, String> map = new HashMap<>();
    {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    private List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder());
        return result;
    }

    public void backtrack(String digits, int i, StringBuilder sb) {
        if(i == digits.length()){
            result.add(sb.toString());
            return;
        }
        for(char c : map.get(digits.charAt(i)).toCharArray()) {
            sb.append(c);
            backtrack(digits, i + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }



//    public List<String> letterCombinations(String digits) {
//        List<String> result = new ArrayList<>();
//        for(int i = 0; i < digits.length(); i++){
//            int digit = Integer.parseInt("" + digits.charAt(i));
//            List<Character> list = getCharacterList(digit);
//            List<String> tempList = new ArrayList<>();
//            for(Character ch : list) {
//                String temp = "" + ch;
//                if(result.isEmpty()){
//                    tempList.add(temp);
//                } else {
//                    for(String st: result){
//                        tempList.add(st+temp);
//                    }
//                }
//            }
//            result = tempList;
//        }
//        return result;
//    }

//    private List<Character> getCharacterList(int digit) {
//        List<Character> list = new ArrayList<>();
//        int num = 3;
//        if(digit == 7 || digit == 9) num = 4;
//        int start = 'a' + (digit - 2) * 3;
//        if(digit > 7){
//            start++; //7 has 7 nums;
//        }
//
//        for(int i = 0; i < num; i++){
//            list.add((char)(start + i));
//        }
//        return list;
//    }
    public static void main(String[] args) {
        N0017_LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber17 = new N0017_LetterCombinationsOfAPhoneNumber();
        System.out.println(letterCombinationsOfAPhoneNumber17.letterCombinations("23"));
    }
}
/**
 *17. Letter Combinations of a Phone Number
 * Medium
 *
 * 6296
 *
 * 534
 *
 * Add to List
 *
 * Share
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.
 *
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 *
 * Input: digits = ""
 * Output: []
 * Example 3:
 *
 * Input: digits = "2"
 * Output: ["a","b","c"]
 *
 *
 * Constraints:
 *
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * Accepted
 * 860,753
 * Submissions
 * 1,705,616
 * */