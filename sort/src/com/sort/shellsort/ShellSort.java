package com.sort.shellsort;

public class ShellSort {
	public static void main(String[] args){
		int[] sr = {194,638,124,482,469,245,852,294,484,243,623};
		for(int i=sr.length/2;i>0;i/=2){
			ShellSortT(sr,i);
		}
		
		for(int i=0;i<sr.length;i++){
			System.out.println(sr[i]);
		}
	}

	private static void ShellSortT(int[] sr, int gap) {
		// TODO Auto-generated method stub
		for(int i=gap;i<sr.length;i+=gap){
			int temp=sr[i];
			for(int j=i-gap;j>=0;j-=gap){
				if(sr[j]>temp){
					sr[j+gap]=sr[j];
					if(j==0){
						sr[j]=temp;
						break;
					}
				}else{
					sr[j+gap]=temp;
					break;
				}
				
				
			}
		}
	}
}
