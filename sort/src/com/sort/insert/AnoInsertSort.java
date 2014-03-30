package com.sort.insert;

public class AnoInsertSort {
	public static void main(String[] args){
		int[] sr = {194,638,124,482,469,245,852,294,484,243,623};
		for(int i=1;i<sr.length;i++){
			int temp=sr[i];
			for(int j=i-1;j>=0;j--){
				
				if(sr[j]>temp){
					sr[j+1]=sr[j];
					if(j==0){
						sr[j]=temp;
						break;
					}
				}else{
					sr[j+1]=temp;
					break;
				}
			}
		}
		
		for(int n=0;n<sr.length;n++){
			System.out.println(sr[n]);
		}
	}
}
