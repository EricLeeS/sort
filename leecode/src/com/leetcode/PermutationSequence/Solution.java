package com.leetcode.PermutationSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getPermutation(int n, int k) {
    	StringBuilder sb=new StringBuilder();
		Func(n);
		map.put(0, 1);
		if(k>map.get(n)){
			return null;
		}else{
			k--;
			int[] re = new int[n];
			for(int j=0;j<n;j++){				
				re[j]=j+1;
			}
			int num=0;
			int[] ret=new int[n];
			
			for(int i=0;i<n;i++){
				int temp = map.get(n-i-1);
				int selected = k/temp;
				ret[num]=re[selected];
				num++;
				for(int j=selected;j<n-i-1;j++){
					re[j]=re[j+1];
				}
				k=k%temp;
			}

			
			for(int nn=0;nn<num;nn++){
				sb.append(ret[nn]+" ");
			}
				
		}
		
        return sb.toString();
    }
    public Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	private int Func(int n) {
		// TODO Auto-generated method stub
		if(n==0){
			map.put(0, 0);
			return 0;
		}else if(n==1){
			map.put(1, 1);
			return 1;
		}else{
			int temp = n*Func(n-1);
			map.put(n, temp);
			return temp;
		}
	}
}
