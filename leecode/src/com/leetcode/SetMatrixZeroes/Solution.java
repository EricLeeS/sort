package com.leetcode.SetMatrixZeroes;
/**
 * 这里可以选择第一行和第一列来存储标志位。

1.先确定第一行和第一列是否需要清零
2.扫描剩下的矩阵元素，如果遇到了0，就将对应的第一行和第一列上的元素赋值为0
3.根据第一行和第一列的信息，已经可以讲剩下的矩阵元素赋值为结果所需的值了
4.根据1中确定的状态，处理第一行和第一列。
 * @author lihuan
 *
 */
public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean rowflag=false;
        for(int mm=0;mm<col;mm++){
        	if(matrix[0][mm]==0){
        		rowflag=true;
        	}
        }
        boolean colflag=false;
        for(int nn=0;nn<row;nn++){
        	if(matrix[nn][0]==0){
        		colflag=true;
        	}
        }
        
        for(int i=1;i<row;i++){
        	for(int j=1;j<col;j++){
        		if(matrix[i][j]==0){
        			matrix[0][j]=0;
        			matrix[i][0]=0;
        			
        		}
        	}
        }
        
        for(int x=1;x<col;x++){
        	if(matrix[0][x]==0){
        		for(int nn=0;nn<row;nn++){
        			matrix[nn][x]=0;
        		}
        	}
        }
        
        for(int y=1;y<row;y++){
        	if(matrix[y][0]==0){
        		for(int nn=0;nn<col;nn++){
        			matrix[y][nn]=0;
        		}
        	}
        }
        if(rowflag){
        	 for(int mm=0;mm<col;mm++){
             	matrix[0][mm]=0;
             }
        }
        if(colflag){
        	for(int mm=0;mm<row;mm++)
        		matrix[mm][0]=0;
        }
    }
}
