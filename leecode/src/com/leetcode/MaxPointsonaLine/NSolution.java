package com.leetcode.MaxPointsonaLine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class NSolution {
    public int maxPoints(Point[] points) {
		if(points.length==0){
			return 0;
		}else{
			int max=0;
			Map<Point,Double> in = new HashMap<Point,Double>(); 
			Map<Double,Integer> count = new HashMap<Double,Integer>();
			for(int i=0;i<points.length;i++){
				double temp =  infinity(points[i]);
				if(in.isEmpty()){
					in.put(points[i],temp);
				}else{
					if(ContainPoint(in,points[i])){
						int value = count.get(temp)+1;
						if(value>max){
							max = value;
						}
						count.put(temp,value);
						continue;
					}else{
						in.put(points[i],temp);
					}
				}
				
				
				if(count.isEmpty()){
					count.put(temp, 1);
					max=1;
				}else{
					if(Contain(count,temp)){
						int value = count.get(temp)+1;
						if(value>max){
							max = value;
						}
						count.put(temp,value);
					}else{
						count.put(temp, 1);
					}
				}
			}
			return max;
		}
        
    }

	private boolean ContainPoint(Map<Point, Double> in, Point point) {
		// TODO Auto-generated method stub
		Set<Point> set = in.keySet();
		Iterator<Point> it = set.iterator();
		while(it.hasNext()){
			Point temp = it.next();
			if(temp.x==point.x&&temp.y==point.y){
				return true;
			}
		}
		return false;
	}

	private boolean Contain(Map<Double, Integer> count, double temp) {
		// TODO Auto-generated method stub
		Set<Double> set = count.keySet();
		Iterator<Double> it = set.iterator();
		while(it.hasNext()){
			if((it.next()-temp)==0){
				return true;
			}
		}
		return false;
	}

	private Double infinity(Point point) {
		// TODO Auto-generated method stub
		if(point.x==0){
			return (double) 1024;
		}else{
			double x = point.x;
			double y = point.y;
			
			return y/x;
		}
		
	}
}
