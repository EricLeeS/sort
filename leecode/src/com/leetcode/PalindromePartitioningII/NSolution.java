package com.leetcode.PalindromePartitioningII;

public class NSolution {
    public int minCut(String s) {
    	if(s==null||s.equals(""))
    		return 0;
    	generate(s,0,0);
		return re;
    }
    public int re=Integer.MAX_VALUE;
	private void generate(String s, int depth, int start) {
		// TODO Auto-generated method stub
		depth++;
		if(depth>re)
			return;
		if(start==s.length()){
			depth--;
			if(depth<re)
				re=depth;
			return;
		}
		char init = s.charAt(start);
		for(int i=start;i<s.length();i++){
			if(i==start){
				
				generate(s,depth,i+1);
				
			}else if(s.charAt(i)==init){
				if(isPalindrome(s,start,i)){
					
					generate(s,depth,i+1);
					
				}
			}
		}
	}
	private boolean isPalindrome(String s, int start, int end) {
		// TODO Auto-generated method stub
		int i=start;
		int j=end;
		while(j>=i){
			if(s.charAt(i)!=s.charAt(j)){
				return false;
			}else{
				i++;
				j--;
			}
		}
		return true;
	}
}

