package com.leetcode.SymmtricTree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root!=null){
        	return isMir(root.left,root.right);
        }
        return true;
    }

	private boolean isMir(TreeNode left, TreeNode right) {
		// TODO Auto-generated method stub
		if(left==null&&right!=null)
			return false;
		if(left!=null&&right==null)
			return false;
		if(left==null&&right==null)
			return true;
		if(left.val!=right.val)
			return false;
		
		return isMir(left.left,right.right)&&isMir(left.right,right.left);
	}
}
