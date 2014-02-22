package com.stubhub.codegen;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;

import com.stubhub.codegen.generator.Generator;
import com.stubhub.codegen.generator.MemberPair;
import com.stubhub.codegen.generator.MethodParameter;
import com.stubhub.codegen.util.CommonTool;

public class TestCodeGenerator {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] importlist = { "javax.xml.bind.annotation.XmlAccessType",
				"javax.xml.bind.annotation.XmlAccessorType",
				"javax.xml.bind.annotation.XmlElement", "javax.xml.bind.annotation.XmlRootElement",
				"javax.xml.bind.annotation.XmlType",
				"com.stubhub.domain.fulfillment.common.BaseResponse" };

		Generator generator = new Generator();
		// add package
		generator.setPackage("com.stubhub.domain.fulfillment.lms.v1.intf");
		// add imports
		generator.addImports(importlist);
		// add mainclass return class
		TypeDeclaration mainclass = generator.setMainClass(false, "LmsLocationResponse",
				"BaseResponse", null);
		// add JavaDoc
		List text = new ArrayList();
		text.add("Version 1.0");
		text.add("Java JDT Code Generation");
		generator.setJavaDocTextElement(mainclass, CommonTool.list2Array(text));
		generator.setJavaDocTagName(mainclass, TagElement.TAG_AUTHOR, "lihuan");
		// add annotation
		generator.setMarkerAnnotation(mainclass, "MarkerAnnotation");
		generator.setSingleAnnotation(mainclass, "XmlAccessorType", "XmlAccessType.FIELD", false);
		generator.setSingleAnnotation(mainclass, "XmlAccessorType", "XmlAccessType.FIELD", true);

		List<MemberPair> pairlist = new ArrayList<MemberPair>();
		MemberPair member = new MemberPair("name", "LmsLocationsResponse",
				MemberPair.ValueType.STRING);
		pairlist.add(member);
		List<MemberPair> array = new ArrayList<MemberPair>();
		MemberPair value = new MemberPair(null, "lmsRegions", MemberPair.ValueType.STRING);
		array.add(value);
		value = new MemberPair(null, "eventLmsLocations", MemberPair.ValueType.VALUE);
		array.add(value);
		member = new MemberPair("propOrder", array, MemberPair.ValueType.ARRAY);
		pairlist.add(member);
		generator.setNormalAnnotation(mainclass, "XmlType", pairlist);

		array = new ArrayList<MemberPair>();
		value = new MemberPair(null, "MEDIATYPE.APPLICATION_JSON", MemberPair.ValueType.VALUE);
		array.add(value);
		value = new MemberPair(null, "MEDIATYPE.APPLICATION_XML", MemberPair.ValueType.VALUE);
		array.add(value);
		generator.setSingleAnnotation(mainclass, "Produces", array);

		// add class variable
		List<ModifierKeyword> modifierlist = new ArrayList<ModifierKeyword>();
		modifierlist.add(ModifierKeyword.PUBLIC_KEYWORD);
		
		generator.setClassVariableNumber(mainclass, modifierlist, PrimitiveType.INT, "testInt",
				true, Integer.toString(1024));
		generator.setClassVariableBoolean(mainclass, modifierlist, "testBool", true, true);
		generator.setClassVariableSimpleClass(mainclass, modifierlist, "Generator.TEST",
				"GeneratorImpl", "testClass", true, false, null);
		List<Type> ltypelist = new ArrayList<Type>();
		AST ast = generator.getAST();
		ltypelist.add(CommonTool.getType(ast, "Integer"));
		ltypelist.add(CommonTool.getType(ast, "String"));
		List<Type> rtypelist = new ArrayList<Type>();
		rtypelist.add(CommonTool.getType(ast, "Integer"));
		rtypelist.add(CommonTool.getType(ast, "String"));
		generator.setClassVariableGenericClass(mainclass, modifierlist, "List", "ArrayList",
				"testGeneric", true, false, ltypelist, rtypelist, null);

		Type lintType = ast.newPrimitiveType(PrimitiveType.INT);
		Type rintType = ast.newPrimitiveType(PrimitiveType.INT);
		int[] dim = { 10, 20 };
		generator.setClassVariableArray(mainclass, modifierlist, lintType, rintType, "intArray",
				true, 2, dim);
		
		//class constructor
		List<MethodParameter> paralist = new ArrayList<MethodParameter>();
		Type para1Type = ast.newSimpleType(ast.newSimpleName("Composite"));
		MethodParameter para1 = new MethodParameter(ast, para1Type , "composite");
		paralist.add(para1);
		pairlist = new ArrayList<MemberPair>();
		member = new MemberPair("value", "eventIds",MemberPair.ValueType.STRING);
		pairlist.add(member);
		generator.setNormalAnnotation(para1.getParameter(), "QueryParam", pairlist);
		modifierlist = new ArrayList<ModifierKeyword>();
		modifierlist.add(ModifierKeyword.PUBLIC_KEYWORD);
		generator.setMethodDeclaration(mainclass, modifierlist, "LmsLocationsResponse", true, null, paralist);
		
		
		
		
		
		
		
		try {
			generator.generateString();
			String outPath = "output/com/stubhub/domain/fulfillment/lms/v1/intf/";
			outPath += "LmsLocationResponse.java";
			generator.generateFile(outPath);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
