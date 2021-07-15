package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * 22. Generate Parentheses
 * Medium
 * Share
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class N0022_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, 0, 0, new StringBuilder(), result);
        return result;
    }
    public void generate(int n, int open, int close, StringBuilder sb, List<String> list) {
        if (open + close == 2 * n) {
            list.add(sb.toString());
            return;
        }

        if (open != n) {
            sb.append("(");
            generate(n, open + 1, close, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (open > close) {
            sb.append(")");
            generate(n, open, close + 1, sb, list);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        N0022_GenerateParentheses generateParentheses4 = new N0022_GenerateParentheses();
        List<String> result  = generateParentheses4.generateParenthesis(3);
        System.out.println(result);
    }
}
