package com.leetcode.SpiralMatrix;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
//		int[][] a = {{1,2,3,4},{5,6,7,8},{13,14,15,16}};
		int[][] a={{1,2,3},{4,5,6}};
		ArrayList<Integer> re = so.spiralOrder(a);
		Iterator<Integer> it = re.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
