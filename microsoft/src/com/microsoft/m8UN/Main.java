package com.microsoft.m8UN;
/**
 * ��Ŀ����1+2+��+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ����Լ������ж���䣨A?B:C��
 * @author huanli2
 *
 */
public class Main {
	public static void main(String[] args){
		
//		@SuppressWarnings("unused")
//		Sum[] summ =new Sum[100];
//		//System.out.println(Sum.getAdd());
//		System.out.println(Sum.getSum());
		//int add =Sum(1);
		System.out.println(0&6);
		
	}
	public static int Sum(int add){
		return add&(add+Sum(add-1));
	}
}
