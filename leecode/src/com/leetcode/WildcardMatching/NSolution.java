package com.leetcode.WildcardMatching;

public class NSolution {
    public boolean isMatch(String s, String p) {
    	if(p.equals("")&&!s.equals(""))
    		return false;
    	if(s.equals("")&&p.equals(""))
    		return true;
    	if(s.equals("")){
    		int i=0;
    		while(i<p.length()){
    			if(p.charAt(i)!='*')
    				return false;
    			i++;
    		}
    		return true;
    	}
    	if((s.charAt(0)==p.charAt(0)||p.charAt(0)=='*'||p.charAt(0)=='?')&&
    			(s.charAt(s.length()-1)==p.charAt(p.length()-1)||p.charAt(p.length()-1)=='*'||p.charAt(p.length()-1)=='?'))
    		return isMatch(s,0,p,0);
    	else 
    		return false;
    		
    		
    	
		
        
    }

	private boolean isMatch(String s, int i, String p, int j) {
		boolean bol = false;
		if(i==s.length()&&j==p.length())
			bol=true;
		else if(i==s.length()&&j!=p.length()){
			while(j<p.length()){
				if(p.charAt(j)!='*')
					return false;
				j++;
			}
			return true;
		}else if(i>=s.length()||j>=p.length()){
			return false;
		}else{
			char si = s.charAt(i);
			char pj = p.charAt(j);
			if(si==pj){
				bol=isMatch(s,i+1,p,j+1);
			}else if(pj=='?'){
				bol=isMatch(s,i+1,p,j+1);
			}else if(pj=='*'){
				if(j-1>=0&&p.charAt(j-1)=='*')
					bol=isMatch(s,i,p,j+1);
				else{
					while(i<=s.length()){
						bol=bol||isMatch(s,i,p,j+1);
						i++;
					}
				}
				
					
			}else{
				bol=bol||false;
			}
		}
		return bol;
	}
}
