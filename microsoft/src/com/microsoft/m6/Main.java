package com.microsoft.m6;
/**
 * http://zhedahht.blog.163.com/blog/static/25411174200725319627/
 * ��Ŀ������һ���������飬�жϸ������ǲ���ĳ��Ԫ�������ĺ�������Ľ��������Ƿ���true�����򷵻�false��
��������5��7��6��9��11��10��8��������һ�����������������ĺ�����������

         8
       /  \
      6    10
    / \    / \
   5   7   9  11

��˷���true��

�������7��4��6��5��û���Ŀ����ĺ�������Ľ����������У���˷���false��
 * @author huanli2
 *
 */
public class Main {
	@SuppressWarnings("unused")
	public static void main(String[] args){
		//int[] sr={5,7,6,9,11,10,8};
		int[] sr={7,4,6,5};
		Boolean bol = verifySquenceOfBST(sr,0,sr.length-1);
		System.out.println(bol);
	}
/**
 * ����˼·�� ��Ȼ�Ǻ������������һ���Ǹ��ڵ㣬�Ǹ��ڵ�ǰ��ȸ��ڵ�С��
 * ����ıȸ��ڵ�С���Դ�ΰ�ٽ�㣬
 * �ٽ����治�����ٳ��ֱȸ��ڵ�С�ĵ��ˣ���������������������
 * @param sr
 * @param start
 * @param end
 * @return
 */
	private static Boolean verifySquenceOfBST(int[] sr,int start,int end) {
		// TODO Auto-generated method stub
		Boolean bol=true;
		if(end>=start){
			int root = sr[end];
			int i=0;
			for(i=start;i<end-1;i++){
				if(sr[i]>root){
					bol=verifySquenceOfBST(sr,start,i-1);
					bol=verifySquenceOfBST(sr,i,end-1);
				}
			}
			
			for(int j=i;j<end;j++){
				if(sr[j]<root){
					bol=false;
				}
			}	
		}
		
		return bol;
	}
}
