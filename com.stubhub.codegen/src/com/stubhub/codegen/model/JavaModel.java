package com.stubhub.codegen.model;

import java.util.*;

public class JavaModel {
	
	private List<String> importList;
	private String packageName;
	private ClassModel classModel;                 
	
	public JavaModel(String name){
		this.packageName = name;
		this.importList = new ArrayList<String>();
		this.classModel = null;
	}
	
	public List<String> getImportList(){
		return this.importList;
	}
	
	public String getPackageName(){
		return this.packageName;
	}
	
	public ClassModel getClassModel(){
		return this.classModel;
	}
	
	public void addImport(String name){
		this.importList.add(name);
	}
	
	public void addImport(String[] list){
		for(int i=0; i < list.length; i++){
			this.importList.add(list[i]);
		}
	}
	
	public void setClassModel(String name){
		this.classModel = new ClassModel(name);
	}
}
