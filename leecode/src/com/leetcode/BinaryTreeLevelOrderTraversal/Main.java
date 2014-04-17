package com.leetcode.BinaryTreeLevelOrderTraversal;

public class Main {
	public static void main(String[] args){
		TreeNode t1 =new  TreeNode(3);
		TreeNode t2 =new  TreeNode(9);
		TreeNode t3 =new  TreeNode(20);
		TreeNode t4 =new  TreeNode(15);
		TreeNode t5 =new  TreeNode(7);
		t1.left=t2;
		t1.right=t3;
		t3.left=t4;
		t3.right=t5;
		Solution so = new Solution();
		so.levelOrder(t1);
		
	}
}
