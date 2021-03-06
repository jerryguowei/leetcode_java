package com.duduanan.leetcode;

/***
 * 98. Validate Binary Search Tree
 * Medium
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class N0098_ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
    private boolean helper(TreeNode node, Integer min, Integer max) {
        if(min != null && node.val <= min) return false;
        if(max != null && node.val >= max) return false;

        if(node.left != null){
            if(node.left.val >= node.val){
                return false;
            }
            if(!helper(node.left, min, node.val)) return false;
        }
        if(node.right != null) {
            if(node.right.val <= node.val) {
                return false;
            }
            if(!helper(node.right, node.val, max)) return false;
        }
        return true;
    }
}
