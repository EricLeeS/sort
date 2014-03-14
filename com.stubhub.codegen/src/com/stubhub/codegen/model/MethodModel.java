package com.stubhub.codegen.model;

import java.util.ArrayList;
import java.util.List;

import com.stubhub.codegen.util.CommonTool;

public class MethodModel extends ModifierModel {
	private String modifier;
	private String type;
	private String name;
	private List<ArgumentModel> arguList;
	private boolean hasBody;
	private List<String> stateList;
	
	public MethodModel(String modifier, String type, String name, boolean hasBody){
		if(CommonTool.isEmptyString(modifier))
			modifier = "public";
		else
			this.modifier = modifier;
		
		if(CommonTool.isEmptyString(type))
			this.type = "void";
		else
			this.type = type;
		
		if(CommonTool.isEmptyString(name))
			this.name = "missing"+System.currentTimeMillis();
		else
			this.name = name;
		
		arguList = new ArrayList<ArgumentModel>();
		stateList = new ArrayList<String>();
		hasBody = true;
	}
	
	public void setHasBody(boolean hasBody){
		this.hasBody = hasBody;
	}
	
	public void addStatement(String statement){
		this.stateList.add(statement);
	}
	
	public List<String> getStateList(){
		return this.stateList;
	}
	
	public void setModifier(String modifier){
		this.modifier = modifier;
	}
	
	public boolean getHasBody(){
		return this.hasBody;
	}
	
	public void addArgument(String type, String name){
		ArgumentModel argu = new ArgumentModel(type, name);
		this.arguList.add(argu);
	}
	
	public String getDeclaration(){
		StringBuilder builder = new StringBuilder();
		if(!CommonTool.isEmptyString(modifier))
			builder.append(modifier+" ");
		if(!CommonTool.isEmptyString(type)){
			builder.append(type+" ");
		}
		builder.append(name);
		builder.append("(");
		for(ArgumentModel argu : this.arguList){
			if(argu.getAnnotation()!=null && argu.getAnnotation().getList().size()>0)
				builder.append(argu.getAnnotation().getList().get(0).toString()+" ");
			builder.append(argu.getType()+" ");
			builder.append(argu.getName()+",");
		}
		if(this.arguList.size() >0 )
			builder.deleteCharAt(builder.lastIndexOf(","));
		builder.append(")");
		return builder.toString();
	}
}
