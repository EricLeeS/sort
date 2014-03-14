package com.stubhub.codegen.template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.stubhub.codegen.constant.EnvironmentConstant;
import com.stubhub.codegen.generator.Generator;
import com.stubhub.codegen.model.AnnotationModel;
import com.stubhub.codegen.model.ClassModel;
import com.stubhub.codegen.model.FieldModel;
import com.stubhub.codegen.model.JavaDocModel;
import com.stubhub.codegen.model.JavaModel;
import com.stubhub.codegen.model.MethodModel;
import com.stubhub.codegen.model.PropertyModel;
import com.stubhub.codegen.model.AnnotationModel.AnnotationElement;
import com.stubhub.codegen.util.CommonTool;

public class EntityTemplate extends Generator {

	private String[] importList ={"java.util.List","javax.xml.bind.annotation.XmlAccessType",
			"javax.xml.bind.annotation.XmlAccessorType","javax.xml.bind.annotation.XmlElement",
			"javax.xml.bind.annotation.XmlRootElement","javax.xml.bind.annotation.XmlType"};
	private List<PropertyModel> propList;
	
	public EntityTemplate(String path, String packageName, String ClassName){
		this.outPath = path;
		this.templateName = EnvironmentConstant.RESPONSE_TEMPLATE;
		Map<String, Object> data = null;
		this.packageName = packageName;
		this.className = ClassName;
		this.propList = new ArrayList<PropertyModel>();
	}
	
	public void addProperty(PropertyModel prop){
		this.propList.add(prop);
	}
	
	private String getPropertyString(){
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		for(PropertyModel model : propList){
			builder.append("\""+model.getName()+"\"");
			builder.append(",");
		}
		if(propList.size() > 0)
			builder.deleteCharAt(builder.lastIndexOf(","));
		builder.append("}");
		return builder.toString();
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
		ClassModel response = model.getClassModel();
		//Annotation
		AnnotationModel classAnnotation = new AnnotationModel();
		AnnotationModel.AnnotationElement element = classAnnotation.new AnnotationElement("XmlAccessorType");
		element.addValue("XmlAccessType.FIELD");
		classAnnotation.addElement(element);
		element = classAnnotation.new AnnotationElement("XmlRootElement");
		element.addValue("name = \""+this.className+"\"");
		classAnnotation.addElement(element);
		element = classAnnotation.new AnnotationElement("XmlType");
		element.addValue("name = \""+this.className+"\"");
		element.addValue("propOrder = "+ getPropertyString() +"");
		classAnnotation.addElement(element);
		response.setAnnotation(classAnnotation);
		//Field
		for(PropertyModel prop : this.propList){
			FieldModel field = new FieldModel("private", prop.getType(), prop.getName(), null);
			AnnotationModel fieldAnnotation = new AnnotationModel();
			element = classAnnotation.new AnnotationElement("XmlElement");
			element.addValue("name = \""+prop.getName()+"\"");
			if(prop.getRequired())
				element.addValue("required = true");
			else
				element.addValue("required = false");
			fieldAnnotation.addElement(element);
			field.setAnnotation(fieldAnnotation);
			if(!CommonTool.isEmptyString(prop.getDesc())){
				JavaDocModel javadoc = new JavaDocModel();
				javadoc.addText(prop.getDesc());
				field.setJavaDoc(javadoc);
			}	
			response.addField(field);
			//getter
			MethodModel method = new MethodModel("public", prop.getType(),"get"+CommonTool.UpperCase(prop.getName()),false);
			method.addStatement("return "+prop.getName()+";");
			response.addMethod(method);
			//setter
			method = new MethodModel("public", "void", "set"+CommonTool.UpperCase(prop.getName()),false);
			method.addArgument(prop.getType(), prop.getName());
			method.addStatement(String.format("this.%1$s = %1$s;", prop.getName()));
			response.addMethod(method);
		}
		data.put("model", model);
		this.data = data;
		return data;
	}
	
}
