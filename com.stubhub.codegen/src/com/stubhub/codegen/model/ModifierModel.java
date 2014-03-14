package com.stubhub.codegen.model;

public abstract class ModifierModel {
	protected JavaDocModel javaDoc = null;
	protected AnnotationModel annotation = null;
	
	public void setJavaDoc(JavaDocModel model){
		this.javaDoc = model;
	}
	
	public JavaDocModel getJavaDoc(){
		return this.javaDoc;
	}
	
	public void setAnnotation(AnnotationModel model){
		this.annotation = model;
	}
	
	public AnnotationModel getAnnotation(){
		return this.annotation;
	}
}
