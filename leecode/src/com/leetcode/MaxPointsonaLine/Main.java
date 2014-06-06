package com.leetcode.MaxPointsonaLine;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		Point p1 = new Point(-4,-4);
		Point p2 = new Point(-8,-528);
		Point p3 = new Point(-3,3);
		Point p4 = new Point(-9,-651);
		Point p5 = new Point(9,591);
		
		
		Point[] points = {p1,p2,p3,p4,p5};
	//	System.out.println(so.maxPoints(points));
		so.ss(points);
	}
}
