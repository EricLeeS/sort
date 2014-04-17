package com.leetcode.PathSum;

public class Main {
	public static void main(String[] args){
//		TreeNode t1 = new TreeNode(5);
//		TreeNode t2 = new TreeNode(4);
//		TreeNode t3 = new TreeNode(8);
//		TreeNode t4 = new TreeNode(11);
//		TreeNode t5 = new TreeNode(13);
//		TreeNode t6 = new TreeNode(4);
//		TreeNode t7 = new TreeNode(7);
//		TreeNode t8 = new TreeNode(2);
//		TreeNode t9 = new TreeNode(1);
//		t1.left=t2;
//		t1.right=t3;
//		t2.left=t4;
//		t4.left=t7;
//		t4.right=t8;
//		t3.left=t5;
//		t3.right=t6;
//		t6.right=t9;
		TreeNode t1=new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		t1.left=t2;
		Solution so = new Solution();
		System.out.println(so.hasPathSum(t1, 3));
	}
}
