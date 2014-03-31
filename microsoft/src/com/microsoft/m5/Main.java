package com.microsoft.m5;
/**
 * ��Ŀ������n�����������������С��k����
 * ��������1��2��3��4��5��6��7��8��8�����֣�����С��4������Ϊ1��2��3��4��
 * http://zhedahht.blog.163.com/blog/static/2541117420072432136859/
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		int[] sr={1,2,8,7,5,6,9,10};
		//��ʼ��ǰ�ĸ���С��
		InitHeap(sr,4);
		for(int i=4;i<sr.length;i++){
			//���i��������С�ѵ���Сһ��ֵС�������滻��Ȼ�����½�����С��
			if(sr[i]<sr[0]){
				int temp = sr[i];
				sr[i]=sr[0];
				sr[0]=temp;
				InitHeap(sr,4);
			}
		}
		
		for(int j=0;j<4;j++){
			System.out.println(sr[j]);
		}
	}
/**
 * ��ʼ����С��
 * @param sr
 * @param heapLength
 */
	private static void InitHeap(int[] sr, int heapLength) {
		// TODO Auto-generated method stub
		int index= heapLength/2;
		for(int i=index;i>=0;i--){
			if(2*i+1<heapLength){
				if(sr[i]<sr[2*i+1]){
					int temp=sr[i];
					sr[i]=sr[2*i+1];
					sr[2*i+1]=temp;
				}
			}
			if(2*i+2<heapLength){
				if(sr[i]<sr[2*i+2]){
					int temp=sr[i];
					sr[i]=sr[2*i+2];
					sr[2*i+2]=temp;
				}
			}
		}
		
	}
}
