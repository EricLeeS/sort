package com.leetcode.GenerateParentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public List<String> generateParenthesis(int n) {
    	List<String> re = new ArrayList<String>();
    	if(n==0)
    		return re;
    	List<Character> lc = new ArrayList<Character>();
    	for(int i=0;i<n;i++)
    		lc.add(i, '(');
    	generate(lc,1,n);
    	re.addAll(set);
		return re;
        
    }
    public Set<String> set = new HashSet<String>();
    private void generate(List<Character> lc, int start, int n) {
    	if(start==lc.size()+1)
    		return;
    	if(lc.size()==2*n){
    		String str = "";
			for(int nn=0;nn<lc.size();nn++)
				str+=lc.get(nn);
			set.add(str);
			return;
		}
		int count=0;
		for(int i=0;i<start;i++){
			if(lc.get(i)=='(')
				count++;
			else
				count--;
		}
		int len=start;
		if(count!=n){
			len = start+1;
			generate(lc,len,n);
		}
		
		
		for(int j=0;j<count;j++){			
			lc.add(start, ')');
			generate(lc,len++,n);
		}
		for(int jj=0;jj<count;jj++){
			lc.remove(start);
		}
		return;
	}   
}
