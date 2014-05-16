package com.leetcode.FlattenBinaryTreetoLinkedList;

public class Main {
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left=t2;
//		t2.left=t3;
//		t2.right=t4;
//		t1.right=t5;
//		t5.right=t6;
		Solution so = new Solution();
		so.flatten(t1);
	}
}
