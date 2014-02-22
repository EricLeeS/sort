package com.stubhub.codegen.generator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

import org.apache.commons.io.FileUtils;

import com.stubhub.codegen.constant.EnvironmentConstant;
import com.stubhub.codegen.format.CodeFormatUtil;
import com.stubhub.codegen.util.ConfigurationHelper;

import freemarker.template.TemplateException;

public abstract class Generator {
	protected String templateName;
	protected String outPath;
	protected Map data;
	protected String packageName;
	protected String className;

	public abstract Map generateData();

	public void generate() {
		generateData();
		if (data != null) {
			generate(this.templateName, this.outPath, this.data);
		}
	}
	
	public void setPackageName(String name){
		this.packageName = name;
	}
	
	public void setMainClassName(String name){
		this.className = name;
	}
	
	public void setOutPath(String path){
		this.outPath = path;
	}
	
	public void setTemplate(String template){
		this.templateName = template;
	}

	public void generate(String templateName, String outPath, Map data) {
		String outDir = outPath.substring(0, outPath.lastIndexOf("/"));
		try {
			FileUtils.forceMkdir(new File(outDir));
			ConfigurationHelper.setTemplate(templateName);
			File output = new File(outPath);
			Writer writer = new FileWriter(output);
			String content = ConfigurationHelper.generate(data);
			char[] formattedCode;
			if (EnvironmentConstant.isDebug) {
				formattedCode = content.toCharArray();
				System.out.println(content);
			} else {
				formattedCode = CodeFormatUtil.format(content).toCharArray();
				//String test = new String(formattedCode);
				//System.out.println(test);
			}
			writer.write(formattedCode);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
