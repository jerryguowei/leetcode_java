package com.duduanan.leetcode;

import java.util.*;

/**
 * 103. Binary Tree Zigzag Level Order Traversal
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right, then right to left for the next level and alternate between).
 */

public class N0103_BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        boolean revese = false;
        List<List<Integer>> result = new ArrayList<>();
        while(!q1.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int sz = q1.size();
            for(int i = 0; i < sz; i++) {
                TreeNode t = q1.poll();
                list.add(t.val);
                if(t.left != null) q1.offer(t.left);
                if(t.right != null) q1.offer(t.right);
            }
            if(revese) Collections.reverse(list);
            revese = !revese;
            result.add(list);
        }
        return result;
    }
}
