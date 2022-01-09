package com.duduanan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class N0538_ConvertBSTToGreaterTree {
    public TreeNode convertBST(TreeNode root) {
        TreeNode rootNode = root;
        Deque<TreeNode> stk = new ArrayDeque<>();
        int val = 0;
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.right;
            }
            root = stk.pop();
            root.val += val;
            val = root.val;
            root = root.left;
        }
        return rootNode;
    }

    int val = 0;
    public TreeNode convertBST1(TreeNode root) {
        if(root == null) return null;
        convertBST(root.right);
        root.val += val;
        val = root.val;
        convertBST(root.left);
        return root;
    }
}
