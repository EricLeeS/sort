package com.offer.m6;

public class Main {
	public static void main(String[] args){
		int[] preOrder={1,2,4,7,3,5,6,8};
		int[] inOrder={4,7,2,1,5,3,8,6};
		int init = preOrder[0];
		int inStart = 0;
		int inEnd = inOrder.length-1;
		int index = Find(init,inOrder,inStart,inEnd);
		int length = index-inStart;
		BSTreeNode root = new BSTreeNode(init);
		
		ConstructTree(preOrder,1,length,inOrder,0,index-1,root,"left");
		ConstructTree(preOrder,(1+length),inEnd,inOrder,index+1,inEnd,root,"right");
		InOrder(root);
	}

	private static void InOrder(BSTreeNode root) {
		// TODO Auto-generated method stub
		if(root!=null){
			InOrder(root.getLeft());
			System.out.println(root.getInfo());
			
			InOrder(root.getRight());
		}
	}

	private static int Find(int init, int[] inOrder, int inStart, int inEnd) {
		// TODO Auto-generated method stub
		int index =0;
		for(int i=inStart;i<=inEnd;i++){
			if(inOrder[i]==init){
				index=i;
			}
		}
		return index;
	}
	
	private static void ConstructTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,BSTreeNode root,String direction){
		if((preStart>preEnd)||(inStart>inEnd)||(preStart<0)||(preEnd<0)||(inStart<0)||(inEnd<0)){
			return;
		}else{
			int init = preOrder[preStart];
			int index = Find(init,inOrder,inStart,inEnd);
			BSTreeNode node = new BSTreeNode(init);
			if(direction.equalsIgnoreCase("left")){
				root.setLeft(node);
			}else{
				root.setRight(node);
			}
			int length = index-inStart;
			preStart++;
			ConstructTree(preOrder,preStart,preStart+length-1,inOrder,inStart,index-1,node,"left");
			ConstructTree(preOrder,preStart+length,preEnd,inOrder,index+1,inEnd,node,"right");
		}
	}
}
