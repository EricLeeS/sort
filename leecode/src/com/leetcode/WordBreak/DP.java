package com.leetcode.WordBreak;


import java.util.Iterator;
import java.util.Set;

public class DP {
	public boolean wordBreak(String s, Set<String> dict) {
		 Iterator<String> it = dict.iterator();
		 if(dict.isEmpty()){
			 return false;
		 }else if(dict.size()==1){
			 String str = it.next();
			 if(s.equalsIgnoreCase(str)){
				 return true;
			 }else{
				return false;
			 }
		 }else{
			 boolean bol=false;
			return IsWordBread(s,dict,bol);
			
		 }
		
	}
	
	private boolean IsWordBread(String s, Set<String> dict,boolean bol) {
		if(!bol){
			if(s.equalsIgnoreCase("")){
				bol=true;
				System.out.println(bol);
				return bol;
			}else{
				for(int i=0;i<s.length();i++){
					String temp1=s.substring(0, i+1);
					if(dict.contains(temp1)){
						String temp2=s.substring(i+1, s.length());
						IsWordBread(temp2,dict,bol);
					}
				}
				return bol;
			}
		}
		return bol;
		
		
		
		
		
		
		
	}

	public boolean  FindExist(String init,Set<String> dict){
		Iterator<String> it = dict.iterator();
		while(it.hasNext()){
			String temp = it.next();
			if(temp.equalsIgnoreCase(init)){
				return true;
			}
		}
		return false;
	}
}
	
