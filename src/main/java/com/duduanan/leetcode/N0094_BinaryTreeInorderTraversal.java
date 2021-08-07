package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 94. Binary Tree Inorder Traversal
 * Easy
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */
public class N0094_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        inorder(root, res);
        return res;

    }
    private void inorder(TreeNode node, List<Integer> res){

        if(node.left!=null){
            inorder(node.left, res);
        }
        res.add(node.val);
        if(node.right != null){
            inorder(node.right, res);
        }
    }
}
