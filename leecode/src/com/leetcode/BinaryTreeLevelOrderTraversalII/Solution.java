package com.leetcode.BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;



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
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
    	ArrayList<Integer> temp =new ArrayList<Integer>();
    	Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	Queue<TreeNode> tempqueue = new LinkedList<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if(root!=null){
    		queue.offer(root);

        	while(root!=null){
        		temp.add(root.val);
        		if(root.left!=null){
        			tempqueue.offer(root.left);
        		}
        		if(root.right!=null){
        			tempqueue.offer(root.right);
        		}
        		
        		queue.poll();
        		if(queue.size()==0){
        			queue=tempqueue;
        			tempqueue= new LinkedList<TreeNode>();
        			stack.push(temp);
        			temp=new ArrayList<Integer>();
        			root=queue.peek();
        		}else{
        			root = queue.peek();
        		}
        	}
        	while(!stack.isEmpty()){
        		re.add(stack.peek());
        		stack.pop();
        	}
        	
        	return re;
    	}else{
    		return re;
    	}		
		
        
    }
}
