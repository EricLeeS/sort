package com.leetcode.InsertInterval;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(6,8);
		Interval i3 = new Interval(9,10);
//		Interval i4 = new Interval(8,10);
//		Interval i5 = new Interval(12,16);
		Interval i = new Interval(7,8);
		ArrayList<Interval> in = new ArrayList<Interval>();
		in.add(i1);
		in.add(i2);
		in.add(i3);
//		in.add(i4);
//		in.add(i5);
		ArrayList<Interval> a = so.insert(in, i);
		Iterator<Interval> it = a.iterator();
		while(it.hasNext()){
			Interval temp = it.next();
			System.out.println("[ "+temp.start+" "+temp.end+" ]");
		}
	}
}
