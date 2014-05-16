package com.leetcode.BinaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
    	ArrayList<Integer> ai = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	if(root==null)
    		return re;
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	Stack<TreeNode> tempStack = new Stack<TreeNode>();
    	stack.push(root);
    	int i=0;
    	while(!stack.isEmpty()){
    		TreeNode tempnode = stack.peek();
    		stack.pop();
    		ai.add(tempnode.val);
    		//���ݲ���Ĳ�����ȷ���Ǵ���������ӻ��Ǵ����������
    		//��֤stack�е�˳����������
    		if(i%2==0){
    			if(tempnode.left!=null){
        			tempStack.push(tempnode.left);
        		}
        		if(tempnode.right!=null){
        			tempStack.push(tempnode.right);
        		}
    		}else{
    			if(tempnode.right!=null){
        			tempStack.push(tempnode.right);
        		}
    			if(tempnode.left!=null){
        			tempStack.push(tempnode.left);
        		}
    		}
    		
    		if(stack.isEmpty()){
    			i++;
    			stack=tempStack;
    			
    			tempStack = new Stack<TreeNode>();
    			re.add(ai);
    			ai=new ArrayList<Integer>();
    		}
    		
    	}
		return re;
        
    }
}
