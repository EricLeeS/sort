package com.sort.merge;

public class MergeSort {
	public static void main(String[] args){
		int[] sr = {194,638,124,482,469,245,852,294,484,243,623};
		int[] din=MergeSortT(sr);
		for(int i=0;i<din.length;i++){
			System.out.println(din[i]);
		}
		
	}

	private static int[] MergeSortT(int[] data) {
		// TODO Auto-generated method stub
		if(data.length==1){
			return data;
		}
		
		int midle = data.length/2;
		int[] left = new int[midle];
		int[] right = new int[data.length-midle];
		for(int i=0;i<midle;i++){
			left[i]=data[i];
		}
		int m=0;
		for(int j=midle;j<data.length;j++){
			right[m]=data[j];
			m++;
		}
		int[] one = MergeSortT(right);
		int[] two = MergeSortT(left);
		return MergeSortSub(one,two);
		
	}

	private static int[] MergeSortSub(int[] one, int[] two) {
		int i=0;
		int j=0;
		int m=0;
		int[] re = new int[one.length+two.length];
		while(true){
			if(i==one.length||j==two.length){
				break;
			}
			if(one[i]<two[j]){
				re[m]=one[i];
				i++;
				m++;
			}else{
				re[m]=two[j];
				j++;
				m++;
			}
		}
		if(i<one.length){
			for(int n=i;n<one.length;n++){
				re[m]=one[n];
				m++;
			}
		}else{
			for(int n=j;n<two.length;n++){
				re[m]=two[n];
				m++;
			}
		}
		
		return re;
	}
}
