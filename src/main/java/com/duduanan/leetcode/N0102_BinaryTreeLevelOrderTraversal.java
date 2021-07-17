package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. Binary Tree Level Order Traversal
 * Medium
 *
 * Share
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 *
 *
 */
class TreeNode {
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

public class N0102_BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        List<List<Integer>> result = new ArrayList<>();
        while (!q1.isEmpty()) {
            int sz = q1.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q1.poll();
                temp.add(cur.val);
                if (cur.left != null) q1.offer(cur.left);
                if (cur.right != null) q1.offer(cur.right);
            }
            result.add(temp);
        }
        return result;
    }
}
