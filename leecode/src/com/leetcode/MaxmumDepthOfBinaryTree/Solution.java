package com.leetcode.MaxmumDepthOfBinaryTree;

public class Solution {
    public int maxDepth(TreeNode root) {
		if(root!=null){
			int depth=0;
			InOrder(root,depth);
		}
    	return max;
        
    }
    public int max=0;
	private void InOrder(TreeNode root, int depth) {
		if(root!=null){
			depth++;
			if(max<depth){
				max=depth;
			}
			InOrder(root.left,depth);
			InOrder(root.right,depth);
			depth--;
		}
		
	}
}