package com.stubhub.codegen.model;

public class ArgumentModel {
	private String type;
	private String name;
	private AnnotationModel annotation = null;
	
	public ArgumentModel(String type, String name){
		this.type = type;
		this.name = name;
	}
	
	public String getType(){
		return this.type;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setAnnotation(AnnotationModel model){
		this.annotation = model;
	}
	
	public AnnotationModel getAnnotation(){
		return this.annotation;
	}
}
