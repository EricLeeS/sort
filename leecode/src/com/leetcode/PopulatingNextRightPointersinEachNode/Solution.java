package com.leetcode.PopulatingNextRightPointersinEachNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        Queue<TreeLinkNode> tempqueue = new LinkedList<TreeLinkNode>();
        if(null==root)
        	return;
        queue.offer(root);
        TreeLinkNode cur=root;
        while(!queue.isEmpty()||cur!=null){
        	cur = queue.peek();
        	queue.poll();
        	if(cur.left!=null)
        		tempqueue.offer(cur.left);
        	if(cur.right!=null)
        		tempqueue.offer(cur.right);
        	

        	if(queue.isEmpty()){
        		cur.next=null;
        		cur=null;
        		queue=tempqueue;
        		tempqueue=new LinkedList<TreeLinkNode>();
        	}else{
        		cur.next=queue.peek();
        		cur=null;
        	}
        }
    }
}
