package com.leetcode.BinaryTreeZigzagLevelOrderTraversal;

public class Main {
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t3.right=t5;
		Solution so = new Solution();
		so.zigzagLevelOrder(t1);
	}
}
