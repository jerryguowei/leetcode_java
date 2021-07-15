package com.duduanan.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**6. ZigZag Conversion
 * Medium
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 */

public class N0006_ZIGZAGConversion {
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0; i < numRows; i++){
            list.add(new StringBuilder());
        }

        int row = 0;
        int a = 1;
        if(numRows == 1) {
            return s;
        }
        for(char c : s.toCharArray()) {
            list.get(row).append(c);
            row = row + a;
            if(row == numRows -1 || row == 0) a = -a;
        }
        for(int i = 1; i < list.size(); i++){
            list.get(0).append(list.get(i));
        }
        return list.get(0).toString();
    }

    @Test
    public void test() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        Assertions.assertEquals("PINALSIGYAHRPI", convert(s, numRows));
    }

}
