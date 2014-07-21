package com.leetcode.LongestPalindromicSubstring;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String longestPalindrome(String s) {
    	if(s.equals("")||s==null)
    		return "";
    	int min=1;
    	int start=0;
    	int end=0;
    	boolean[][] bol = new boolean[s.length()][s.length()];
    	bol[0][0]=true;
    	Map<Character,List<Integer>> map = new HashMap<Character,List<Integer>>();
    	for(int i=0;i<s.length();i++){
    		char ch = s.charAt(i);
    		bol[i][i]=true;
    		if(!map.containsKey(ch)){
    			List<Integer> li = new ArrayList<Integer>();
    			li.add(i);
    			map.put(ch, li);
    		}else{
    			List<Integer> li = map.get(ch);
    			for(int j=0;j<li.size();j++){
    				int temp=li.get(j);
    				if(i-temp==1){
    					bol[temp][i]=true;
    						if(i-temp+1>min){   						
    						min=i-temp+1;
        					start=temp;
        					end=i;
    					}
    				}
    					
//    				if(temp==0&&isPalindrome(s,0,i)){
//    					bol[temp][i]=true;
//    					start=temp;
//    					end=i;
//    					min=i-temp+1;
//    					continue;
//    				}
    				
    				if(bol[temp+1][i-1]){
    					bol[temp][i]=true;
    					if(i-temp+1>min){
    						
    						min=i-temp+1;
        					start=temp;
        					end=i;
    					}
    					
    				}
    			}
    			map.get(ch).add(i);
    		}
    	}
    	
		return s.substring(start, end+1);
        
    }
    public int count=0;
	private boolean isPalindrome(String s, int temp, int i) {
		// TODO Auto-generated method stub
		//System.out.println(count++);
		while(i>temp){
			if(s.charAt(i)!=s.charAt(temp))
				return false;
			i--;
			temp++;
		}
		return true;
	}
}
