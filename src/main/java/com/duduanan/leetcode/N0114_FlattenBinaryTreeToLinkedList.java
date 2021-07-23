package com.duduanan.leetcode;

/**
 * 114. Flatten Binary Tree to Linked List
 * Medium
 * Given the root of a binary tree, flatten the tree into a "linked list":
 *
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 *
 */
public class N0114_FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if(root == null) return;
        helper(root);
    }
    public TreeNode helper(TreeNode node){
        TreeNode right = node.right;
        if(node.left != null){
            node.right = node.left;
            node.left = null;
            node = helper(node.right);
        }
        if(right != null) {
            node.right = right;
            node = helper(node.right);
        }
        return node;
    }
}
