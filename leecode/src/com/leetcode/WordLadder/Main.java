package com.leetcode.WordLadder;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args){
		NSolution so = new NSolution();
		String start = "hit";
		String end = "cog";
		HashSet<String> set = new HashSet<String>();
		set.add("hot");
		set.add("dot");
		set.add("dog");
		set.add("lot");
		set.add("log");
		
		System.out.println(so.ladderLength(start, end, set));
	}
}
