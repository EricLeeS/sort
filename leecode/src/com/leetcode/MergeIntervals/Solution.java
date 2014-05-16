package com.leetcode.MergeIntervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
    	if(intervals.isEmpty())
    		return intervals;
    	Collections.sort(intervals, new IntervalComparator());
    	Interval pre = intervals.get(0);
    	for(int i=1;i<intervals.size();i++){
    		Interval temp = intervals.get(i);
    		int start = pre.start;
    		int end = pre.end;
    		if(temp.start>end){
    			pre=temp;
    			continue;
    		}else if(temp.start==end){
    			pre.end=temp.end;
    			intervals.remove(temp);
    			i--;
    			continue;
    		}else{
    			if(temp.start>=start&&temp.end>=end){
    				temp.start=start;
    				intervals.remove(pre);
    				pre = temp;
    				i--;
    				continue;
    				
    			}else if(temp.start>=start&&temp.end<=end){
    				temp.start=start;
    				temp.end=end;
    				intervals.remove(pre);
    				pre=temp;
    				i--;
    				continue;
    			}else if(temp.start<=start&&temp.end>=end){
    				intervals.remove(pre);
    				pre=temp;
    				i--;
    				continue;
    			}else if(temp.start<=start&&temp.end>start&&end>temp.end){
    				temp.end=end;
    				intervals.remove(pre);
    				pre=temp;
    				i--;
    				continue;
    			}
    		}
    	}
		return intervals;
        
    }
    
    
}
class IntervalComparator implements Comparator<Interval>
{
    public int compare(Interval a, Interval b) {
        return a.start - b.start;
    }
}
