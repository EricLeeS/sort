package com.leetcode.SurroundedRegions;

import java.util.Arrays;

public class Solution {
    public void solve(char[][] board) {
        int row = board.length;
        if(row==0)
        	return;
        
        int col = board[0].length;
        if(row<=2||col<=2)
        	return;
        Boolean[][] bol = new Boolean[row][col];
        for(int i=0;i<row;i++){
        	Boolean bl = false;
        	for(int j=0;j<col;j++){
        		bol[i][j]=false;
        		if(board[i][j]=='X'){
        			bl=true;
        		}
        		if(board[i][j]=='O'){
        			if(bl)
        				bol[i][j]=true;
        			else
        				bol[i][j]=false;
        						
        		}
        		
        	}
        	Boolean bo = false;
        	for(int k=col-1;k>=0;k--){
        		if(board[i][k]=='X')
        			bo = true;
        		if(board[i][k]=='O'){
        			if(bo&&bol[i][k])
        				board[i][k]='I';
        			else
        				bol[i][k]=false;
        		}
        	}
        }
        
        for(int m=0;m<col;m++){
        	boolean bl = false;
        	for(int x=0;x<row;x++){
        		if(board[x][m]=='X')
        			bl = true;
        		if(board[x][m]=='O')
        			bl = false;
        		if(board[x][m]=='I'){
        			if(bl){
        				bol[x][m]=true;
        			}else{
        				bol[x][m]=false;
        				board[x][m]='O';
        			}
        				
        			
        				
        		}
        			
        	}
        	boolean bo = false;
        	for(int y=row-1;y>=0;y--){
        		if(board[y][m]=='X')
        			bo = true;
        		if(board[y][m]=='O')
        			bo = false;
        		if(board[y][m]=='I'){
        			if(bol[y][m]&&bo){
        				if(m-1>=0){
        					if(board[y][m-1]=='X'||bol[y][m-1])
        						board[y][m]='Y';
        					else
        						board[y][m]='O';
        				}else{
        					board[y][m]='O';
            				bol[y][m]=false;
        				}
        				
        			}      				
        			else{
        				board[y][m]='O';
        				bol[y][m]=false;
        			}
        				
        		}
        	}
        }
        
        
        for(int n=0;n<row;n++){
        	Boolean bl = false;
        	for(int j=0;j<col;j++){       		
        		if(board[n][j]=='X'){
        			bl=true;
        		}
        		if(board[n][j]=='O')
        			bl = false;
        		if(board[n][j]=='Y'){
        			if(bl){
        				bol[n][j]=true;
        			}else{
        				bol[n][j]=false;
        			}
        		}
        		
        	}
        	Boolean bo = false;
        	for(int k=col-1;k>=0;k--){
        		if(board[n][k]=='X')
        			bo = true;
        		if(board[n][k]=='O')
        			bo = false;
        		if(board[n][k]=='Y'){
        			if(bo&&bol[n][k])
        				board[n][k]='Z';
        			else{
        				board[n][k]='O';
        				bol[n][k]=false;
        			}
        				
        		}
        	}
        }
        
        for(int nn=0;nn<col;nn++){
        	Boolean bl = false;
        	for(int j=0;j<row;j++){       		
        		if(board[j][nn]=='X'){
        			bl=true;
        		}
        		if(board[j][nn]=='O')
        			bl = false;
        		if(board[j][nn]=='Z'){
        			if(bl){
        				bol[j][nn]=true;
        			}else{
        				bol[j][nn]=false;
        			}
        		}
        		
        	}
        	Boolean bo = false;
        	for(int k=row-1;k>=0;k--){
        		if(board[k][nn]=='X')
        			bo = true;
        		if(board[k][nn]=='O')
        			bo = false;
        		if(board[k][nn]=='Z'){
        			if(bo&&bol[k][nn])
        				board[k][nn]='W';
        			else{
        				board[k][nn]='O';
        				bol[k][nn]=false;
        			}
        				
        		}
        	}
        }
        
        for(int nnn=0;nnn<row;nnn++){
        	Boolean bl = false;
        	for(int j=0;j<col;j++){       		
        		if(board[nnn][j]=='X'){
        			bl=true;
        		}
        		if(board[nnn][j]=='O')
        			bl = false;
        		if(board[nnn][j]=='W'){
        			if(bl){
        				bol[nnn][j]=true;
        			}else{
        				bol[nnn][j]=false;
        			}
        		}
        		
        	}
        	Boolean bo = false;
        	for(int k=col-1;k>=0;k--){
        		if(board[nnn][k]=='X')
        			bo = true;
        		if(board[nnn][k]=='O')
        			bo = false;
        		if(board[nnn][k]=='W'){
        			if(bo&&bol[nnn][k])
        				board[nnn][k]='T';
        			else{
        				board[nnn][k]='O';
        				bol[nnn][k]=false;
        			}
        				
        		}
        	}
        }
        
        for(int nnnn=0;nnnn<col;nnnn++){
        	Boolean bl = false;
        	for(int j=0;j<row;j++){       		
        		if(board[j][nnnn]=='X'){
        			bl=true;
        		}
        		if(board[j][nnnn]=='O')
        			bl = false;
        		if(board[j][nnnn]=='T'){
        			if(bl){
        				bol[j][nnnn]=true;
        			}else{
        				bol[j][nnnn]=false;
        			}
        		}
        		
        	}
        	Boolean bo = false;
        	for(int k=row-1;k>=0;k--){
        		if(board[k][nnnn]=='X')
        			bo = true;
        		if(board[k][nnnn]=='O')
        			bo = false;
        		if(board[k][nnnn]=='T'){
        			if(bo&&bol[k][nnnn])
        				board[k][nnnn]='X';
        			else{
        				board[k][nnnn]='O';
        				bol[k][nnnn]=false;
        			}
        				
        		}
        	}
        }
    }
}
