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
import org.eclipse.jdt.core.dom.PrimitiveType;
import org.eclipse.jdt.core.dom.StringLiteral;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
public class ASTUpdateMethod {
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
		AST ast = unit.getAST();
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setName(ast.newSimpleName("main"));
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		
		VariableDeclarationFragment vdf = ast.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName("name"));
		StringLiteral string = ast.newStringLiteral();
		string.setLiteralValue("lihuan");
		vdf.setInitializer(string);
		VariableDeclarationStatement  vds = ast.newVariableDeclarationStatement(vdf);
		vds.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		vds.setType(ast.newPrimitiveType(PrimitiveType.INT));
		
		method.setBody(ast.newBlock());
		method.getBody().statements().add(vds);
		TypeDeclaration classType =  (TypeDeclaration) unit.types().get(0);
		classType.bodyDeclarations().add(method);
		
		
		
		CodeFormatUtil formatUtil = new CodeFormatUtil();
		//formatUtil.format(unit.toString())
		try {
			System.out.println(formatUtil.format(unit.toString()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
