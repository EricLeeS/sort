package com.demo.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FRGenerate {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		//get the instance of confirguation of freemarker
		Configuration cfg = new Configuration();
		//set the template loading directory
		cfg.setDirectoryForTemplateLoading(new File("template"));
		//set the template
		Template template = cfg.getTemplate("test.ftl");
		//data model
		Map root = new HashMap();		
		root.put("packageName", "com.stubhub.code;");
		List importList = new ArrayList();
		importList.add("java.io.File");
		importList.add("java.util.*");	
		root.put("importList",importList);
		
		Map MainClass = new HashMap();
		
		MainClass.put("className", "test");
		MainClass.put("superClass", "astexplore");
		Map field = new HashMap();
		field.put("type", "private int");
		field.put("name", "id");
		field.put("value", "10");
		
		
		MainClass.put("field", field);
		root.put("class",MainClass);
		
		Writer writer = new StringWriter();
		try {
			//combine the data model and the template , then output to writer
			
			template.process(root, writer);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.flush();
		System.out.println(writer.toString());
		
	}
}
