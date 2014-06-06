package com.leetcode.WordSearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class NNSolution {
    public boolean exist(char[][] board, String word) {
    	if(word.length()==0)
    		return true;
    	if(board.length==0)
    		return false;
    	int max=0;
    	for(int j=0;j<board.length;j++){
    		if(board[j].length>max)
    			max=board[j].length;
    	}
    	boolean[][] bol = new boolean[board.length][max];
    	
    	ArrayList<Integer> te = new ArrayList<Integer>();
    	ArrayList<ArrayList<Integer>> re = new ArrayList<ArrayList<Integer>>();
    	ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[i].length;j++){
    			bol[i][j]=false;   			
    			if(word.charAt(0)==board[i][j]){
    				te = new ArrayList<Integer>();
    				te.add(i);
    				te.add(j);
    				re.add(te);
    			}
    				
    		}
    	}
    	if(re.isEmpty())
    		return false;
    	int windex=1;
    	while(!re.isEmpty()){
    		ArrayList<Integer> al = re.get(0);
    		int x = al.get(0);
    		int y = al.get(1);
    		if(!bol[x][y]){
    			if(board[x][y]==word.charAt(windex)){
    				bol[x][y]=true;
    				if(x+1<board.length){
    					te = new ArrayList<Integer>();
    					te.add(x+1);
    					te.add(y);
    					temp.add(te);
    				}
    				if(x-1>=0){
    					te = new ArrayList<Integer>();
    					te.add(x-1);
    					te.add(y);
    					temp.add(te);
    				}
    				if(y+1<board[x].length){
    					te = new ArrayList<Integer>();
    					te.add(x);
    					te.add(y+1);
    					temp.add(te);
    				}
    				if(y-1>=0){
    					te = new ArrayList<Integer>();
    					te.add(x);
    					te.add(y-1);
    					temp.add(te);
    				}
    			}
    		}
    		if(re.isEmpty()){
    			windex++;
    			if(windex==word.length())
    				return true;
    			if(temp.isEmpty())
    				return false;
    			re=temp;
    			temp = new ArrayList<ArrayList<Integer>>();
    		}
    	}
		return false;
    	
    }
 }
