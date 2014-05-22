package com.leetcode.threesum;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		Solution so = new Solution();
		int[] num={-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0};
		ArrayList<ArrayList<Integer>> re = so.threeSum(num);
		Iterator<ArrayList<Integer>> it = re.iterator();
		while(it.hasNext()){
			ArrayList<Integer> te = it.next();
			for(int i=0;i<te.size();i++){
				System.out.print(te.get(i));
			}
			System.out.println();
		}
	}
}
