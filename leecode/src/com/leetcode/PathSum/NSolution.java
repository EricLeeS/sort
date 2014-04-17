package com.leetcode.PathSum;

import java.util.Stack;

public class NSolution {
    public boolean hasPathSum(TreeNode root, int sum) {
		boolean re = false;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		int init=0;
		TreeNode cur = root;
		int pre =0;
		while(!stack.isEmpty()||cur!=null){
			if(cur!=null){
				stack.push(cur);
				init+=cur.val;				
				if((init+pre)==sum){
					if(cur.left==null&&cur.right==null){
						re=true;
						break;
					}
				}
				cur=cur.left;
				
			}
			else{
				init = init-stack.peek().val;
				pre = stack.peek().val;
				cur=stack.peek().right;
				stack.pop();
				
			}
			
		}
		
		
		while(!stack.isEmpty()||cur!=null){
			if(cur!=null){
				stack.push(cur);
				init+=cur.val;				
				if((init+pre)==sum){
					if(cur.left==null&&cur.right==null){
						re=true;
						break;
					}
				}
				cur=cur.right;
				
			}
			else{
				init = init-stack.peek().val;
				pre = stack.peek().val;
				cur=stack.peek().left;
				stack.pop();
				
			}
			
		}
		
		
		
		
		
		return re;
    	
        
    }
}
