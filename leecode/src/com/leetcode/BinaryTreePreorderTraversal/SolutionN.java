package com.leetcode.BinaryTreePreorderTraversal;

import java.util.ArrayList;

public class SolutionN {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> re = new ArrayList<Integer>();
    	if(root!=null){
    		return postOrder(root,re);
		}else{
			return re;
		}
    }

    public ArrayList<Integer> postOrder(TreeNode root,ArrayList<Integer> re){
    	if(root!=null){
    		
    		postOrder(root.left,re);
    		postOrder(root.right,re);
    		re.add(root.val);
    	}
    	return re;
    }
}