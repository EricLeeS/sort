package com.leetcode.ValidateBinarySearchTree;

public class Main {
	public static void main(String[] args){
		TreeNode t1=new TreeNode(3);
		TreeNode t2=new TreeNode(1);
		TreeNode t3=new TreeNode(5);
		TreeNode t4=new TreeNode(0);
		TreeNode t5=new TreeNode(2);
		TreeNode t6=new TreeNode(4);
		TreeNode t7=new TreeNode(6);
		t1.left=t2;
		t1.right=t3;
		t2.left=t4;
		t2.right=t5;
		t3.left=t6;
		t3.right=t7;
		Solution so = new Solution();
		System.out.println(so.isValidBST(t1));
		
	}
}
