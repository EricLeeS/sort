package com.leetcode.ResverseWordInAString;

import java.util.regex.Pattern;

public class Solution {
    public String reverseWords(String s) {
    	StringBuilder sb = new StringBuilder();
    	
    	if(s.equals("")){
			sb.append("");
		}else{
			s=s.replaceAll("\\s+", " ");
			if(s.startsWith(" ")){
				s=s.substring(1);
			}
			String[] ch = s.split(" ");
			int i=0;
			int j=ch.length-1;
			while(j>i){
				String temp = ch[i];
				ch[i]=ch[j];
				ch[j]=temp;
				i++;
				j--;
			}			
			for(int m=0;m<ch.length;m++){
				sb.append(ch[m]);
				if(m!=ch.length-1){
					sb.append(" ");
				}
				
			}
		}
    	
    	return sb.toString();
        
    }
}