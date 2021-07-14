package com.duduanan.leetcode;

public class N0012_IntegerToRoman {
    public String intToRoman(int num) {
        int b = 1;
        int mod = 0;
        StringBuilder sb = new StringBuilder();
        while(num > 0){
            mod = num % 10;
            int l = 0;
            int r = 0;
            int rt = 1;
            if(mod==9){
                l = 1;
                r = 10;
            } else if(mod >=5) {
                l = 5;
                r = 1;
                rt = mod - 5;
            } else if(mod == 4){
                l = 1;
                r = 5;
            } else {
                r = 1;
                rt = mod;
            }
            // System.out.println(mod + ":" + l + ":" + r + ":" + b + ":rt" + rt);
            if(r > 0) {
                char temp = getChar(r * b);
                for(int n = 0; n <rt; n++){
                    sb.append(temp);
                }
                if(l > 0){
                    sb.append(getChar(l * b));
                }

            }
            num = num / 10;
            b = b * 10;
        }
        return sb.reverse().toString();
    }
    private char getChar(int num){

        switch(num) {
            case 1: return 'I';
            case 5: return 'V';
            case 10: return 'X';
            case 50 : return 'L';
            case 100: return 'C';
            case 500: return 'D';
            default:
                return 'M';
        }
    }
    public static void main(String[] args){
        N0012_IntegerToRoman integerToRoman12 = new N0012_IntegerToRoman();

        System.out.println(integerToRoman12.intToRoman(58));

    }
}
/**
 * 12. Integer to Roman
 * Medium
 *
 * 1839
 *
 * 3213
 *
 * Add to List
 *
 * Share
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two one's added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 3
 * Output: "III"
 * Example 2:
 *
 * Input: num = 4
 * Output: "IV"
 * Example 3:
 *
 * Input: num = 9
 * Output: "IX"
 * Example 4:
 *
 * Input: num = 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 * Example 5:
 *
 * Input: num = 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 *
 * Constraints:
 *
 * 1 <= num <= 3999
 * Accepted
 * 500,402
 * Submissions
 * 870,373
 * */