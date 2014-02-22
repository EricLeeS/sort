package com.stubhub.codegen.util;

public class CommonTool {
	public static boolean isEmptyString(String str) {
		if (str == null || "".equals(str.trim()))
			return true;
		return false;
	}
	
	public static String UpperCase(String str){
		char[] arr = str.toCharArray();
		
		if(arr[0] >= 'a' && arr[0] <= 'z')
			arr[0] -= 'a' - 'A';
		 
		return new String(arr);
	}
	
	public static String LowerCase(String str){
		char[] arr = str.toCharArray();
		
		if(arr[0] >= 'A' && arr[0] <= 'Z')
			arr[0] += 'a' - 'A';
		 
		return new String(arr);
	}
}
