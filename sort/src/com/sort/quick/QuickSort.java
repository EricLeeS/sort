package com.sort.quick;

public class QuickSort {
	public static void main(String[] args){
		//int[] sr = {194,638,124,482,469,245,852,294,484,243,623};
		//int[] sr={638,482,469,245,852,294,484,243,623};
		int[] sr={243,482,469,245,623,294,484};
		QuickSortT(sr,0,sr.length-1);
		for(int i=0;i<sr.length;i++){
			System.out.println(sr[i]);
		}
	}
//交换的重点是 high必须指向比第一个数值小的节点，或者其本身
	private static void QuickSortT(int[] data, int low, int high) {
		// TODO Auto-generated method stub
		if(low>=high){
			return;
		}
		int oldlow = low;
		int oldhigh = high;
		int temp =data[low];
		low++;
		while(low<=high){
			if(data[low]<temp){
				low++;
				continue;
			}
			if(data[high]>temp){
				high--;
				continue;
			}
			if(high>low){
				Swap(data,low,high);
				low++;
				high--;
			}
			
			
		}

		Swap(data,high,oldlow);

		QuickSortT(data,oldlow,high-1);
		QuickSortT(data,high+1,oldhigh);
		
//		if (low >= high) return;
//		             int temp = data[low];
//		             int i = low + 1, j = high;
//		             while (true)
//		            {
//		                 while (data[j] > temp) j--;
//		                 while (data[i] < temp ) i++;
//		                 if (i >= j) break;
//		                 Swap(data, i, j);
//		                 i++; j--;
//		             }
//		             //if (j != low)
//		                 Swap(data, low, j);
//		             QuickSortT(data, j + 1, high);
//		             QuickSortT(data, low, j - 1);
	}

	private static void Swap(int[] sr, int low, int high) {
		// TODO Auto-generated method stub
		int temp = sr[low];
		sr[low]=sr[high];
		sr[high]=temp;
	}
}



//while(low<=high){
//	if(data[low]<temp){
//		low++;
//		continue;
//	}
//	if(data[high]>temp){
//		high--;
//		continue;
//	}
//	if(high>low){
//		Swap(data,low,high);
//		low++;
//		high--;
//	}
//	
//	
//}
//if(high!=low){
//	Swap(data,high,oldlow);
//}
//QuickSortT(data,oldlow,high-1);
//QuickSortT(data,high+1,oldhigh);