package com.duduanan.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class N0230_KthSmallestElementInaBST {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stk = new ArrayDeque<>();
        while(root != null || !stk.isEmpty()) {
            while(root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            k--;
            if(k == 0) return root.val;
            root = root.right;
        }
        return 0;
    }

    private Map<TreeNode, Integer> memo = new HashMap<>();
    public int kthSmallest1(TreeNode root, int k) {
        constructMemo(root);
        while(root != null) {
            int left = memo.getOrDefault(root.left, 0);
            if(left < k - 1) {
                root = root.right;
                k = k - left -1;
            } else if(left == k - 1) {
                break;
            } else {
                root = root.left;
            }
        }
        return root.val;
    }

    private int constructMemo(TreeNode root) {
        if (root == null) return 0;
        memo.put(root, constructMemo(root.left) + constructMemo(root.right) + 1);
        return memo.get(root);
    }
}
