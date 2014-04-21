package com.leetcode.uniquePathII;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    	int m = obstacleGrid.length;
    	int n= obstacleGrid[0].length;
    	
    	if(obstacleGrid[0][0]==1||obstacleGrid[m-1][n-1]==1){
    		return 0;
    	}else if(m==1){
    		for(int i=0;i<n;i++){
    			if(obstacleGrid[0][i]==1){
    				return 0;
    			}
    		}
    		return 1;
    	}else if(n==1){
    		for(int i=0;i<m;i++){
    			if((obstacleGrid[i][0])==1){
    				return 0;
    			}
    		}
    		return 1;
    	}else{
    		int[] map =new int[n+1];
    		int tt = 1;
        	for(int i=0;i<n;i++){
        		if(obstacleGrid[0][i]==1){
        			tt=0;
        			map[i]=tt;
        		}else{
        			map[i]=tt;
        		}        		 
        	}
     	      
        	for(int x=1;x<m;x++){
        		for(int y=0;y<n;y++){
        			if(obstacleGrid[x][y]==1){
        				map[y]=0;
        			}else{
        				if(y==0){
        					if(map[y]==0){
        						map[y]=0;
        					}else{
        						map[y]=1;
        					}
        				}else{
        					map[y]+=map[y-1];
        				}
        				
        			}
        		}
        	}
        	int re=map[n-1];
        	
        	return re;
    	}
    	
        
    }
}
