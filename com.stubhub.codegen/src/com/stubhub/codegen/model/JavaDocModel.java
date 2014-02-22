package com.stubhub.codegen.model;

import java.util.ArrayList;
import java.util.List;


public class JavaDocModel {
	private List<String> textlist;
	private List<TagElement> taglist;
	
	public JavaDocModel(){
		textlist = new ArrayList<String>();
		taglist = new ArrayList<TagElement>();
	}
	
	public void addText(String text){
		this.textlist.add(text);
	}
	
	public void addTag(TagElement tag){
		this.taglist.add(tag);
	}
	
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("/**\r\n");
		for(String text : textlist){
			builder.append(" * ");
			builder.append(text);
			builder.append("\r\n");
		}
		for(TagElement tag : taglist){
			builder.append(" * ");
			builder.append("@"+tag.tagName);
			builder.append(" ");
			int count=0;
			for(String text : tag.textlist){
				if(count>0)
					builder.append(" * ");
				builder.append(text);
				builder.append("\r\n");
				count++;
			}
			if(count == 0)
				builder.append("\r\n");
		}
		builder.append(" */");
		return builder.toString();
	}
	
	public class TagElement{
		private List<String> textlist;
		private String tagName;
		
		public TagElement(String tagname){
			this.tagName = tagname;
			textlist = new ArrayList<String>();
		}
		
		public void addText(String text){
			this.textlist.add(text);
		}
		
	}
}
