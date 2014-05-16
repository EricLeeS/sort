package com.leetcode.ConstructBinaryTreefromPreorderandInorderTraversal;

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	if(preorder.length==0||inorder.length==0)
    		return null;
    	return BuildTreeNode(preorder,0,preorder.length-1,inorder,0,inorder.length-1);
    	
    	
    	
        
    }

	private TreeNode BuildTreeNode(int[] preorder, int prestart, int preend, int[] inorder,
			int instart, int inend) {
		if(prestart>preend||instart>inend)
			return null;
		int temp = preorder[prestart];
		TreeNode root = new TreeNode(temp);
		int leftlength=0;
		
		for(int i=instart;i<=inend;i++){
			if(inorder[i]!=temp)
				leftlength++;
			else if(inorder[i]==temp)
				break;
		}
		root.left=BuildTreeNode(preorder, prestart+1, prestart+leftlength, inorder, instart,instart+leftlength-1);
		root.right=BuildTreeNode(preorder,prestart+leftlength+1,preend,inorder,instart+leftlength+1,inend);
		return root;
	}
}
