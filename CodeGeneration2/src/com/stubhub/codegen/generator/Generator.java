package com.stubhub.codegen.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.stubhub.codegen.format.CodeFormatUtil;
import com.stubhub.codegen.util.CommonTool;

import org.apache.commons.io.FileUtils;
import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;
import org.eclipse.jdt.core.dom.PrimitiveType.Code;

public class Generator {
	private CompilationUnit unit;
	private AST ast;

	public Generator() {
		ASTParser parser = ASTParser.newParser(AST.JLS4);
		parser.setSource("".toCharArray());
		unit = (CompilationUnit) parser.createAST(null);
		
		unit.recordModifications();
		ast = unit.getAST();
	}

	public void generateFile(String filePath) throws IOException, Exception {
		String outDir = filePath.substring(0, filePath.lastIndexOf("/"));
		FileUtils.forceMkdir(new File(outDir));
		File outFile = new File(filePath);
		Writer writer = new FileWriter(outFile);
		char[] formattedCode = CodeFormatUtil.format(unit.toString())
				.toCharArray();
		writer.write(formattedCode);
		writer.close();
	}

	public void generateString() throws Exception {
		char[] formattedCode = CodeFormatUtil.format(unit.toString())
				.toCharArray();
		System.out.print(formattedCode);
	}

	public void setPackage(String packageName) {
		PackageDeclaration packageDeclaration = ast.newPackageDeclaration();
		packageDeclaration.setName(ast.newName(getSimpleNames(packageName)));
		unit.setPackage(packageDeclaration);
	}

	@SuppressWarnings("unchecked")
	public void addImports(String[] imports) {
		ImportDeclaration importDeclaration;
		for (int i = 0; i < imports.length; i++) {
			importDeclaration = ast.newImportDeclaration();
			importDeclaration.setName(ast.newName(getSimpleNames(imports[i])));
			if (imports[i].indexOf("*") > 0) {
				importDeclaration.setOnDemand(true);
			} else {
				importDeclaration.setOnDemand(false);
			}
			unit.imports().add(importDeclaration);
		}
	}

	/**
	 * creat class
	 * @param isInterface
	 * @param className
	 * @param superClass
	 * @param interfaceList
	 * @return TypeDeclaration
	 */
	@SuppressWarnings("unchecked")
	public TypeDeclaration setMainClass(boolean isInterface, String className,
			String superClass, String[] interfaceList) {
		TypeDeclaration classType = ast.newTypeDeclaration();
		classType.setInterface(isInterface);
		//set the class modifier
		classType.modifiers().add(
				ast.newModifier(ModifierKeyword.PUBLIC_KEYWORD));
		if (CommonTool.isEmptyString(className))
			return null;
		classType.setName(ast.newSimpleName(className));
		if (!isInterface && !CommonTool.isEmptyString(superClass)) {
			classType.setSuperclassType(ast.newSimpleType(ast
					.newSimpleName(superClass)));
		}
		if (interfaceList != null) {
			for (int i = 0; i < interfaceList.length; i++) {
				if (!CommonTool.isEmptyString(interfaceList[i]))
					classType.superInterfaceTypes().add(
							ast.newSimpleType(ast
									.newSimpleName(interfaceList[i])));
			}
		}
		unit.types().add(classType);
		return classType;
	}

	@SuppressWarnings("unchecked")
	public void setJavaDocTextElement(BodyDeclaration declaration, String[] text) {
		Javadoc javadoc = declaration.getJavadoc();
		if (declaration.getJavadoc() == null) {
			javadoc = ast.newJavadoc();
			declaration.setJavadoc(javadoc);
		}
		TagElement tag = ast.newTagElement();
		TextElement element;
		for (int i = 0; i < text.length; i++) {
			if (!CommonTool.isEmptyString(text[i])) {
				element = ast.newTextElement();
				element.setText(text[i]);
				tag.fragments().add(element);
			}
		}
		javadoc.tags().add(tag);
	}

	@SuppressWarnings("unchecked")
	public void setJavaDocTagName(BodyDeclaration declaration, String tagName,
			String text) {
		Javadoc javadoc = declaration.getJavadoc();
		if (declaration.getJavadoc() == null) {
			javadoc = ast.newJavadoc();
			declaration.setJavadoc(javadoc);
		}
		TagElement tag = ast.newTagElement();
		if (CommonTool.isEmptyString(tagName))
			return;
		tag.setTagName(tagName);
		TextElement element;
		if (!CommonTool.isEmptyString(text)) {
			element = ast.newTextElement();
			element.setText(text);
			tag.fragments().add(element);
		}
		javadoc.tags().add(tag);
	}

	@SuppressWarnings("unchecked")
	public void setMarkerAnnotation(BodyDeclaration declaration, String name) {
		MarkerAnnotation marker = ast.newMarkerAnnotation();
		marker.setTypeName(ast.newSimpleName(name));
		declaration.modifiers().add(0, marker);
	}

	@SuppressWarnings("unchecked")
	public void setSingleAnnotation(BodyDeclaration declaration, String name,
			String value, boolean isString) {
		SingleMemberAnnotation single = ast.newSingleMemberAnnotation();
		single.setTypeName(ast.newSimpleName(name));
		if (isString) {
			
			StringLiteral string = ast.newStringLiteral();
			string.setLiteralValue(value);
			single.setValue(string);
		} else {
			single.setValue(ast.newName(value));
		}
		declaration.modifiers().add(0, single);
	}

	@SuppressWarnings("unchecked")
	public void setSingleAnnotation(BodyDeclaration declaration, String name,
			List<MemberPair> pairList) {
		SingleMemberAnnotation single = ast.newSingleMemberAnnotation();
		single.setTypeName(ast.newSimpleName(name));
		ArrayInitializer array = ast.newArrayInitializer();
		List ex = array.expressions();
		for (MemberPair pair : pairList) {
			switch (pair.type) {
			case STRING: {
				StringLiteral string = ast.newStringLiteral();
				string.setLiteralValue((String) pair.value);
				ex.add(string);
				break;
			}
			case VALUE: {
				ex.add(ast.newName((String) pair.value));
				break;
			}
			default:
				break;
			}
		}
		single.setValue(array);
		declaration.modifiers().add(0, single);
	}

	@SuppressWarnings("unchecked")
	public void setNormalAnnotation(BodyDeclaration declaration, String name,
			List<MemberPair> pairList) {
		NormalAnnotation normal = ast.newNormalAnnotation();
		normal.setTypeName(ast.newSimpleName(name));
		for (MemberPair pair : pairList) {
			if (CommonTool.isEmptyString(pair.name)) {
				continue;
			} else {
				MemberValuePair memberPair = ast.newMemberValuePair();
				memberPair.setName(ast.newSimpleName(pair.name));
				switch (pair.type) {
				case STRING: {
					StringLiteral string = ast.newStringLiteral();
					string.setLiteralValue((String) pair.value);
					memberPair.setValue(string);
					break;
				}
				case ARRAY: {
					ArrayInitializer array = ast.newArrayInitializer();
					List ex = array.expressions();
					List<MemberPair> valuelist = (List<MemberPair>) pair.value;
					for (MemberPair value : valuelist) {
						switch (value.type) {
						case STRING: {
							StringLiteral string = ast.newStringLiteral();
							string.setLiteralValue((String) value.value);
							ex.add(string);
							break;
						}
						case VALUE: {
							ex.add(ast.newName((String) value.value));
							break;
						}
						default:
							break;
						}
					}
					memberPair.setValue(array);
					break;
				}
				case VALUE: {
					if(pair.value.toString().endsWith(".class")){
						TypeLiteral typeliteral = ast.newTypeLiteral();
						String className = pair.value.toString().substring(0,pair.value.toString().lastIndexOf(".class"));
						typeliteral.setType(CommonTool.getType(ast, className));
						memberPair.setValue(typeliteral);
					}
					else{
						memberPair.setValue(ast.newName((String) pair.value));
					}
					break;
				}
				default:
					break;
				}
				normal.values().add(memberPair);
			}
		}
		declaration.modifiers().add(0, normal);
	}

	@SuppressWarnings("unchecked")
	public void setNormalAnnotation(SingleVariableDeclaration declaration,
			String name, List<MemberPair> pairList) {
		NormalAnnotation normal = ast.newNormalAnnotation();
		normal.setTypeName(ast.newSimpleName(name));
		for (MemberPair pair : pairList) {
			if (CommonTool.isEmptyString(pair.name)) {
				continue;
			} else {
				MemberValuePair memberPair = ast.newMemberValuePair();
				memberPair.setName(ast.newSimpleName(pair.name));
				switch (pair.type) {
				case STRING: {
					StringLiteral string = ast.newStringLiteral();
					string.setLiteralValue((String) pair.value);
					memberPair.setValue(string);
					break;
				}
				case ARRAY: {
					ArrayInitializer array = ast.newArrayInitializer();
					List ex = array.expressions();
					List<MemberPair> valuelist = (List<MemberPair>) pair.value;
					for (MemberPair value : valuelist) {
						switch (value.type) {
						case STRING: {
							StringLiteral string = ast.newStringLiteral();
							string.setLiteralValue((String) value.value);
							ex.add(string);
							break;
						}
						case VALUE: {
							ex.add(ast.newName((String) value.value));
							break;
						}
						default:
							break;
						}
					}
					memberPair.setValue(array);
					break;
				}
				case VALUE: {
					memberPair.setValue(ast.newName((String) pair.value));
					break;
				}
				default:
					break;
				}
				normal.values().add(memberPair);
			}
		}
		declaration.modifiers().add(0, normal);
	}

	@SuppressWarnings("unchecked")
	public FieldDeclaration setClassVariableNumber(TypeDeclaration cls,
			List<ModifierKeyword> modifiers, Code type, String varName,
			boolean isSetInit, String value) {
		VariableDeclarationFragment vdf = ast
				.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName(varName));
		if (isSetInit){
			vdf.setInitializer(ast.newNumberLiteral(value));
		}
		FieldDeclaration field = ast.newFieldDeclaration(vdf);
		for (ModifierKeyword modifier : modifiers) {
			field.modifiers().add(ast.newModifier(modifier));
		}
		if (type != PrimitiveType.INT && type != PrimitiveType.LONG
				&& type != PrimitiveType.SHORT && type != PrimitiveType.FLOAT
				&& type != PrimitiveType.DOUBLE)
			return null;
		field.setType(ast.newPrimitiveType(type));
		cls.bodyDeclarations().add(field);
		return field;
	}

	@SuppressWarnings("unchecked")
	public FieldDeclaration setClassVariableBoolean(TypeDeclaration cls,
			List<ModifierKeyword> modifiers, String varName, boolean isSetInit,
			boolean value) {
		VariableDeclarationFragment fragment = ast
				.newVariableDeclarationFragment();
		fragment.setName(ast.newSimpleName(varName));
		if (isSetInit){
			fragment.setInitializer(ast.newBooleanLiteral(value));
		}
		FieldDeclaration field = ast.newFieldDeclaration(fragment);
		for (ModifierKeyword modifier : modifiers) {
			field.modifiers().add(ast.newModifier(modifier));
		}
		field.setType(ast.newPrimitiveType(PrimitiveType.BOOLEAN));
		cls.bodyDeclarations().add(field);
		return field;
	}

	@SuppressWarnings("unchecked")
	public FieldDeclaration setClassVariableSimpleClass(TypeDeclaration cls,
			List<ModifierKeyword> modifiers, String ltype, String rtype,
			String varName, boolean isSetInit, boolean isNull,
			List<Expression> arguments) {
		VariableDeclarationFragment vdf = ast
				.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName(varName));
		//VariableDeclarationStatement vds = ast.newVariableDeclarationStatement(vdf);
		//vds.
		FieldDeclaration field = ast.newFieldDeclaration(vdf);
		field.setType(CommonTool.getType(ast, ltype));
		for (ModifierKeyword modifier : modifiers) {
			field.modifiers().add(ast.newModifier(modifier));
		}
		if (isSetInit) {
			if (isNull) {
				vdf.setInitializer(ast.newNullLiteral());
			} else {
				ClassInstanceCreation instance = ast.newClassInstanceCreation();
				instance.setType(CommonTool.getType(ast, rtype));
				vdf.setInitializer(instance);
				if (arguments != null) {
					for (Expression argument : arguments) {
						instance.arguments().add(argument);
					}
				}
			}
		}
		cls.bodyDeclarations().add(field);
		return field;
	}

	@SuppressWarnings("unchecked")
	public FieldDeclaration setClassVariableGenericClass(TypeDeclaration cls,
			List<ModifierKeyword> modifiers, String ltype, String rtype,
			String varName, boolean isSetInit, boolean isNull,
			List<Type> lgenerics, List<Type> rgenerics,
			List<Expression> arguments) {
		VariableDeclarationFragment vdf = ast
				.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName(varName));
		FieldDeclaration field = ast.newFieldDeclaration(vdf);
		ParameterizedType pt = ast.newParameterizedType(CommonTool.getType(ast,
				ltype));
		if (lgenerics != null) {
			for (Type generic : lgenerics) {
				pt.typeArguments().add(generic);
			}
		}
		field.setType(pt);
		for (ModifierKeyword modifier : modifiers) {
			field.modifiers().add(ast.newModifier(modifier));
		}
		if (isSetInit) {
			if (isNull) {
				vdf.setInitializer(ast.newNullLiteral());
			} else {
				ClassInstanceCreation instance = ast.newClassInstanceCreation();
				pt = ast.newParameterizedType(CommonTool.getType(ast, rtype));
				if (rgenerics != null) {
					for (Type generic : rgenerics) {
						pt.typeArguments().add(generic);
					}
				}
				instance.setType(pt);
				vdf.setInitializer(instance);
				if (arguments != null) {
					for (Expression argument : arguments) {
						instance.arguments().add(argument);
					}
				}
			}
		}
		cls.bodyDeclarations().add(field);
		return field;
	}

	@SuppressWarnings("unchecked")
	public FieldDeclaration setClassVariableArray(TypeDeclaration cls,
			List<ModifierKeyword> modifiers, Type ltype, Type rtype,
			String varName, boolean isSetInit, int dimLength, int[] dimensions) {
		VariableDeclarationFragment vdf = ast
				.newVariableDeclarationFragment();
		vdf.setName(ast.newSimpleName(varName));
		FieldDeclaration field = ast.newFieldDeclaration(vdf);
		field.setType(ast.newArrayType(ltype, dimLength));
		for (ModifierKeyword modifier : modifiers) {
			field.modifiers().add(ast.newModifier(modifier));
		}
		if (isSetInit) {
			
			ArrayCreation array = ast.newArrayCreation();
			array.setType(ast.newArrayType(rtype, dimLength));
			for (int i = 0; i < Math.min(dimLength, dimensions.length); i++) {
				array.dimensions().add(
						ast.newNumberLiteral(Integer.toString(dimensions[i])));
			}
			vdf.setInitializer(array);
		}
		cls.bodyDeclarations().add(field);
		return field;
	}

	@SuppressWarnings("unchecked")
	public MethodDeclaration setMethodDeclaration(TypeDeclaration cls,
			List<ModifierKeyword> modifiers, String name,
			boolean isConstructor, Type returnType,
			List<MethodParameter> parameters) {
		MethodDeclaration method = ast.newMethodDeclaration();
		method.setName(ast.newSimpleName(name));
		if (isConstructor) {
			method.setConstructor(true);
		} else {
			if (returnType != null)
				method.setReturnType2(returnType);
		}
		if (modifiers != null) {
			for (ModifierKeyword modifier : modifiers) {
				method.modifiers().add(ast.newModifier(modifier));
			}
		}
		if (parameters != null) {
			for (MethodParameter parameter : parameters) {
				method.parameters().add(parameter.getParameter());
			}
		}
		cls.bodyDeclarations().add(method);
		return method;
	}

	public Block setMethodBlock(MethodDeclaration method) {
		Block methodBlock = ast.newBlock();
		method.setBody(methodBlock);
		return methodBlock;
	}

	public void setSetModule(Block block, String lside, String rside) {
		Assignment assign = ast.newAssignment();
		assign.setOperator(Assignment.Operator.ASSIGN);
		FieldAccess field = ast.newFieldAccess();
		field.setExpression(ast.newThisExpression());
		field.setName(ast.newSimpleName(lside));
		assign.setLeftHandSide(field);
		assign.setRightHandSide(ast.newSimpleName(rside));
		block.statements().add(ast.newExpressionStatement(assign));
	}

	public void setReturnModule(Block block, String name) {
		ReturnStatement statement = ast.newReturnStatement();
		statement.setExpression(ast.newSimpleName(name));
		block.statements().add(statement);
	}

	public AST getAST() {
		return this.ast;
	}

	private String[] getSimpleNames(String qualifiedName) {
		StringTokenizer st = new StringTokenizer(qualifiedName, ".");
		ArrayList<String> list = new ArrayList<String>();
		while (st.hasMoreTokens()) {
			String name = st.nextToken().trim();
			if (!name.equals("*"))
				list.add(name);
		}
		return (String[]) list.toArray(new String[list.size()]);
	}
}
