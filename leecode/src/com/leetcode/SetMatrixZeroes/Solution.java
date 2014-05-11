package com.leetcode.SetMatrixZeroes;
/**
 * �������ѡ���һ�к͵�һ�����洢��־λ��

1.��ȷ����һ�к͵�һ���Ƿ���Ҫ����
2.ɨ��ʣ�µľ���Ԫ�أ����������0���ͽ���Ӧ�ĵ�һ�к͵�һ���ϵ�Ԫ�ظ�ֵΪ0
3.���ݵ�һ�к͵�һ�е���Ϣ���Ѿ����Խ�ʣ�µľ���Ԫ�ظ�ֵΪ��������ֵ��
4.����1��ȷ����״̬�������һ�к͵�һ�С�
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
