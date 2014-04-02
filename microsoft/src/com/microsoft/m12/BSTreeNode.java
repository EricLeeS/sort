package com.microsoft.m12;

public class BSTreeNode {
	private int n;
	private BSTreeNode  left;
	private BSTreeNode  right;
	BSTreeNode (int n){
		this.setN(n);
	}
	public BSTreeNode getLeft() {
		return left;
	}
	public void setLeft(BSTreeNode left) {
		this.left = left;
	}
	public BSTreeNode getRight() {
		return right;
	}
	public void setRight(BSTreeNode right) {
		this.right = right;
	}
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
	
}