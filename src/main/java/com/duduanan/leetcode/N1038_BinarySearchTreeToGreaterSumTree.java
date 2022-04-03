package com.duduanan.leetcode;

public class N1038_BinarySearchTreeToGreaterSumTree {
    int val = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null) return null;
        bstToGst(root.right);
        val += root.val;
        root.val = val;
        bstToGst(root.left);
        return root;
    }
}
