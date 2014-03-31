package com.microsoft.m4;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.microsoft.m1.BSTreeNode;

/**
 * ��Ŀ������һ��������һ�ö�Ԫ���������ĸ���㿪ʼ���·���һֱ��Ҷ��������������н���γ�һ��·����
 * ��ӡ����������������ȵ�����·����
 * ������������22�����¶�Ԫ��

            10
          /   \
         5     12
       /   \   
      4     7 
      ���ӡ������·����10, 12��10, 5, 7
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		BSTreeNode root = new BSTreeNode(10);
		AddBSTreeNode(root,5);
		AddBSTreeNode(root,12);
		AddBSTreeNode(root,4);
		AddBSTreeNode(root,7);
		//InOrder(root);
		List<Integer> path= new LinkedList<Integer>();
		FindPath(root,path);
	}
	private static void FindPath(BSTreeNode root,List<Integer> path ) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<path.size();i++){
			sum+=path.get(i);
		}
		if(sum<22&&root!=null){
			path.add(root.getValue());
			int sum1=0;
			for(int i=0;i<path.size();i++){
				sum1+=path.get(i);
			}
			if(sum1==22){
				System.out.println(path.toString());
			}
			FindPath(root.getLeft(),path);
			FindPath(root.getRight(),path);
			path.remove(path.size()-1);

		}else if(sum==22){
			//System.out.println(path.toString());
			//path.remove(path.size()-1);
		}
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
