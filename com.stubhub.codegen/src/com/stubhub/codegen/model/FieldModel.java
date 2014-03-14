package com.stubhub.codegen.model;

import com.stubhub.codegen.util.CommonTool;

public class FieldModel extends ModifierModel {
	private String modifier;
	private String type;
	private String name;
	private String initializer;
	
	public FieldModel(String modifier, String type, String name, String initializer){
		if(CommonTool.isEmptyString(modifier))
			modifier = "";
		else
			this.modifier = modifier;
		
		if(CommonTool.isEmptyString(type))
			this.type = "int";
		else
			this.type = type;
		
		if(CommonTool.isEmptyString(name))
			this.name = "missing"+System.currentTimeMillis();
		else
			this.name = name;
		
		this.initializer = initializer;
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		if(!CommonTool.isEmptyString(modifier))
			builder.append(modifier+" ");
		builder.append(type+" ");
		builder.append(name);
		if(!CommonTool.isEmptyString(initializer)){
			builder.append(" = ");
			builder.append(initializer);
		}
		builder.append(";");
		return builder.toString();
	}
}
