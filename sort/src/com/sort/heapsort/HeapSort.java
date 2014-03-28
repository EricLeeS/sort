package com.sort.heapsort;

public class HeapSort {
	public static void main(String[] args){
		int[] sr = {194,638,124,482,469,245,852,294,484,243,623,243};
		InitHeap(sr,sr.length);
		
		for(int i=0;i<sr.length;i++){
			int temp=sr[sr.length-i-1];
			sr[sr.length-i-1]=sr[0];
			sr[0]=temp;
			InitHeap(sr,sr.length-1-i);
		}
		
		
		for(int i=sr.length-1;i>0;i--){
			System.out.println(sr[i]);
		}
	}

	private static void InitHeap(int[] sr,int heapLength) {
		// TODO Auto-generated method stub
		int index=heapLength/2;
		for(int i=index;i>=0;i--){
			if(2*i+1<heapLength){
				if(sr[i]>sr[2*i+1]){
					int temp=sr[i];
					sr[i]=sr[2*i+1];
					sr[2*i+1]=temp;
				}
			}
			if(2*i+2<heapLength){
				if(sr[i]>sr[2*i+2]){
					int temp=sr[i];
					sr[i]=sr[2*i+2];
					sr[2*i+2]=temp;
				}
			}
		}
	}
	
	
}
