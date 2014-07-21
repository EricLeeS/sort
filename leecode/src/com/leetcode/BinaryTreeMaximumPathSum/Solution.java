package com.leetcode.BinaryTreeMaximumPathSum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxPathSum(TreeNode root) {
    	if(root==null)
    		return 0;
    	TreeNode head = root;
    	isMaxPathSum(head);
    	preOrder(root);
		return max;
        
    }
    public int max=Integer.MIN_VALUE;
	private void preOrder(TreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null){
			int re = root.val;
			if(root.left!=null&&map.get(root.left)>=0)
				re+=map.get(root.left);
			if(root.right!=null&&map.get(root.right)>=0)
				re+=map.get(root.right);
			if(re>max)
				max=re;
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	public Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
	private int isMaxPathSum(TreeNode node) {
		// TODO Auto-generated method stub
		if(node==null)
			return 0;
		int re = node.val+Math.max(isMaxPathSum(node.left), isMaxPathSum(node.right));
		if(re<=node.val){
			map.put(node, node.val);
			return node.val;
		}else{
			map.put(node, re);
			return re;
		}
			
			
	}
}
