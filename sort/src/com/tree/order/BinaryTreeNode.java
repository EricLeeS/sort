package com.tree.order;

public class BinaryTreeNode {
	private BinaryTreeNode llink = null;
	private BinaryTreeNode rlink = null;
	private String info;
	private int lflag=0;
	private int rflag=0;
	public BinaryTreeNode(String info){
		this.info = info;
	}
	public BinaryTreeNode getLlink() {
		return llink;
	}
	public void setLlink(BinaryTreeNode llink) {
		this.llink = llink;
	}
	public BinaryTreeNode getRlink() {
		return rlink;
	}
	public void setRlink(BinaryTreeNode rlink) {
		this.rlink = rlink;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getLflag() {
		return lflag;
	}
	public void setLflag(int lflag) {
		this.lflag = lflag;
	}
	public int getRflag() {
		return rflag;
	}
	public void setRflag(int rflag) {
		this.rflag = rflag;
	}
}
