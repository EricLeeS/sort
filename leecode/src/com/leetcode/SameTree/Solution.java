package com.leetcode.SameTree;

import java.util.Stack;

public class Solution {
    
	public boolean isSameTree(TreeNode p, TreeNode q) {
		Stack<TreeNode> pstack = new Stack<TreeNode>();
		Stack<TreeNode> qstack = new Stack<TreeNode>();
		if(null==p&&null==q){
			return true;
		}
		if(null==p||null==q){
			return false;
		} else {
			while(!pstack.isEmpty()||!qstack.isEmpty()||p!=null||q!=null){
				if(p!=null&&q!=null){
					if(p.val!=q.val){
						return false;
					}
					pstack.push(p);
					qstack.push(q);
					p=p.left;
					q=q.left;
					if(q==null&&p!=null)
						return false;
					if(p==null&&q!=null)
						return false;
					
				}else{
					p=pstack.peek().right;
					pstack.pop();
					q=qstack.peek().right;
					qstack.pop();
				}
				
			}
			return true;
		}
		
    	
        
    }
}