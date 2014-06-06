package com.leetcode.MaxPointsonaLine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int maxPoints(Point[] points) {
    	if(points==null||points.length==0)
    		return 0;
    	Map<Double,Integer> map = new HashMap<Double,Integer>();
    	int max = 0;
    	for(int i=0;i<points.length;i++){
    		map = new HashMap<Double,Integer>();
    		Point tp = points[i];
    		int tmax=0;
    		int count=0;
    		for(int j=0;j<points.length;j++){
    			Point tt = points[j];
    			
    			if(tt.x==tp.x&&tp.y==tt.y){
    				count++;
    				continue;
    			}else{
    				Double in = infinity(tp, tt);
    				if(map.isEmpty()){
    					map.put(in, 1);
    					if(tmax<1)
    						tmax=1;
    				}else{
    					if(map.containsKey(in)){
    						int tte = map.get(in)+1;
    						if(tte>max)
    							tmax=tte;
    					}else{
    						map.put(in, 1);
    					}
    				}
    			}
    			
    		}
    		if((tmax+count)>max)
				max=tmax+count;
    			
    	}
		return max;
        
    }
    
    private boolean contain(Map<Double, Integer> map, double temp) {
		// TODO Auto-generated method stub
    	Set<Double> set = map.keySet();
		Iterator<Double> it = set.iterator();
		while(it.hasNext()){
			double t = it.next();
			double tt = t-temp;
			if(Math.abs(tt)<0.0000001){
				return true;
			}
		}
		return false;
	}
    public void ss(Point[] points){
    	for(int i=0;i<points.length;i++){
    		for(int j=0;j<points.length;j++){
    			System.out.print(infinity(points[i],points[j])+"   ");
    		}
    		System.out.println();
    	}
    }
	private double infinity(Point high,Point low) {
		if(high.y==low.y)
			return (double)0;
		return high.x == low.x ? Double.MAX_VALUE : (high.y - low.y)*1.0/(high.x - low.x); 

		
	}
}
