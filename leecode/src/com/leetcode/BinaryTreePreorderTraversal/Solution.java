package com.leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
		ArrayList<Integer> re = new ArrayList<Integer>();
    	if(root!=null){
    		return preOrder(root,re);
		}else{
			return re;
		}
    	
        
    }
    
    public ArrayList<Integer> preOrder(TreeNode root,ArrayList<Integer> re){
    	if(root!=null){
    		re.add(root.val);
    		preOrder(root.left,re);
    		preOrder(root.right,re);
    	}
    	return re;
    }
}
