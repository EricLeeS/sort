package com.microsoft.m11;
/**
 * ��Ŀ������һ�Ŷ�Ԫ��������������ת��Ϊ���ľ��񣬼���ת����Ķ�Ԫ�������У��������Ľ�㶼�����������Ľ�㡣�õݹ��ѭ�����ַ���������ľ���ת����
�������룺

     8
    /  \
  6      10
 /\       /\
5  7    9   11

�����

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
