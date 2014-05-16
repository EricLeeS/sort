package com.leetcode.ConstructBinaryTreefromPreorderandInorderTraversal;

public class Main {
	public static void main(String[] args){
		int[] pre = {1,2,4,5,3};
		int[] in = {4,2,5,1,3};
		Solution so = new Solution();
		so.buildTree(pre, in);
	}
}
