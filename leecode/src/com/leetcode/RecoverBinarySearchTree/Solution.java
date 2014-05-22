package com.leetcode.RecoverBinarySearchTree;

import java.util.Stack;

public class Solution {
    public void recoverTree(TreeNode root) {
        if(root!=null){
        	Stack<TreeNode> stack = new Stack<TreeNode>();
        	TreeNode cur = root;
        	int min=Integer.MIN_VALUE;
        	int preint = Integer.MIN_VALUE;
        	TreeNode pre=root;
        	TreeNode after=pre;
        	boolean bol = true;
        	while(!stack.isEmpty()||cur!=null){
        		while(cur!=null){
        			stack.push(cur);
        			cur=cur.left;
        		}
        		if(!stack.isEmpty()){
        			int temp = stack.peek().val;
        			if(bol&&temp>preint){
        				preint = temp;
        				pre=stack.peek();
        			}
        			if(bol&&temp<preint){
        				bol=false;
        				min=temp;
        				after=stack.peek();
            			cur=stack.peek().right;
            			stack.pop();
            			continue;
        			}
        			if(!bol&&temp<min){
        				min=temp;
        				after=stack.peek();
        			}
        			cur=stack.peek().right;
        			stack.pop();
        			
        		}
        	}
        	int tt  = pre.val;
        	pre.val=after.val;
        	after.val=tt;
        }
    }
}