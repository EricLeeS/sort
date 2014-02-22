package com.stubhub.codegen.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ParameterizedType;
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.QualifiedType;
import org.eclipse.jdt.core.dom.SimpleType;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.PrimitiveType.Code;


public class CommonTool {
	public static boolean isEmptyString(String str) {
		if (str == null || "".equals(str.trim()))
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public static String[] list2Array(List list) {
		return (String[]) list.toArray(new String[list.size()]);
	}

	public static Type getType(AST ast, String type) {
		String[] names = type.split("\\.");
		if (names.length == 1) {
			return ast.newSimpleType(ast.newSimpleName(type));
		} else if(names.length >= 2){
			return ast.newSimpleType(ast.newName(names));
		}
		return null;
	}
	
	public static Type getType2(AST ast, String type, List<Type> paralist){
		String ltype = type.toLowerCase();
		if("list".equals(ltype)){
			ParameterizedType pt = ast.newParameterizedType(CommonTool.getType(ast,type));
			if(paralist != null){
				for(Type para : paralist){
					pt.typeArguments().add(para);
				}
			}
			return pt;
		}
		else if("bool".equals(ltype) || "boolean".equals(ltype))
			return ast.newPrimitiveType(PrimitiveType.BOOLEAN);
		else if(isNumber(type))
			return ast.newPrimitiveType(returnNumberType(type));
		else 
			return getType(ast,type);
	}
	
	public static boolean isNumber(String type){
		String ltype = type.toLowerCase();
		if("int".equals(ltype) || "short".equals(ltype) || "long".equals(ltype)
				|| "float".equals(ltype) || "double".equals(ltype))
			return true;
		else
			return false;
	}
	
	public static Code returnNumberType(String type){
		String ltype = type.toLowerCase();
		
		if("int".equals(ltype))
			return PrimitiveType.INT;
		else if("short".equals(ltype))
			return PrimitiveType.SHORT;
		else if("long".equals(ltype))
			return PrimitiveType.LONG;
		else if("float".equals(ltype))
			return PrimitiveType.FLOAT;
		else if("double".equals(ltype))
			return PrimitiveType.DOUBLE;
		else
			return PrimitiveType.VOID;
	}
	
	public static String getJavaFromFile(String javafile) throws Exception {
		FileInputStream reader = new FileInputStream(new File(javafile));
		byte[] buff = new byte[reader.available()];
		reader.read(buff, 0, reader.available());
		String content = new String(buff);
		return content;
	}
	
	public static String UpperCase(String str){
		char[] arr = str.toCharArray();
		
		if(arr[0] >= 'a' && arr[0] <= 'z')
			arr[0] -= 'a' - 'A';
		 
		return new String(arr);
	}
}
