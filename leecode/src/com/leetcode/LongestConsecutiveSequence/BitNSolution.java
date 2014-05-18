package com.leetcode.LongestConsecutiveSequence;

import java.util.BitSet;



public class BitNSolution {
	public int longestConsecutive(int[] num) {
		if(num.length==0)
			return 0;
		if(num.length==1)
			return 1;
		int max=num[0];
		int min=num[0];
		
		for(int i=1;i<num.length;i++){
			if(num[i]>=max)
				max=num[i];
			if(num[i]<min)
				min=num[i];
		}
		if(min<0)
			min=-min;
		if(min==0)
			min=1;
		if(max==0)
			max=1;
		BitSet bs = new BitSet(max);
		BitSet mbs = new BitSet(min);
		for(int i=0;i<num.length;i++){
			if(num[i]<0){
				mbs.set(-num[i],true);
			}else{
				bs.set(num[i], true);
			}
			
		}
		
		int re=0;
		
		int count=0;
		for(int k=mbs.size()-1;k>0;k--){
			if(mbs.get(k)){
				count++;
				if(count>re)
					re=count;
			}else{
				count=0;
			}
		}
		for(int j=0;j<bs.size();j++){
			if(bs.get(j)){
				count++;
				if(count>re)
					re=count;
			}else{
				count=0;
			}
				
		}
		return re;
 
    }	
}
