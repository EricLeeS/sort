package com.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		Interval i1 = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(1,4);
		ArrayList<Interval> intervals = new ArrayList<Interval>();
		intervals.add(i1);
		intervals.add(i2);
		intervals.add(i3);
		intervals.add(i4);
		intervals = so.merge(intervals);
		Iterator<Interval> it = intervals.iterator();
		while(it.hasNext()){
			Interval temp = it.next();
			System.out.println(temp.start+" "+temp.end);
		}
		
	}
}
