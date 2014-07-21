package com.leetcode.BinaryTreeMaximumPathSum;

public class Main {
	public static void main(String[] args){
		TreeNode t1 = new TreeNode(2);
		TreeNode t2=new TreeNode(-1);
//		TreeNode t3 = new TreeNode(3);
//		TreeNode t4 = new TreeNode(4);
//		TreeNode t5 = new TreeNode(5);
//		TreeNode t6 = new TreeNode(6);
//		TreeNode t7 = new TreeNode(7);
//		TreeNode t8 = new TreeNode(8);
//		TreeNode t9 = new TreeNode(9);
		t1.left=t2;
//		t1.right=t3;
//		t2.left=t4;
//		t3.left=t8;
//		t3.right=t9;
		Solution so = new Solution();
		System.out.println(so.maxPathSum(t1));
	}
	
}
