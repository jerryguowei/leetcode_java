package com.duduanan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class N0105_ConstructBinaryTree {
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        TreeNode root = build(preorder, inorder, 0, n-1, 0, n-1);
        return root;
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorder_left, int preorder_right,
                          int inorder_left, int inorder_right) {
        if(preorder_left > preorder_right) return null;
        int rootVal = preorder[preorder_left];
        int rootIndex = map.get(rootVal);
        int leftLength =  rootIndex - inorder_left;

        TreeNode root = new TreeNode(rootVal);
        root.left = build(preorder,inorder, preorder_left + 1, preorder_left + leftLength, inorder_left, rootIndex-1);
        root.right = build(preorder, inorder, preorder_left + leftLength + 1, preorder_right,  rootIndex + 1, inorder_right);

        return root;
    }
}
