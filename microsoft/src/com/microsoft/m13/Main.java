package com.microsoft.m13;
/**
 * ��Ŀ����һ���ַ������ҵ���һ��ֻ����һ�ε��ַ���������abaccdeff�������b��
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		String sr = "abaccdeff";
		StringBuilder str1 = new StringBuilder("Slow");
		StringBuilder str2 = new StringBuilder("Medium");
		System.out.println(str1.reverse().toString().compareTo(str2.reverse().toString()));
	}
}
