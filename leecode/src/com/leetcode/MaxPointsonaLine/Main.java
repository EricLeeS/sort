package com.leetcode.MaxPointsonaLine;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		Point p1 = new Point(-54,297);
		Point p2 = new Point(-36,-222);
		Point p3 = new Point(3,-2);
		Point p4 = new Point(30,53);
		Point p5 = new Point(-5,1);
		Point p6 = new Point(-36,-222);
		Point p7 = new Point(0,2);
		Point p8 = new Point(1,3);
		Point p9 = new Point(6,-47);
		Point p10 = new Point(0,4);
		Point p11= new Point(2,3);
		
		Point p12 = new Point(48,128);
		Point p13 = new Point(24,28);
		Point p14= new Point(48,128);
		Point p15 = new Point(-12,-122);
		Point p16= new Point(-5,0);
		Point p17 = new Point(-5,0);
		Point p18 = new Point(-5,0);
//		Point p6 = new Point(-4,-4);
//		Point p6 = new Point(-4,-4);
//		Point p6 = new Point(-4,-4);
		
		Point[] points = {p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13,p14,p15,p16,p17,p18};
		System.out.println(so.maxPoints(points));
	}
}
