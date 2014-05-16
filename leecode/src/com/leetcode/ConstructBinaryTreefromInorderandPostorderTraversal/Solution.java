package com.leetcode.ConstructBinaryTreefromInorderandPostorderTraversal;



public class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	if(postorder.length==0||inorder.length==0)
    		return null;
    	return BuildTreeNode(inorder,0,inorder.length-1,postorder,0,postorder.length-1);
		
        
    }

	private TreeNode BuildTreeNode(int[] inorder, int instart, int inend,
			int[] postorder, int poststart, int postend) {
		if(inend<instart||postend<poststart)
			return null;
		int temp = postorder[postend];
		TreeNode root = new TreeNode(temp);
		int length = 0;
		for(int i=instart;i<=inend;i++){
			if(inorder[i]!=temp)
				length++;
			else if(inorder[i]==temp)
				break;
		}
		root.left=BuildTreeNode(inorder, instart, instart+length-1, postorder, poststart, poststart+length-1);
		root.right=BuildTreeNode(inorder, instart+length+1, inend, postorder, poststart+length, postend-1);
		return root;
	}
}
