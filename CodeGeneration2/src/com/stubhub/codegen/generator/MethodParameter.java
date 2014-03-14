package com.stubhub.codegen.generator;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Type;

public class MethodParameter {
	private SingleVariableDeclaration variable;
	
	public MethodParameter(AST ast, Type type, String name){
		variable = ast.newSingleVariableDeclaration();
		this.variable.setType(type);
		this.variable.setName(ast.newSimpleName(name));
	}
	
	public SingleVariableDeclaration getParameter(){
		return this.variable;
	}
}
