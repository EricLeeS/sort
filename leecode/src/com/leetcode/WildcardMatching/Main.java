package com.leetcode.WildcardMatching;

public class Main {
	public static void main(String[] args){
		String S="aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba";
		String T = "a*******b";
		NSolution so = new NSolution();
		System.out.println(so.isMatch(S, T));
	}
}
