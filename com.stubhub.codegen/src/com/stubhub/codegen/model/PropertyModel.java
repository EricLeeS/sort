package com.stubhub.codegen.model;

public class PropertyModel {
	private String name;
	private String className;
	private String type;
	private String desc;
	private boolean isContainer  = true;
	private boolean required = true;
	
	public PropertyModel(String name, String className, String type){
		this.name = name;
		this.className = className;
		this.type = type;
		this.desc = "";
	}
	
	public PropertyModel(String name, String className, String type, boolean isContainer){
		this.name = name;
		this.className = className;
		this.type = type;
		this.desc = "";
		this.isContainer = isContainer;
	}
	
	public boolean isContainer(){
		return this.isContainer;
	}
	
	public void setRequired(boolean required){
		this.required = required;
	}
	
	public boolean getRequired(){
		return this.required;
	}
	
	public void setDesc(String desc){
		this.desc = desc;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setClassName(String name){
		this.className = name;
	}
	
	public String getClassName(){
		return this.className;
	}
	
	public void setType(String type){
		this.type = name;
	}
	
	public String getType(){
		return this.type;
	}
}
