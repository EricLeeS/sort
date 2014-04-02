package com.microsoft.m11;
/**
 * 题目：输入一颗二元查找树，将该树转换为它的镜像，即在转换后的二元查找树中，左子树的结点都大于右子树的结点。用递归和循环两种方法完成树的镜像转换。
例如输入：

     8
    /  \
  6      10
 /\       /\
5  7    9   11

输出：

      8
    /  \
  10    6
 /\      /\
11  9  7  5
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		BSTreeNode  root = new BSTreeNode (8);
		AddBSTreeNode(root,6);
		AddBSTreeNode(root,10);
		AddBSTreeNode(root,5);
		AddBSTreeNode(root,7);
		AddBSTreeNode(root,9);
		AddBSTreeNode(root,11);
		//InOrder(root);
		ConvertBSTree(root);
		InOrder(root);
		
	}

	private static void ConvertBSTree(BSTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null){
			BSTreeNode temp = new BSTreeNode(0);
			temp = root.getLeft();
			root.setLeft(root.getRight());
			root.setRight(temp);
			ConvertBSTree(root.getLeft());
			ConvertBSTree(root.getRight());
		}
	}

	private static void InOrder(BSTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null){
			System.out.println(root.getN());
			InOrder(root.getLeft());
			InOrder(root.getRight());
		}
	}

	private static void AddBSTreeNode(BSTreeNode root, int i) {
		// TODO Auto-generated method stub
		if(i>root.getN()){
			if(root.getRight()!=null){
				AddBSTreeNode(root.getRight(),i);
			}else{
				BSTreeNode  node = new BSTreeNode (i);
				root.setRight(node);
			}
		}else if(i<root.getN()){
			if(root.getLeft()!=null){
				AddBSTreeNode(root.getLeft(),i);
			}else{
				BSTreeNode node = new BSTreeNode(i);
				root.setLeft(node);
			}
		}
	}
}
