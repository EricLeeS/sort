package com.leetcode.SearchInRotatedSortedArray;
/**
 * ��1�����target==A[m]����ôm��������Ҫ�Ľ����ֱ�ӷ��أ�
��2�����A[m]<A[r]����ô˵����m��rһ��������ģ�û���ܵ�rotate��Ӱ�죩����ô����ֻ��Ҫ�ж�target�ǲ�����m��r֮�䣬�����������Ե�Ƶ�m+1�������target����һ�룬�����ұ�Ե�Ƶ�m-1��
��3�����A[m]>=A[r]����ô˵����l��mһ��������ģ�ͬ��ֻ��Ҫ�ж�target�Ƿ��������Χ�ڣ���Ӧ���ƶ���Ե���ɡ�
 * @author huanli2
 *
 */
public class NSolution {
    public int search(int[] A, int target) {
    	int start = 0;
    	int end = A.length-1;
    	while(end>=start){
    		int mid = (end+start)/2;
    		if(A[mid]==target)
    			return mid;
    		
    		if(A[mid]<A[end]){
    			if(A[mid]<target&&A[end]>=target)
    				start=mid+1;
    			else
    				end=mid-1;
    		}else{
    			if(A[mid]>target&&A[start]<=target)
    				end=mid-1;
    			else
    				start=mid+1;
    		}
    	}
		return -1;
   
    }
}

