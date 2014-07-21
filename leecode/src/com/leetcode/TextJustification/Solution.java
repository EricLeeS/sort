package com.leetcode.TextJustification;

import java.util.ArrayList;

public class Solution {
    public ArrayList<String> fullJustify(String[] words, int L) {
    	ArrayList<String> re = new ArrayList<String>();
    	
    	if(words.length==0||words==null||L==0){
    		re.add("");
    		return re;
    	}
    		
    	ArrayList<String> temp = new ArrayList<String>();
    	int len=0;
    	int count=0;
    	for(int i=0;i<words.length;i++){
    		String word = words[i];
    		if(len+word.length()>L){
    			int left=0;
    			int even=0;
    			String te="";
    			if(count==1){
    				te+=temp.get(0);
    				te+=" ";
    				while(te.length()<L)
    	    			te+=" ";
    			}else{
    				even = (L+count-len)/(count-1);
        			left = (L+count-len)%(count-1);
        			String em = "";
        			
        			for(int x=0;x<even;x++)
        				em+=" ";
        			for(int j=0;j<temp.size();j++){
        				te+=temp.get(j);
        				if(j<left)
        					te+=" ";
        				if(j!=temp.size()-1)
        					te+=em;
        			}
    			}
    			
    			
    			if(!te.equals(""))
    				re.add(te);
    			if(word.length()==L){
    				re.add(word);
        			temp=new ArrayList<String>();        			
        			count=0;
        			len=0;
    			}else{
    				
        			temp=new ArrayList<String>();
        			temp.add(word);
        			count=1;
        			len=word.length()+1;
    			}
    				
    		}else if(len+word.length()==L){
    			String te = "";
    			for(int j=0;j<temp.size();j++){
    				te+=temp.get(j);
    					te+=" ";
    			}
    			te+=word;
    			if(!te.equals(""))
    				re.add(te);
    			
    			temp=new ArrayList<String>();
    			count=0;
    			len=0;
    		}else{
    			count++;
    			len+=(word.length()+1);
    			temp.add(word);
    		}
    	}
    	if(!temp.isEmpty()){
    		String te="";
    		for(int j=0;j<temp.size();j++){
				te+=temp.get(j);
				if(j!=temp.size()-1)
					te+=" ";
			}
    		while(te.length()<L)
    			te+=" ";
    		re.add(te);
    	}
		return re;
        
    }
}