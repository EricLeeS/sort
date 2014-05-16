package com.leetcode.InterleavingString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NSolution {
    public boolean isInterleave(String s1, String s2, String s3) {
    	int l1 = s1.length();
    	int l2 = s2.length();
    	int l3 = s3.length();
    	if((l1+l2)!=l3)
    		return false;
    	if(l1==0){
    		if(s2.equalsIgnoreCase(s3))
    			return true;
    		else
    			return false;
    	}
    	if(l2==0){
    		if(s1.equalsIgnoreCase(s3))
    			return true;
    		else
    			return false;
    	}
    	int i=0;
    	int j=0;
    	int k=0;
    	int[] flag = new int[s3.length()];
    	Arrays.fill(flag, 0);
    	Map<Integer,int[]> map = new HashMap<Integer,int[]>();
    	while(i<s1.length()&&j<s2.length()&&k<s3.length()){
    		if(flag[k]==0){
    			
    			if(s3.charAt(k)==s1.charAt(i)&&s3.charAt(k)==s2.charAt(j)){
        			if(flag[k]==0){
        				flag[k]=1;
        			}
        			
        		}
    			
    			if((s3.charAt(k)==s1.charAt(i))){
    				int[] temp = {i,j};
    				map.put(k, temp);
        			i++;
        			k++;
        		}else if(j!=s2.length()&&s3.charAt(k)==s2.charAt(j)){
        			int[] temp = {i,j};
        			map.put(k, temp);
        			j++;
        			k++;
        		}else{
        			int tt = -1;
        			for(int m=flag.length-1;m>=0;m--){
        				if(flag[m]==1){
        					tt=m;
        					flag[m]=2;
        				}
        					
        			}
        			if(tt==-1)
        				return false;
        			k=tt;
        			i=map.get(tt)[0];
        			j=map.get(tt)[1];
        		}
    		}else if(flag[k]==1||flag[k]==2){
    			
    			if(s3.charAt(k)==s1.charAt(i)&&s3.charAt(k)==s2.charAt(j)){
        			if(flag[k]==0){
        				flag[k]=1;
        			}
        			
        		}
    			
    			if(s3.charAt(k)==s2.charAt(j)){
    				int[] temp = {i,j};
        			map.put(k, temp);
        			j++;
        			k++;
        		}else if((i!=s1.length())&&(s3.charAt(k)==s1.charAt(i))){
        			int[] temp = {i,j};
        			map.put(k, temp);
        			i++;
        			k++;
        		}
    			
    		}
    		
    		
    	}
    	if(i==s1.length()&&j!=s2.length()){
    		while(j<s2.length()&&k<s3.length()&&s2.charAt(j)==s3.charAt(k)){
    			j++;
    			k++;
    		}
    		
    		if(j==s2.length()&&k==s3.length())
    			return true;
    		else
    			return false;
    	}
    	if(j==s2.length()&&i!=s1.length()){
    		while(i<s1.length()&&k<s3.length()&&s1.charAt(1)==s3.charAt(k)){
    			i++;
    			k++;
    		}
    		
    		if(i==s1.length()&&k==s3.length())
    			return true;
    		else
    			return false;
    	}
		return true;
        
    }
}
