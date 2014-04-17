package com.leetcode.WordBreak;

public class Test {
	public static void main(String[] args){
//		String in="fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
//		String out = "gfkngeebnggo";
//		char[] ch1=in.toCharArray();
//		char[] ch2 = out.toCharArray();
//		int i=0;
//		int j=0;
//		int count =0;
//		
//		while(i<ch1.length&&j<ch2.length){
//			if(ch1[i]==ch2[j]){
//				count++;
//				i++;
//				j++;
//			}else{
//				count=0;
//				j=0;
//				i++;
//			}
//		}
//		System.out.println(count);
		String str = "loveyou";
		
		for(int i=0;i<str.length();i++){
			System.out.println(str.substring(0, i+1));
		System.out.println(str.substring(i+1, str.length()));
		}
	}
}
