package com.stubhub.codegen.fileparser;

import org.jsoup.Jsoup;

import com.stubhub.codegen.util.CommonTool;

public class RequestModel {
	public String name;
	public boolean required;
	public String ParameterType;
	public String type;
	public String desc;
	public String path;
	
	public void setParameterType(String para){
		if(Jsoup.parse("&nbsp;").text().equals(para))
			this.ParameterType = "";
		else
			this.ParameterType = para;
	}
	
	public void setType(String para){
		if(Jsoup.parse("&nbsp;").text().equals(para))
			this.type = "String";
		if("List".equals(type)){
			this.type = "List<"+CommonTool.UpperCase(this.name)+">";
		}
		else{
			this.type = para;
		}
	}
	
	public void setDesc(String para){
		if(Jsoup.parse("&nbsp;").text().equals(para))
			this.desc = "";
		else
			this.desc = para;
	}
}
