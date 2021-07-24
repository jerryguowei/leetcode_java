package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.List;

/***
 * 113. Path Sum II
 * Medium
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where each path's sum equals targetSum.
 *
 * A leaf is a node with no children.
 */
public class N0113_PathSum2 {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(root.val);
        helper(root, res, path, root.val, targetSum);
        return res;
    }

    public void helper(TreeNode node, List<List<Integer>> res, List<Integer> path, int curr, int target){
        if(node.left == null && node.right == null){
            if(curr == target){
                res.add(new ArrayList<>(path));
            }
            return;
        }
        if(node.left != null){
            curr += node.left.val;
            path.add(node.left.val);
            helper(node.left, res, path, curr, target);
            curr-= node.left.val;
            path.remove(path.size() -1);
        }
        if(node.right != null){
            curr += node.right.val;
            path.add(node.right.val);
            helper(node.right, res, path, curr, target);
            curr-= node.right.val;
            path.remove(path.size() -1);
        }
    }
}
