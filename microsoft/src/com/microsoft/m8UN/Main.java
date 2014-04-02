package com.microsoft.m8UN;
/**
 * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字以及条件判断语句（A?B:C）
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
