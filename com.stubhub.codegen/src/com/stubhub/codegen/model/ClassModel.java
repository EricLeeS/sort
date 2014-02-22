package com.stubhub.codegen.model;

import java.util.ArrayList;
import java.util.List;

import com.stubhub.codegen.util.CommonTool;

public class ClassModel extends ModifierModel{
	private String modifier;
	private String className;
	private String superClass;
	private List<String> interfaceClass;
	private List<FieldModel> fieldList;
	private List<MethodModel> methodList;
	private boolean isInterface = false;
	
	public ClassModel(String name){
		this.className = name;
		this.fieldList = new ArrayList<FieldModel>();
		this.superClass = null;
		this.interfaceClass = new ArrayList<String>();
		this.methodList = new ArrayList<MethodModel>();
		this.modifier = "public";
	}
	
	public void setIsInterface(boolean bool){
		this.isInterface = bool;
	}
	
	public void setSuperClass(String name){
		this.superClass = name;
	}
	
	public void addMethod(MethodModel method){
		this.methodList.add(method);
	}
	
	public void addInterfaceClass(String name){
		this.interfaceClass.add(name);
	}
	
	public void addField(FieldModel field){
		this.fieldList.add(field);
	}
	
	public List<FieldModel> getFieldList(){
		return this.fieldList;
	}
	
	public List<MethodModel> getMethodList(){
		return this.methodList;
	}
	
	public String getDeclaration(){
		StringBuilder builder = new StringBuilder();
		if(!CommonTool.isEmptyString(this.modifier))
			builder.append(this.modifier+" ");
		if(isInterface){
			builder.append("interface ");
		}else{
			builder.append("class ");
		}
		builder.append(this.className+" ");
		if(!CommonTool.isEmptyString(this.superClass))
			builder.append("extends "+this.superClass+" ");
		if(this.interfaceClass.size() >0){
			builder.append("implements ");
			for(String face : this.interfaceClass){
				builder.append(face+", ");
			}
			builder.deleteCharAt(builder.lastIndexOf(","));
		}
		return builder.toString();
	}
}
