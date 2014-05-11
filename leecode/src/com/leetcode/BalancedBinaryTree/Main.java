package com.leetcode.BalancedBinaryTree;

public class Main {
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		TreeNode t7 = new TreeNode(7);
		TreeNode t8 = new TreeNode(8);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t4.left=t6;
		t4.right=t7;
		t7.left=t8;
		Solution so = new Solution();
		so.isBalanced(t1);
	}
}
