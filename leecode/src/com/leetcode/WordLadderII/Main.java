package com.leetcode.WordLadderII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
	public static void main(String[] args){
		String start = "red";
		String end = "tax";
		
		HashSet<String> set = new HashSet<String>();
		set.add("ted");
		set.add("tex");
		set.add("red");
		set.add("tax");
		set.add("tad");
		set.add("den");
		set.add("rex");
		set.add("pee");
		NNSolution so = new NNSolution();
		ArrayList<ArrayList<String>> re = so.findLadders(start, end, set);
		Iterator<ArrayList<String>> it = re.iterator();
		while(it.hasNext()){
			ArrayList<String> temp = it.next();
			for(int i=0;i<temp.size();i++){
				System.out.print(temp.get(i)+" ");
			}
			System.out.println();
		}
	}
}
