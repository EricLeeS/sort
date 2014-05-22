package com.leetcode.RecoverBinarySearchTree;

public class Main {
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(8);
		TreeNode t2 = new TreeNode(10);
		TreeNode t3 = new TreeNode(7);
		TreeNode t4 = new TreeNode(9);
		TreeNode t5 = new TreeNode(12);
		TreeNode t6 = new TreeNode(11);
		TreeNode t7 = new TreeNode(13);
		t1.left=t2;
		t1.right=t5;
		t2.left=t3;
		t2.right=t4;
		t5.left=t6;
		t5.right=t7;
		Solution so = new Solution();
		so.recoverTree(t1);
	}
}
