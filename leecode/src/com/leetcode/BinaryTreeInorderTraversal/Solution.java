package com.leetcode.BinaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
    	ArrayList<Integer> re = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	TreeNode cur = root;
    	while(cur!=null||!stack.isEmpty()){
    		if(cur!=null){
    			stack.push(cur);
    			cur = cur.left;
    		}else{
    			re.add(stack.peek().val);
    			cur = stack.peek().right;
    			stack.pop();
    		}
    	}
    	return re;
        
    }
}
