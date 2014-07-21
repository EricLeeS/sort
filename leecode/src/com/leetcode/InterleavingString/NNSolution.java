package com.leetcode.InterleavingString;

public class NNSolution {
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
    	
		return isValid(s1,0,s2,0,s3,0);
    	
    }

	private boolean isValid(String s1, int s1start, String s2, int s2start, String s3,int len) {
		if(s1start==s1.length()){
			if(s2.length()==s2start)
				return false;
			if(s2.length()-s2start!=s3.length()-len)
				return false;
			for(int i=s2start;i<s2.length();i++){
				if(s2.charAt(s2start)==s3.charAt(len))
					len++;
				else
					return false;
			}
			return true;
		}
		if(s2start==s2.length()){
			if(s1.length()==s1start)
				return false;
			if(s1.length()-s1start!=s3.length()-len)
				return false;
			for(int i=s1start;i<s1.length();i++){
				if(s1.charAt(s1start)==s3.charAt(len))
					len++;
				else
					return false;
			}
			return true;
		}
		boolean bol = false;
		if(s1.charAt(s1start)==s3.charAt(len)||s2.charAt(s2start)==s3.charAt(len)){
			if(s1.charAt(s1start)==s2.charAt(s2start)){
				bol=bol||isValid(s1,s1start+1,s2,s2start,s3,len+1)||isValid(s1,s1start,s2,s2start+1,s3,len+1);
			}else if(s1.charAt(s1start)==s3.charAt(len)){
				bol=isValid(s1,s1start+1,s2,s2start,s3,len+1);
				
			}else{
				bol=isValid(s1,s1start,s2,s2start+1,s3,len+1);
			}
		}else{
			bol=false;
		}
		return bol;
		
		
		
		
	}
 }
