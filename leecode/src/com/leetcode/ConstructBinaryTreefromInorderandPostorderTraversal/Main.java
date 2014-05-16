package com.leetcode.ConstructBinaryTreefromInorderandPostorderTraversal;

public class Main {
	public static void main(String[] args){
		int[] in={4,2,5,1,3};
		int[] post={4,5,2,3,1};
		Solution so = new Solution();
		so.buildTree(in, post);
	}
}
