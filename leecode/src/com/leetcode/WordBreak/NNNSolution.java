package com.leetcode.WordBreak;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class NNNSolution {
	 public boolean wordBreak(String s, Set<String> dict) {
		 Iterator<String> it = dict.iterator();
		ArrayList<String> dictn = new ArrayList<String>();
		dictn.addAll(dict);
		 ArrayList<String> array = new ArrayList<String>();
		 array.add(s);
		 LinkedList<String> temparray;
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
			 for(String dictstr : dictn){	
				
				String word = dictstr;
				String init = s;
				if(word.length()>init.length()){
					continue;
				}
				temparray = new LinkedList<String>();
				for(String str : array){
					String temp = str;
					
					String bolReplace = temp.replaceAll(word, "");
					if(!temp.equalsIgnoreCase(bolReplace)){
						if(bolReplace.equalsIgnoreCase("")){
							return true;
						}
						if(!array.contains(bolReplace)){
							temparray.add(bolReplace);
						}
						
					}
				}
				array.addAll(temparray);
			}
		}
				
		 return false;
		 }	  
	 }