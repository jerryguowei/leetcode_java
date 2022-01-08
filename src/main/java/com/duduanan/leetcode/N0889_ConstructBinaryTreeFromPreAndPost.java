package com.duduanan.leetcode;

import java.util.HashMap;
import java.util.Map;

public class N0889_ConstructBinaryTreeFromPreAndPost {
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        for(int i = 0; i < n; i++){
            map.put(postorder[i], i);
        }

        return build(preorder, postorder, 0, n-1, 0, n-1);
    }


    TreeNode build(int[] preorder, int[] postorder, int preStart, int preEnd, int postStart, int postEnd) {
        if(preStart > preEnd) return null;
        TreeNode root =  new TreeNode(preorder[preStart]);
        if(preStart == preEnd) return root;

        int postLeftEnd = map.get(preorder[preStart + 1]);
        int leftLength = postLeftEnd - postStart + 1;

        root.left = build(preorder, postorder, preStart + 1, preStart + leftLength, postStart, postLeftEnd);
        root.right = build(preorder, postorder, preStart + leftLength + 1, preEnd, postLeftEnd + 1,  postEnd-1);
        return root;
    }
}
