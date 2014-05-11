package com.leetcode.ValidateBinarySearchTree;

public class Solution {
    public boolean isValidBST(TreeNode root) {
    	if(root==null)
    		return true;
    	boolean left=false;
    	boolean right=false;
    	if(root.left!=null){
    		if(isLeftValid(root.left,root.val))
    			left = isValidBST(root.left);
    	}else{
    		left=true;
    	}
    	if(root.right!=null){
    		if(isRightValid(root.right,root.val))
    			right = isValidBST(root.right);
    	}else{
    		right=true;
    	}
    	return left&&right;
    }

	private boolean isRightValid(TreeNode right, int val) {
		// TODO Auto-generated method stub
		if(right!=null){
			if(right.val<=val)
				return false;
			return isRightValid(right.left,val)&&isRightValid(right.right, val);
		}else{
			return true;
		}
		
	}

	private boolean isLeftValid(TreeNode left, int val) {
		if(left!=null){
			if(left.val>=val)
				return false;
			return isLeftValid(left.left,val)&&isLeftValid(left.right, val);
		}else{
			return true;
		}
		
	}

	
}
