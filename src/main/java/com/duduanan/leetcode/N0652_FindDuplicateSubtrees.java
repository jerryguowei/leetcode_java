package com.duduanan.leetcode;

import com.duduanan.leetcode.N0111_MinimumDepthOfBinaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N0652_FindDuplicateSubtrees {
    Map<String, Integer> memo = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        reverse(root);
        return res;
    }

    String reverse(TreeNode root) {
        if(root == null) return "#";
        String str =  reverse(root.left) + "," + reverse(root.right) + "," + root.val;
        memo.put(str, memo.getOrDefault(str, 0) + 1);
        if(memo.get(str) == 2) {
            res.add(root);
        }
        return str;
    }
}
