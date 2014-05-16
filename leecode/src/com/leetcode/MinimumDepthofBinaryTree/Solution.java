package com.leetcode.MinimumDepthofBinaryTree;

public class Solution {
    public int minDepth(TreeNode root) {
    	int depth=0;
    	if(root!=null){
    		 minPath(root,depth);
    		 return min;
    	}
        return 0;
    }
    public int min = 0;
    private void minPath(TreeNode root, int depth) {
    	if(root!=null){
    		depth++;
    		if(root.left==null&&root.right==null){
    			if(min==0){
    				depth=min;
    			}else{
    				if(min>depth)
    					min=depth;
    			}
    		}
    		minPath(root.left,depth);
    		minPath(root.right,depth);
    		depth--;
    	}
		
	}
	
}