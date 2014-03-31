package com.microsoft.m1;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * ��Ŀ������һ�ö�Ԫ�����������ö�Ԫ������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ����ָ���ָ��

�������罫��Ԫ������
                                            10
                                          /    \
                                        6       14
                                      /  \     /�� \
                                   ��						4     8  12 ��  16
ת����˫������

4=6=8=10=12=14=16��

����������������΢��������⡣�ܶ�������ص���Ŀ�����õݹ��˼·�����������Ҳ�����⡣�������������ֲ�ͬ�ĵݹ�˼·��������

����˼·һ�������ǵ���ĳһ���׼�������Ըý��Ϊ����������ʱ���ȵ�������������������ת����һ���ź�������������ٵ�����������ת�����������������������������ҽ�㣨������������㣩��
��ǰ������������������㣨����������С��㣩�������ĸ���㿪ʼ�ݹ�������н�㡣

����˼·�������ǿ���������������������������ʽ���������Ƚ�С�Ľ���ȷ��ʡ��������ÿ����һ����㣬����֮ǰ���ʹ��Ľ���Ѿ�������һ������˫������
�����ٰѵ�����ǰ����ָ�뽫�����ӵ������ĩβ�������н�㶼���ʹ�֮��������Ҳ��ת����һ������˫�������ˡ�
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
	 * �������
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
	 * ���ɶ��������
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
			System.out.println("�����ظ��Ľڵ�");
		}
	}
	
	
}
