package com.stubhub.codegen.model;

import java.util.ArrayList;
import java.util.List;

public class AnnotationModel {
	private List<AnnotationElement> list;
	
	public AnnotationModel(){
		this.list = new ArrayList<AnnotationElement>();
	}
	
	public void addElement(AnnotationElement element){
		this.list.add(element);
	}
	
	public List<AnnotationElement> getList(){
		return this.list;
	}
	
	public String toString(){
		StringBuilder builder =new StringBuilder();
		int count =0;
		for(AnnotationElement element : list){
			builder.append(element.toString());
			count++;
			if(count != list.size())
				builder.append("\r\n");
		}
		return builder.toString();
	}
	
	public class AnnotationElement{
		private String typeName;
		private List<String> valueList;
		
		public AnnotationElement(String typename){
			this.typeName = typename;
			valueList = new ArrayList<String>();
		}
		
		public void addValue(String value){
			this.valueList.add(value);
		}
		
	    public String toString(){
	    	StringBuilder builder = new StringBuilder();
	    	builder.append("@");
	    	builder.append(this.typeName);
	    	if(this.valueList.size() > 0){
				builder.append("(");
				for(String value : this.valueList){
					builder.append(value);
					builder.append(",");
				}
				builder.deleteCharAt(builder.lastIndexOf(","));
				builder.append(")");
	    	}
	    	return builder.toString();
	    }
	}
}
