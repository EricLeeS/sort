package com.microsoft.m7;
/**
 * 题目：输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。句子中单词以空格符隔开。为简单起见，标点符号和普通字母一样处理。
 * 例如输入“I am a student.”，则输出“student. a am I”。
 * @author huanli2
 *http://zhedahht.blog.163.com/blog/static/254111742007289205219/
 */
public class Main {
	public static void main(String[] args){
		String sr = "I am a student. and";
		String[] str = sr.split(" ");
		int i=0;
		int j=str.length-1;
		while(true){
			if(j>i){
				String temp=str[i];
				str[i]=str[j];
				str[j]=temp;
				i++;
				j--;
			}else{
				break;
			}
		}
		ConvertStr(str);
		for(int m=0;m<str.length;m++){
			System.out.println(str[m]);
		}
	}

	private static void ConvertStr(String[] str) {
		// TODO Auto-generated method stub
		for(int i=0;i<str.length;i++){
			char[] ch = str[i].toCharArray();
			int m=0;
			int n=ch.length-1;
			while(true){
				if(n>=m){
					char temp = ch[m];
					ch[m]=ch[n];
					ch[n]=temp;
					m++;
					n--;
				}else{
					break;
				}
			}
			str[i]=new String(ch);
		}
	}
}
