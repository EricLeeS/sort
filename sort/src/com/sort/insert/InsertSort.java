package com.sort.insert;
/**
 * 
 * @author huanli2
 *quick sort from big to small
 *example: 5 4 3 2 1
 */
public class InsertSort {
	public static void main(String[] args){
		int[] sr = {194,638,124,482,469,245,852,294,484,243,623};
		for(int i=1;i<sr.length;i++){
			int index = FindIndex(sr,i);
			int temp=sr[i];
			//move
			for(int j=i;j>index+1;j--){
				sr[j]=sr[j-1];
			}
			sr[index+1]=temp;
		}
		
		for(int m=0;m<sr.length;m++){
			System.out.println(sr[m]);
		}
	}

	/**
	 * find the index before the right position 
	 * @param sr
	 * @param cur
	 * @return such as 1 3 4 5 2 find the position of 2  the return index is 0
	 */
	private static int FindIndex(int[] sr, int cur) {
		int temp = sr[cur];
		int index=-1;
		for(int i=cur-1;i>=0;i--){
			if(sr[i]<temp){
				index=i;
				break;
			}
		}
		return index;
	}
}
