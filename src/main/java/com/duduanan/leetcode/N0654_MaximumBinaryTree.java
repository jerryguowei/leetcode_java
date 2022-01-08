package com.duduanan.leetcode;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

public class N0654_MaximumBinaryTree{

    @Test
    public void test() {
        TreeNode node = constructMaximumBinaryTree(new int[]{3,2,1,6,0,5});
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length - 1);
    }

    public TreeNode construct(int[] nums, int low, int hi) {
        if(low > hi) return null;
        int max = nums[low];
        int idx = low;
        for(int i = low + 1; i <= hi; i++){
            if(nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = construct(nums, low, idx-1);
        root.right = construct(nums, idx+1, hi);
        return root;
    }
}
