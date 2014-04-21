package com.leetcode.SortList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    public ListNode sortList(ListNode head) {
    	List<Integer> list = new ArrayList<Integer>();
    	int num=0;
    	ListNode root = head;
    	ListNode re = head;
		while(head!=null){
			//sr[num]=head.val;
			list.add(head.val);
			num++;
			head=head.next;			
		}
		int[] sr =new int[num];
		int t=0;
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()){
			sr[t]=it.next();
			t++;
		}
		InitHeap(sr,num);
		for(int i=0;i<num;i++){
			int temp=sr[num-i-1];			
			sr[num-i-1]=sr[0];
			root.val=sr[0];
			root=root.next;
			sr[0]=temp;
			InitHeap(sr,num-1-i);
		}
		
    	return re;
        
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


