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
        	tempqueue.offer(cur.left);
        	tempqueue.offer(cur.right);
        	if(queue.isEmpty()){
        		cur.next=null;
        		queue=tempqueue;
        	}else{
        		cur.next=queue.peek();
        	}
        }
    }
}
