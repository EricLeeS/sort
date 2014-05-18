package com.leetcode.Triangle;

import java.util.ArrayList;

public class Main {
	public static void main(String[] args){
		ArrayList<ArrayList<Integer>> in = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(-1);
		in.add(al);
		al = new ArrayList<Integer>();
		al.add(-3);
		al.add(-4);
		in.add(al);
//		al = new ArrayList<Integer>();
//		al.add(6);
//		al.add(5);
//		al.add(7);
//		in.add(al);
//		al = new ArrayList<Integer>();
//		al.add(4);
//		al.add(1);
//		al.add(8);
//		al.add(3);
//		in.add(al);
		Solution so = new Solution();
		System.out.println(so.minimumTotal(in));
		
	}
}
