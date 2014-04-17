package com.leetcode.BinaryTreeLevelOrderTraversal;

import java.util.*;
import java.util.Queue;
public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
    	ArrayList<Integer> temp =new ArrayList<Integer>();
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
        			re.add(temp);
        			temp=new ArrayList<Integer>();
        			root=queue.peek();
        		}else{
        			root = queue.peek();
        		}
        	}
        	return re;
    	}else{
    		return re;
    	}		
		
        
    }
}
