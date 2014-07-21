package com.leetcode.GrayCode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * http://www.cnblogs.com/lihaozy/archive/2012/12/31/2840437.html
 * @author Administrator
 *Gray Code�� ÿ�ο�ÿ�ζ����ǵá�д�������Լ�����ϰ��

Gray Code 0 = 0, ��һ����toggle���ұߵ�bit(LSB), ����һ����toggle���ұ�ֵΪ ��1�� bit�����һ��bit��Ȼ���ظ�

�磺 3bit

Gray Code:  000, 001, 011, 010, 110, 111, 101, 100, ���ұ�ֵΪ ��1�� ��bit��������ˣ�������

Binary      :  000, 001, 010, 011, 100, 101, 110, 111

 

���߾���Binary Code ת��ΪGray Code�ˡ�

�磺

����Binary Code ��1011 Ҫת����Gray Code

����1011 = 1����д��һλ��, 1(��һλ��ڶ�λ��� 1^0 = 1), 1(�ڶ�λ������λ�� 0^1=1), 0 (1^1 =0) = 1110

������ʵ�͵��� (1011 >> 1) ^ 1011 = 1110
 */
public class Solution {
    public List<Integer> grayCode(int n) {
		int size = 1 << n;		
		List<Integer> ret = new ArrayList<Integer>();
		
		for(int i=0; i<size; i++){
			
			ret.add(i ^ (i>>1));
		}
		return ret;
	}
}
