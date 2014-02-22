package com.stubhub.codegen;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.CompilationUnit;

public class CodeParser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("input/LmsLocationsResponse.java");
		String sourceCode = "";
		try {
			FileReader reader = new FileReader(file);
			int fileLength = (int)file.length();
			char[] buff = new char[fileLength];
			reader.read(buff);
			sourceCode = String.valueOf(buff);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		parser.setSource(sourceCode.toCharArray());
		CompilationUnit unit = (CompilationUnit) parser.createAST(null);
	}

}