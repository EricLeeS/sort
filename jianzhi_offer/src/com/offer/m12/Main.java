package com.offer.m12;

public class Main {
	private static StringBuilder sb = null;
	public static void main(String[] args){
		int n=2;
		PrintMaxNumber(n);
	}

	private static void PrintMaxNumber(int n) {
		// TODO Auto-generated method stub
		sb = new StringBuilder();
		sb.setLength(n);
		for(int i=0;i<n;i++){
			sb.setCharAt(i, '0');
		}
		System.out.println(sb.toString());
		int nun=1;
		while(n>0){
			nun*=10;
			n--;
		}
		for(int j=0;j<nun;j++){
			 Incr();
			PrintStr(sb.toString());
		}
		
	}

	private static StringBuilder Incr() {
		// TODO Auto-generated method stub
		int n=sb.length();
		for(int i=n-1;i>=0;i--){
			String str = sb.charAt(i)+"";
			
			int temp=Integer.parseInt(str);
			temp++;
			if(temp<10){
				char ch = (temp+"").toCharArray()[0];
				sb.setCharAt(i, ch);
				break;
			}else{
				temp=0;
				sb.setCharAt(i, '0');
				continue;
			}
		}
		return sb;
	}

	private static void PrintStr(String string) {
		// TODO Auto-generated method stub
		char[] ch = sb.toString().toCharArray();
		boolean bol = false;
		for(int i=0;i<ch.length;i++){
			
			if(ch[i]!='0'||bol){
				bol=true;
				System.out.print(ch[i]);
			}
		}
		System.out.println("************");
	}
}
