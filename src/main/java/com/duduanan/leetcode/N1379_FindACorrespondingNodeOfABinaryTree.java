package com.duduanan.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 * Medium
 * Given two binary trees original and cloned and given a reference to a node target in the original tree.
 *
 * The cloned tree is a copy of the original tree.
 *
 * Return a reference to the same node in the cloned tree.
 *
 * Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.
 *
 * Follow up: Solve the problem if repeated values on the tree are allowed.
 */
public class N1379_FindACorrespondingNodeOfABinaryTree {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        List<String> route = new ArrayList<>();
        helper(original, route, target);

        TreeNode ref = cloned;
        for(String d : route){
            if("left".equals(d)){
                ref = ref.left;
            } else {
                ref = ref.right;
            }
        }
        return ref;
    }
    public boolean helper(TreeNode node, List<String> route, TreeNode target){
        if(node == target){
            return true;
        }

        if(node.left != null){
            route.add("left");
            if(helper(node.left, route, target)){
                return true;
            }
            route.remove(route.size() - 1);
        }
        if(node.right != null){
            route.add("right");
            if(helper(node.right, route, target)){
                return true;
            }
            route.remove(route.size() - 1);
        }
        return false;
    }

}
