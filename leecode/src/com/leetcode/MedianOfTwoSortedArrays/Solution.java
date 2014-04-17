package com.leetcode.MedianOfTwoSortedArrays;

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
		int alength = A.length;
		int blength = B.length;
		double re = 0;
		if(alength==0&&blength==0){
			return re;
		}else if(alength==0){
			if(blength%2==0){
				double temp1=B[blength/2-1];
				double temp2=B[blength/2];
				re=(temp1+temp2)/2;
			}else{
				re= B[blength/2];
			}
		}else if(blength==0){
			if(alength%2==0){
				double temp1=A[alength/2-1];
				double temp2=A[alength/2];
				re=(temp1+temp2)/2;
			}else{
				re=A[alength/2];
			}
		}else{
			int length = alength+blength;
			int count=0;
			if(length%2==0){
				int index=length/2;
				int i=0;
				int j=0;
				int left=0;
				int right=0;
				int min=0;
				while(i<alength||j<blength){
					
					if(i==alength){
						min=B[j];
						count++;
						j++;
					}else if(j==blength){
						min=A[i];
						count++;
						i++;
					}else{
						if(A[i]>B[j]){
							min=B[j];
							count++;
							j++;
							
						}else if(A[i]==B[j]){
							count++;
							if(count==index){
								left=A[i];
								continue;
							}
							if(count==index+1){
								right=A[i];
								break;
							}
							min=A[i];
							count++;
							i++;
							j++;
							
						}else{
							min=A[i];
							count++;
							i++;
							
						}
					}
					
					
					
					if(count==index){
						left=min;
						continue;
					}
					if(count==index+1){
						right=min;
						break;
					}
				}
				double temp1=left;
				double temp2=right;
				
				re=(temp1+temp2)/2;
			}else{
				int index=length/2+1;
				int i=0;
				int j=0;
				int min=0;
				while(i<alength||j<blength){
					if(i==alength){
						min=B[j];
						count++;
						j++;
					}else if(j==blength){
						min=A[i];
						count++;
						i++;
					}else{
						if(A[i]>B[j]){
							min=B[j];
							count++;
							j++;
							
						}else if(A[i]==B[j]){
							count++;
							if(count==index){
								re=A[i];
								break;
							}
							min=A[i];
							count++;
							i++;
							j++;
							
						}else{
							min=A[i];
							count++;
							i++;
						}
					}
					
					
					
					if(count==index){
						re=min;
						break;
					}
					
				}
			}
		}
    	return re;
        
    }
}
