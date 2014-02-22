package com.stubhub.codegen.util;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.Locale;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class ConfigurationHelper {
	private static Configuration config = null;
	private static Template template = null;
	
	private ConfigurationHelper(){
	}
	
	public static Configuration getInstance(){
		if(config == null){
			config = new Configuration();
		}
		return config;
	}
	
	public static void setTemplateDir(String templateDir) throws IOException{
		File root = new File(templateDir);
		Configuration cfg = getInstance();
		cfg.setDirectoryForTemplateLoading(root);
		cfg.setLocale(Locale.CHINA);
		cfg.setDefaultEncoding("UTF-8");
		cfg.setObjectWrapper(new DefaultObjectWrapper());
	}
	
	public static void setTemplate(String name) throws IOException{
		Configuration cfg = getInstance();
		template = cfg.getTemplate(name);
	}
	
	public static String generate(Map root) throws IOException,TemplateException{
		Writer writer = new StringWriter();
		template.process(root, writer);
		writer.flush();
		return writer.toString();
	}
}