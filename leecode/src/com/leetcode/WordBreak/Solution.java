package com.leetcode.WordBreak;

import java.util.Iterator;
import java.util.Set;

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
		Iterator<String> it = dict.iterator();
		char[] ch = s.toCharArray();
		while(it.hasNext()){
			String temp = it.next();
			char[] word = temp.toCharArray();
			int i=0;
			int j=0;
			int count=0;
			while(i<ch.length&&j<word.length){
				if(ch[i]==word[j]){
					count++;
					i++;
					j++;
				}else{
					i++;
				}
				
			}
			if(count==word.length){
				String str = String.valueOf(ch);
				
				str = str.replaceAll(temp, "");
				ch=str.toCharArray();
			}
		}
		if(ch.length==0){
			return true;
		}else{
			return false;
		}
    	
        
    }
}