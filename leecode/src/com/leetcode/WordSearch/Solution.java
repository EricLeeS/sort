package com.leetcode.WordSearch;

public class Solution {
    public boolean exist(char[][] board, String word) {
    	if(word.length()==0)
    		return true;
    	if(board.length==0)
    		return false;
    	boolean[][] bol = new boolean[board.length][board[0].length];
    	
    	for(int i=0;i<board.length;i++){
    		for(int j=0;j<board[i].length;j++){
    			
    			if(board[i][j]==word.charAt(0)&&findExist(i,j,0,board,bol,word)){
    				return true;
    			}
    		}
    	}
    	return false;
        
    }

	private boolean findExist(int x, int y,int wa, char[][] board, boolean[][] bol, String word) {
		if(wa>=word.length())
			return true;
		if(x<0||y<0)
			return false;
		if(x>=board.length||y>=board[x].length)
			return false;
		if(bol[x][y])
			return false;
		if(board[x][y]!=word.charAt(wa))
			return false;
					
			bol[x][y]=true;
			boolean re =findExist(x+1,y,wa+1,board,bol,word)||findExist(x,y+1,wa+1,board,bol,word)||
					findExist(x-1,y,wa+1,board,bol,word)||findExist(x,y-1,wa+1,board,bol,word);
			bol[x][y]=false;
		return re;
	}
}
