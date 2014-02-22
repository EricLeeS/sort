package com.stubhub.codegen.fileparser;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;

import com.stubhub.codegen.util.CommonTool;

public class ResponseModel {
	public String name;
	public String classname;
	public String type;
	public List<Property> proplist;
	public String desc;
	public boolean isFromRequest = false;
	public boolean isContainer = true;
	public boolean isChildOfContainer = true;
	
	public ResponseModel(String name, String type){
		this.name = CommonTool.LowerCase(name);
		this.classname = getClassName(name,type);
		if("List".equals(type)){
			this.type = "List<"+this.classname+">";
		}
		else{
			this.type = type;
		}
		proplist = new ArrayList<Property>();
	}
	
	public List<Property> getPropertyList(){
		return this.proplist;
	}
	
	public void setDesc(String para){
		if(Jsoup.parse("&nbsp;").text().equals(para))
			this.desc = "";
		else
			this.desc = para;
	}
	
	public class Property{
		public String name;
		public String childOf;
		public String type;
		public String desc;
		public boolean required;
		
		public Property(String name,String childOf, String type){
			this.name = CommonTool.LowerCase(name);
			this.childOf = childOf;
			this.type = type;
		}
		
		public void setDesc(String para){
			if(Jsoup.parse("&nbsp;").text().equals(para))
				this.desc = "";
			else
				this.desc = para;
		}
	}
	
	
	public void add(Property prop){
		this.proplist.add(prop);
	}
	
	private String getClassName(String name,String type){
		String upper = CommonTool.UpperCase(name);
		if("List".equals(type)){
			if(upper.endsWith("s"))
				return upper.substring(0,upper.lastIndexOf("s"));
		}
		return upper;
	}
}
