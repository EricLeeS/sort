package com.demo.ast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.ImportDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.PackageDeclaration;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;



public class ASTParserJavaClass {
	public static void main(String[] args){
		String content = "";
		File file = new File("input/LmsLocationsResponse.java");
		//File file = new File("input/test.java");
		try {
			FileReader reader = new FileReader(file);
			int fileLength = (int)file.length();
			char[] buff = new char[fileLength];
			try {
				reader.read(buff);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			content = String.valueOf(buff);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(content.toCharArray());
		CompilationUnit unit =(CompilationUnit) parser.createAST(null);
		
		//get the main class 
		List types = unit.types();
		TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
		
		//get the import 
		List importList = unit.imports();
		System.out.println("imprt List :");
		for(Object obj : importList){
			ImportDeclaration importDec = (ImportDeclaration)obj;
			System.out.println(importDec.getName());
		}
		//get the pkg 
		System.out.println("**********************");
		PackageDeclaration packageDec = unit.getPackage();
		System.out.println("Package :");
		System.out.println(packageDec.getName());
		//mainClassName 
		System.out.println("************************");
		System.out.println("main class name :");
		System.out.println(typeDec.getName());
		System.out.println("************************");
		System.out.println("Extend class :");
		System.out.println(typeDec.getSuperclassType());
		System.out.println("************************");
		System.out.println("field :");
		//get the main class field
		FieldDeclaration[] fd = typeDec.getFields();
		for(FieldDeclaration fdtemp : fd){
			
			for(Object obj : fdtemp.fragments()){
				VariableDeclarationFragment vdf = (VariableDeclarationFragment)obj;
				System.out.println(vdf.getName());
			}
		}
		System.out.println("************************");
		System.out.println("method :");
		//get method 
		MethodDeclaration[] methodList = typeDec.getMethods();
		for(MethodDeclaration md : methodList){
			System.out.println(md.getName());
		}
		
		
		
	}
}
