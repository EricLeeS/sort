package com.leetcode.WordBreak;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NNSolution {
	 public boolean wordBreak(String s, Set<String> dict) {
		 Iterator<String> it = dict.iterator();
		 int num=0;
		 Map<String,String> tempmap;
		 Map<String,String> map = new HashMap<String,String>();
		 map.put(num+"", s);
		 num++;
		 int loop=0;
		 char[] ch = s.toCharArray();
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
			 
			 
			 while(it.hasNext()){	
				 System.out.println(map.size());
					String temp = it.next();
					char[] word = temp.toCharArray();
					char[] nnch = ch;
					if(word.length>nnch.length){
						continue;
					}
					int i=0;
					int j=0;
					int count=0;
					while(i<nnch.length&&j<word.length){
						if(nnch[i]==word[j]){
							count++;
							i++;
							j++;
						}else{
							i++;
							j=0;
							count=0;
						}
						
					}
					if(count==word.length){
						tempmap = new HashMap<String,String>();
						if(!map.isEmpty()){
							
							Collection<String> collection = map.values();
							//collection.add(s);
							Iterator<String> cit = collection.iterator();
							
							while(cit.hasNext()){
								String ntemp = cit.next();
								if(count<ntemp.length()){
									while(ntemp.length()>=temp.length()){
										char[] cch = ntemp.toCharArray();
										int ii=0;
										int jj=0;
										int cc =0;
										while(jj<count&&ii<cch.length){
											if(cch[ii]==word[jj]){
												cc++;
												ii++;
												jj++;
											}else{
												ii++;
												j=0;
												cc=0;
											}
										}
										
										if(cc==count){
										
											ntemp=ntemp.replaceFirst(temp, "");
											if(ntemp.equalsIgnoreCase("")){
												return true;
											}
											String str = String.valueOf(ch);
											str = str.replaceFirst(ntemp, "");
											if(!map.containsValue(ntemp)){
												tempmap.put(num+"", ntemp);
												num++;
											}
											
										}else{
											break;
										}
									}	
								}else if(count==ntemp.length()){
									if(temp.equalsIgnoreCase(ntemp)){
										return true;
									}else{
										String str = String.valueOf(ch);
										str = str.replaceAll(temp, "");
										if(!map.containsValue(ntemp)){
											tempmap.put(num+"", ntemp);
											num++;
										}
									}
								}else{
									String str = String.valueOf(ch);
									str = str.replaceAll(temp, "");
									if(!map.containsValue(ntemp)){
										tempmap.put(num+"", ntemp);
										num++;
									}
								}
							}
							map.putAll(tempmap);
						}
					}
				 }
				 return false;
				
		 }
		  
	 }
}