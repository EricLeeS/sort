package com.leetcode.InsertInterval;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals,
			Interval newInterval) {
		if (intervals.isEmpty()) {
			intervals.add(newInterval);
			return intervals;
		}

		Interval pre = newInterval;
		for(int i=0;i<intervals.size();i++){
			int start = pre.start;
			int end = pre.end;
			Interval temp = intervals.get(i);
			
			if (temp.start > end) {
				intervals.add(i, pre);
				return intervals;
			} else if (temp.start == end) {
				temp.start = start;
				return intervals;
			} else {
				if (start <= temp.start && end <= temp.end) {
					temp.start = start;
					return intervals;
				} else if (start <= temp.start && end > temp.end) {
					intervals.remove(temp);
					i--;
					continue;
				} else if (start > temp.start && end < temp.end) {
					return intervals;
				} else if (start > temp.start &&start<temp.end&& end >=temp.end) {
					pre.start = temp.start;
					pre.end = end;
					intervals.remove(temp);
					i--;
					continue;
				} else if (start > temp.end) {
					pre.start = start;
					pre.end = end;
					continue;
				} else if (start == temp.end) {
					pre.start = temp.start;
					pre.end = end;
					intervals.remove(temp);
					i--;
					continue;
				}
			}
		}
		intervals.add(pre);
		return intervals;

	}
}
