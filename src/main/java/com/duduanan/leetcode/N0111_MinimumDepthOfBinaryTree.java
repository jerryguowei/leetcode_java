package com.duduanan.leetcode;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * Easy
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class N0111_MinimumDepthOfBinaryTree {

    @Test
    public void test() {

    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> qu = new LinkedList<>();
        qu.offer(root);
        int depth = 1;

        while (qu.size() > 0) {
            int size = qu.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = qu.poll();
                if (node.left == null && node.right == null) {
                    return depth;
                }

                if (node.left != null) qu.offer(node.left);
                if (node.right != null) qu.offer(node.right);
            }
            depth++;
        }
        return depth;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
