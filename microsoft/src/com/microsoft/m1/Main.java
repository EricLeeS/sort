package com.microsoft.m1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * 题目：输入一棵二元查找树，将该二元查找树转换成一个排序的双向链表。要求不能创建任何新的结点，只调整指针的指向。

　　比如将二元查找树
                                            10
                                          /    \
                                        6       14
                                      /  \     /　 \
                                   　						4     8  12 　  16
转换成双向链表

4=6=8=10=12=14=16。

　　分析：本题是微软的面试题。很多与树相关的题目都是用递归的思路来解决，本题也不例外。下面我们用两种不同的递归思路来分析。

　　思路一：当我们到达某一结点准备调整以该结点为根结点的子树时，先调整其左子树将左子树转换成一个排好序的左子链表，再调整其右子树转换右子链表。最近链接左子链表的最右结点（左子树的最大结点）、
当前结点和右子链表的最左结点（右子树的最小结点）。从树的根结点开始递归调整所有结点。

　　思路二：我们可以中序遍历整棵树。按照这个方式遍历树，比较小的结点先访问。如果我们每访问一个结点，假设之前访问过的结点已经调整成一个排序双向链表，
我们再把调整当前结点的指针将其链接到链表的末尾。当所有结点都访问过之后，整棵树也就转换成一个排序双向链表了。
 * @author huanli2
 *
 */
public class Main {
	DoubleLinkedList list = new DoubleLinkedList();
	public static void main(String[] args){
		BSTreeNode root = new BSTreeNode(10);
		AddBSTreeNode(root,6);
		AddBSTreeNode(root,14);
		AddBSTreeNode(root,4);
		AddBSTreeNode(root,8);
		AddBSTreeNode(root,12);
		AddBSTreeNode(root,16);
		//InOrder(root);
		ConvertToDoubleLinckedList(root);
		List<BSTreeNode> list = DoubleLinkedList.getList();
		for(int i=0;i<list.size();i++){
			
			System.out.println(list.get(i).getValue());
		}
		
	}
	private static void ConvertToDoubleLinckedList(BSTreeNode root) {
		
		if(root!=null){
			ConvertToDoubleLinckedList(root.getLeft());
			DoubleLinkedList.addNode(root);
			ConvertToDoubleLinckedList(root.getRight());
		}
		// TODO Auto-generated method stub
		
	}
	/**
	 * 中序遍历
	 * @param root
	 */
	private static void InOrder(BSTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null){
			InOrder(root.getLeft());
			System.out.println(root.getValue());
			InOrder(root.getRight());
		}
	}
	/**
	 * 生成二叉查找树
	 * @param root
	 * @param i
	 */
	private static void AddBSTreeNode(BSTreeNode root, int i) {
		// TODO Auto-generated method stub
		if(root.getValue()>i){
			if(root.getLeft()!=null){
				AddBSTreeNode(root.getLeft(),i);
			}else{
				BSTreeNode node = new BSTreeNode(i);
				root.setLeft(node);
			}
		}else if(root.getValue()<i){
			if(root.getRight()!=null){
				AddBSTreeNode(root.getRight(),i);
			}else{
				BSTreeNode node = new BSTreeNode(i);
				root.setRight(node);
			}
		}else{
			System.out.println("插入重复的节点");
		}
	}
	
	
}
