package com.demo.ast;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;


public class ASTGenerate {
	@SuppressWarnings({ "unchecked", "static-access" })
	public static void main(String[] args){
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource("".toCharArray());
		CompilationUnit unit = (CompilationUnit) parser.createAST(null);		
		unit.recordModifications();
		AST ast = unit.getAST();
		//set the package name
		PackageDeclaration packageDeclaration = ast.newPackageDeclaration();
		unit.setPackage(packageDeclaration);
		String[] pck = {"com","stubhub","code"};
		packageDeclaration.setName(ast.newName(pck));
		
		//set the class
		TypeDeclaration classType = ast.newTypeDeclaration();
		classType.setName(ast.newSimpleName("test"));
		classType.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		//classType.setSuperclassType(ast.newSimpleType(ast.newSimpleName("new")));
		classType.setSuperclassType(ast.newSimpleType(ast.newSimpleName("astexplore")));
		unit.types().add(classType);
		
		//add field 
		// private int id;
		VariableDeclarationFragment vdf = ast.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName("id"));
		vdf.setInitializer(ast.newNumberLiteral("100"));
		FieldDeclaration fd = ast.newFieldDeclaration(vdf);
		fd.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		fd.setType(ast.newPrimitiveType(PrimitiveType.INT));
		classType.bodyDeclarations().add(fd);
		
		//add method
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setName(ast.newSimpleName("main"));
		method.modifiers().add(ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		method.modifiers().add(ast.newModifier(ModifierKeyword.STATIC_KEYWORD));
		//add method field
		vdf = ast.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName("name"));
		StringLiteral string = ast.newStringLiteral();
		string.setLiteralValue("lihuan");
		vdf.setInitializer(string);
		VariableDeclarationStatement  vds = ast.newVariableDeclarationStatement(vdf);
		vds.modifiers().add(ast.newModifier(ModifierKeyword.PRIVATE_KEYWORD));
		vds.setType(ast.newPrimitiveType(PrimitiveType.INT));
		method.setBody(ast.newBlock());
		method.getBody().statements().add(vds);
		
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
