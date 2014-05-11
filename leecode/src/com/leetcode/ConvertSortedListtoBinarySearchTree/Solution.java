package com.leetcode.ConvertSortedListtoBinarySearchTree;


public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	TreeNode no = BuildBST(head,null);
		return no;
        
    }

	private TreeNode BuildBST(ListNode start, ListNode end) {
		if(start==end)
			return null;
		ListNode slow = start;
		ListNode fast = start;
		
		while(fast!=end&&fast.next!=end){
			
			slow=slow.next;
			fast=fast.next.next;
		}
		TreeNode root = new TreeNode(slow.val);
		root.left=BuildBST(start,slow);
		root.right=BuildBST(slow.next,end);
		return root;
		
	}
}
