package com.stubhub.codegen.template;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.*;
import org.eclipse.jdt.core.dom.Modifier.ModifierKeyword;

import com.stubhub.codegen.generator.Generator;
import com.stubhub.codegen.generator.MemberPair;
import com.stubhub.codegen.generator.MethodParameter;
import com.stubhub.codegen.util.CommonTool;

public class ResponseTemplate {
	private String packageName;
	private List<String> importList;
	private String className;
	private List<PropEntity> propList;

	public ResponseTemplate() {
		init();
	}
	
	public void setPackageName(String name){
		this.packageName = name;
	}
	
	public void setClassName(String name){
		this.className = name;
	}
	
	public void setImportList(List<String> list){
		this.importList = list;
	}
	
	public List<String> getImportList(){
		return this.importList;
	}
	
	public void setPropList(List<PropEntity> list){
		this.propList = list;
	}

	private void init() {
		packageName = "com.stubhub";
		importList = new ArrayList();
		importList.add("java.util.List");
		importList.add("javax.xml.bind.annotation.XmlAccessType");
		importList.add("javax.xml.bind.annotation.XmlAccessorType");
		importList.add("javax.xml.bind.annotation.XmlElement");
		importList.add("javax.xml.bind.annotation.XmlRootElement");
		importList.add("javax.xml.bind.annotation.XmlType");
		importList.add("com.stubhub.domain.fulfillment.common.BaseResponse");
		className = "Response";
		propList = new ArrayList();
	}

	public void generate(String outPath) {
		Generator generator = new Generator();
		AST ast = generator.getAST();
		generator.setPackage(packageName);
		generator.addImports(CommonTool.list2Array(importList));
		TypeDeclaration mainclass = generator.setMainClass(false, className,
				"BaseResponse", null);
		// Main Class Annotation
		//annotation 1
		generator.setSingleAnnotation(mainclass, "XmlAccessorType","XmlAccessType.FIELD", false);
		//annotation 2
		List<MemberPair> pairlist = new ArrayList<MemberPair>();
		MemberPair pair = new MemberPair("name", className, MemberPair.ValueType.STRING);
		pairlist.add(pair);
		generator.setNormalAnnotation(mainclass, "XmlRootElement", pairlist);
		//annotation 3
		List<MemberPair> array = new ArrayList<MemberPair>();
		for(PropEntity entity : propList){
			array.add(new MemberPair(null,entity.name,MemberPair.ValueType.STRING));
		}
		pair = new MemberPair("propOrder",array,MemberPair.ValueType.ARRAY);
		pairlist.add(pair);
		generator.setNormalAnnotation(mainclass,"XmlType",pairlist);
		//Field Declaration
		List<ModifierKeyword> publicModifier = new ArrayList<ModifierKeyword>();
		publicModifier.add(ModifierKeyword.PUBLIC_KEYWORD);
		List<ModifierKeyword> privateModifier = new ArrayList<ModifierKeyword>();
		privateModifier.add(ModifierKeyword.PRIVATE_KEYWORD);
		for(PropEntity entity : propList){
			FieldDeclaration field = null;
			switch(entity.getType()){
			case GENERIC_CLASS:{
				List<Type> ltypelist = new ArrayList<Type>();
				ltypelist.add(CommonTool.getType(ast,entity.className));
				field = generator.setClassVariableGenericClass(mainclass, privateModifier, entity.type, null, entity.name, 
						false, false, ltypelist, null, null);
				break;
			}
			case BOOL:{
				field = generator.setClassVariableBoolean(mainclass, privateModifier, entity.name, false, false);
				break;
			}
			case SIMPLE_CLASS:{
				field = generator.setClassVariableSimpleClass(mainclass, privateModifier, entity.className, null,
						entity.name, false, false, null);
				break;
			}
			case NUMBER:{
				field = generator.setClassVariableNumber(mainclass, privateModifier, entity.returnNumberType(entity.type), 
						entity.name, false, null);
				break;
			}
			default:{
				continue;
			}
			}
			if(field != null){
				pairlist = new ArrayList<MemberPair>();
				pair = new MemberPair("name",entity.name,MemberPair.ValueType.STRING);
				pairlist.add(pair);
				pair = new MemberPair("type",entity.className+".class",MemberPair.ValueType.VALUE);
				pairlist.add(pair);
				generator.setNormalAnnotation(field,"XmlElement",pairlist);
			}
			
		}
		//Method Declaration
		for(PropEntity entity : propList){
			//getter setter Function
			String getName = "get"+CommonTool.UpperCase(entity.name);
			String setName = "set"+CommonTool.UpperCase(entity.name);
			Type getReturnType;
			if(entity.getType() == PropEntity.PropType.GENERIC_CLASS){
				List<Type> ltypelist = new ArrayList<Type>();
				ltypelist.add(CommonTool.getType(ast,entity.className));
				getReturnType = CommonTool.getType2(ast, entity.type, ltypelist);
			}else{
				getReturnType = CommonTool.getType2(ast, entity.type, null);
			}
			MethodDeclaration getter = generator.setMethodDeclaration(mainclass, publicModifier, getName,
					false, getReturnType, null);
			Block block = generator.setMethodBlock(getter);
			generator.setReturnModule(block, entity.name);
			
			Type setReturnType = ast.newPrimitiveType(PrimitiveType.VOID);
			
			List<MethodParameter> paralist = new ArrayList<MethodParameter>();
			Type paraType;
			if(entity.getType() == PropEntity.PropType.GENERIC_CLASS){
				List<Type> ltypelist = new ArrayList<Type>();
				ltypelist.add(CommonTool.getType(ast,entity.className));
				paraType = CommonTool.getType2(ast, entity.type, ltypelist);
			}else{
				paraType = CommonTool.getType2(ast, entity.type, null);
			}
			MethodParameter para = new MethodParameter(ast,paraType,entity.name);
			paralist.add(para);
			MethodDeclaration setter = generator.setMethodDeclaration(mainclass, publicModifier, setName, false,
					setReturnType, paralist);
			block = generator.setMethodBlock(setter);
			generator.setSetModule(block, entity.name, entity.name);
		}

		try{
			generator.generateString();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
}
