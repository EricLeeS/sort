package com.stubhub.codegen.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stubhub.codegen.constant.EnvironmentConstant;
import com.stubhub.codegen.fileparser.RequestModel;
import com.stubhub.codegen.generator.Generator;
import com.stubhub.codegen.model.AnnotationModel;
import com.stubhub.codegen.model.ClassModel;
import com.stubhub.codegen.model.FieldModel;
import com.stubhub.codegen.model.JavaDocModel;
import com.stubhub.codegen.model.JavaDocModel.TagElement;
import com.stubhub.codegen.model.JavaModel;
import com.stubhub.codegen.model.MethodModel;
import com.stubhub.codegen.model.PropertyModel;
import com.stubhub.codegen.model.AnnotationModel.AnnotationElement;
import com.stubhub.codegen.util.CommonTool;

public class ServiceTemplate extends Generator {
	private String[] importList ={"javax.ws.rs.Consumes","javax.ws.rs.GET",
			"javax.ws.rs.PUT","javax.ws.rs.Path","javax.ws.rs.PathParam",
			"javax.ws.rs.Produces","javax.ws.rs.QueryParam","javax.ws.rs.core.Context",
			"javax.ws.rs.core.MediaType"};
	private List<RequestModel> reqlist;
	private String type;
	
	public ServiceTemplate(String path, String packageName, String ClassName,String type){
		this.outPath = path;
		this.templateName = EnvironmentConstant.SERVICE_TEMPLATE;
		Map<String, Object> data = null;
		this.packageName = packageName;
		this.className = ClassName;
		this.type = type;
		this.reqlist = new ArrayList<RequestModel>();
	}
	
	public void addRequestModel(RequestModel req){
		this.reqlist.add(req);
	}
	
	@Override
	public Map generateData() {
		Map<String, Object> data = new HashMap<String,Object>();
		if(CommonTool.isEmptyString(packageName) || CommonTool.isEmptyString(className)){
			return null;
		}
		JavaModel model = new JavaModel(this.packageName);
		model.addImport(importList);
		model.setClassModel(this.className);
		ClassModel service = model.getClassModel();
		service.setIsInterface(true);
		//Annotation
		AnnotationModel classAnnotation = new AnnotationModel();
		AnnotationModel.AnnotationElement element = classAnnotation.new AnnotationElement("Path");
		element.addValue("\""+FindRequestModel("versionNumber").path+"\"");
		classAnnotation.addElement(element);
		element = classAnnotation.new AnnotationElement("Produces");
		element.addValue("{MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML}");
		classAnnotation.addElement(element);
		service.setAnnotation(classAnnotation);
		//Method
		for(RequestModel req : this.reqlist){
			if("versionNumber".equals(req.name))
				continue;
			MethodModel method = new MethodModel("public",this.type+"Response","get"+this.type,false);
			String anno = "";
			if("URL".equals(req.ParameterType)){
				anno = "@PathParam(value=\""+req.name+"\") ";
			}else{
				anno = "@QueryParam(value=\""+req.name+"\") ";
			}
			method.addArgument(anno+req.type, req.name);
			AnnotationModel methodAnnotation = new AnnotationModel();
			element = classAnnotation.new AnnotationElement("Get");
			methodAnnotation.addElement(element);
			element = classAnnotation.new AnnotationElement("Path");
			element.addValue("\""+req.path+"\"");
			methodAnnotation.addElement(element);
			method.setAnnotation(methodAnnotation);
			JavaDocModel javadoc = new JavaDocModel();
			if(!CommonTool.isEmptyString(req.desc)){
				javadoc.addText(req.desc);
			}
			TagElement tag = javadoc.new TagElement("param");
			tag.addText(req.name);
			javadoc.addTag(tag);
			tag = javadoc.new TagElement("return");
			tag.addText("@{code "+this.type+"Response"+"} instance");;
			javadoc.addTag(tag);
			method.setJavaDoc(javadoc);
			service.addMethod(method);
		}
		data.put("model", model);
		this.data = data;
		return data;
	}
	
	private RequestModel FindRequestModel(String name){
		for(RequestModel req : this.reqlist){
			if(req.name.equals(name))
				return req;
		}
		return null;
	}
}
