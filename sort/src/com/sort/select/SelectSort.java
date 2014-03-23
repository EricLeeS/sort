package com.sort.select;


/**
 * 
 * @author huanli2
 *from max to min
 */
public class SelectSort {
	public static void main(String[] args){
		int[] sr = {9,7,3,1,8,2,0,5,4,6}; 
		int temp=0;
		for(int i=0;i<sr.length;i++){
			int max= FindMax(sr,i);
			if(max!=i){
				temp = sr[i];
				sr[i]=sr[max];
				sr[max]=temp;
			}
			System.out.println("the list is "+sr[i]);
		}
		
		
	}
	/**
	 * find the max in the rest int[]
	 * @param init
	 * @param start
	 * @return the index of the max
	 */
	private static int FindMax(int[] init,int start){
		int temp=start;
		for(int j=start;j<init.length;j++){
			if(init[j]>init[temp]){
				temp=j;
			}
		}
		return temp;
	}
}
;