package com.leetcode.RomantoInteger;

public class Solution {
	public  int romanToInt(String s) {
		int re=0;
		if(s.equalsIgnoreCase("")){
			return re;
		}else{
			char[] ch = s.toCharArray();
			char pre = 0;
			for(int i=0;i<ch.length;i++){
				char temp = ch[i];
				switch(temp){
				case 'I':
					pre='I';
					re+=1;
					break;
				case 'V':
					if(pre=='I')
						re-=2;
					re+=5;
					pre='V';
					break;
				case 'X':
					if(pre=='I')
						re-=2;
					re+=10;
					pre='X';
					break;
				case 'L':
					if(pre=='X')
						re-=20;
					re+=50;
					pre='L';
					break;
				case 'C':
					if(pre=='X')
						re-=20;
					re+=100;
					pre='C';
					break;
				case 'D':
					if(pre=='C')
						re-=200;
					re+=500;
					pre='D';
					break;
				case 'M':
					if(pre=='C')
						re-=200;
					re+=1000;
					pre='M';
					break;
					
				}
			}
		}
		return re;
		
	}
}
