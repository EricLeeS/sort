package com.cracking.chapter1;

public class Q11 {
	public static void main(String[] args){
		String s = "abcbc";
		System.out.println(isUnique1(s));
	}
	
	static boolean isUnique1(String s){
		boolean[] bol = new boolean[256];
		for(int i=0;i<s.length();i++){
			int index = (int)s.charAt(i);
			if(!bol[index])
				bol[index] = true;
			else
				return false;
		}
		return true;
		
	}
}
