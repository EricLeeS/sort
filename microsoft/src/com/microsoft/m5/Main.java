package com.microsoft.m5;
/**
 * 题目：输入n个整数，输出其中最小的k个。
 * 例如输入1，2，3，4，5，6，7和8这8个数字，则最小的4个数字为1，2，3和4。
 * http://zhedahht.blog.163.com/blog/static/2541117420072432136859/
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		int[] sr={1,2,8,7,5,6,9,10};
		//初始化前四个最小堆
		InitHeap(sr,4);
		for(int i=4;i<sr.length;i++){
			//如果i的至比最小堆的最小一个值小，进行替换，然后重新建立最小堆
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
 * 初始化最小堆
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
