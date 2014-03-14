package com.stubhub.codegen.fileparser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.*;
import javax.xml.xpath.*;

import org.w3c.dom.*;
import org.xml.sax.SAXException;
import org.jsoup.Jsoup;
import org.jsoup.parser.*;
import org.jsoup.select.Elements;

import com.stubhub.codegen.constant.EnvironmentConstant;
import com.stubhub.codegen.fileparser.ResponseModel.Property;
import com.stubhub.codegen.model.PropertyModel;
import com.stubhub.codegen.template.*;
import com.stubhub.codegen.tree.model.treeMember;
import com.stubhub.codegen.tree.model.treeParent;
import com.stubhub.codegen.util.CommonTool;
import com.stubhub.codegen.util.ConfigurationHelper;
import com.stubhub.codegen.util.constantHelper;

public class FileParser {
	private Document doc;
	private List<RequestModel> requestList;
	private List<ResponseModel> responseList;
	private String packagePrefix;
	private String packagePath;
	private boolean isAnalysed = false;
	private String className = "";
	private String rclassName = "";
	private List<String> errorList;
	private List<String> warnList;
	private Map<String, Integer> reqTitleMap;
	private Map<String, Integer> resTitleMap;
	private Map<String, ResponseModel> classMap;
	//private List<treeParent> treeList;
	

	public FileParser() {
		init();

		
	}

	public List<String> getErrorList() {
		return this.errorList;
	}

	public List<String> getWarnList() {
		return this.warnList;
	}

//	public void setIsContainerChid(treeMember treeParent,List<Property> propertyList){
//		for(Property property : propertyList){
//			if()
//		}
//	}
//	
//	public List<treeParent> getTreeList(){
//		treeParent responseParent = new treeParent();
//		responseParent.setName("response");
//		List<treeMember> responseChildList = new ArrayList<treeMember>();
//		responseParent.setChildren(responseChildList);
//		for(ResponseModel responseModel : responseList){
//			if(responseModel.isFromRequest){
//				continue;
//			}else if(responseModel.isChildOfContainer){
//				if(responseModel.isContainer){
//					treeMember treeMemberTemp = new treeMember();
//					treeMemberTemp.setName(responseModel.name);
//					treeMemberTemp.setParent("response");
//					responseChildList.add(treeMemberTemp);
//					List<Property> propertyList = responseModel.getPropertyList();
//					
//				}else{
//					treeMember treeMemberTemp = new treeMember();
//					treeMemberTemp.setName(responseModel.name);
//					treeMemberTemp.setParent("response");
//					responseChildList.add(treeMemberTemp);
//				}
//			}
//		}
//		
//		return this.treeList;
//		
//	}
	private boolean verifyType(String type) {
		String ltype = type.toLowerCase();
		boolean isBaseType = false;
		boolean isCollectionType = false;
		if ("char".equals(ltype) || "int".equals(type) || "short".equals(type) || "byte".equals(ltype) || "long".equals(ltype) || "float".equals(ltype) || "double".equals(ltype)
				|| "boolean".equals(ltype) || "string".equals(ltype)) {
			isBaseType = true;
		}
		if (ltype.contains("list") || ltype.contains("map") || ltype.contains("set") || ltype.contains("container")) {
			isCollectionType = true;
		}
		if (isBaseType || isCollectionType)
			return true;
		else
			return false;
	}

	private void init() {
		requestList = new ArrayList<RequestModel>();
		responseList = new ArrayList<ResponseModel>();
		errorList = new ArrayList<String>();
		warnList = new ArrayList<String>();
		reqTitleMap = new HashMap<String, Integer>();
		resTitleMap = new HashMap<String, Integer>();
		isAnalysed = true;
		this.className = "";
		this.rclassName = "";
		classMap = new HashMap<String, ResponseModel>();
		//treeList = new ArrayList<treeParent>();
	}

	// version 2
	@SuppressWarnings("unused")
	public boolean analyse2() {
		init();
//		Element root = doc.getDocumentElement();
//		// package prefix
//		Element prefix = (Element) selectSingleNode("/map/package", root);
//		packagePrefix = prefix.getTextContent();
		//get the source package
		packagePrefix=constantHelper.getPackageName();
		// request
//		Element request = (Element) selectSingleNode("/map/request", root);
		//String reqtable = request.getTextContent().trim();
		String reqtable = constantHelper.getRequestText();
		
		
		
		String restableTemp = constantHelper.getResponseText();
		
		
		if((reqtable==null)||(reqtable.trim().equals(""))){
			errorList.add("@Error: table 'Request' is null");
		}else if((restableTemp==null)||(restableTemp.trim().equals(""))){
			errorList.add("@Error: table 'Response' is null");
		}else{
			org.jsoup.nodes.Document htmldoc = Jsoup.parse(reqtable);
			Elements trElement = htmldoc.getElementsByTag("tr");
			//init the hasTitle
			boolean hasTitle = false;
			//set the init tile index
			reqTitleMap.put("column", -1);
			reqTitleMap.put("xpath", -1);
			reqTitleMap.put("required", -1);
			reqTitleMap.put("type", -1);
			reqTitleMap.put("description", -1);
			reqTitleMap.put("maxallowed", -1);
			if (trElement.size() > 0) {
				Elements thElement = trElement.get(0).getElementsByTag("th");
				if (thElement.size() == 0)
					errorList.add("@Error: titles of table 'Request' are missing.");
				//set the index of the th column
				for (int col = 0; col < thElement.size(); col++) {
					String title = thElement.get(col).text().trim().toLowerCase();
					if (reqTitleMap.containsKey(title)) {
						reqTitleMap.put(title, col);
					}
				}
				//set the hasTitle true
				hasTitle = true;
				// verify the index to see whether it exists
				if (reqTitleMap.get("column") == -1) {
					errorList.add("@Error: title 'Column' of table 'Request' is missing.");
					hasTitle = false;
				}
				if (reqTitleMap.get("xpath") == -1) {
					errorList.add("@Error: title 'XPath' of table 'Request' is missing.");
					hasTitle = false;
				}
				if (reqTitleMap.get("required") == -1) {
					errorList.add("@Error: title 'Required' of table 'Request' is missing.");
					hasTitle = false;
				}
				if (reqTitleMap.get("type") == -1) {
					errorList.add("@Error: title 'Type' of table 'Request' is missing.");
					hasTitle = false;
				}
				if (reqTitleMap.get("description") == -1) {
					errorList.add("@Error: title 'Description' of table 'Request' is missing.");
					hasTitle = false;
				}
				if (reqTitleMap.get("maxallowed") == -1) {
					errorList.add("@Error: title 'MaxAllowed' of table 'Request' is missing.");
					hasTitle = false;
				}
			}
			if (hasTitle) {
				
				RequestModel version = new RequestModel();
				version.name = "versionNumber";
				requestList.add(version);
				//foreach the tr row from 1
				for (int row = 1; row < trElement.size(); row++) {
					// td
					Elements tdElement = trElement.get(row).getElementsByTag("td");
					if (tdElement.size() == 0)
						continue;
					if (Jsoup.parse("&nbsp;").text().equals(tdElement.get(0).text().trim()))
						continue;
					//if the request class name is null
					if (this.className == "") {
						if ("Container".equals(tdElement.get(reqTitleMap.get("type")).text().trim()) && "".equals(getContainer(tdElement.get(reqTitleMap.get("xpath")).text().trim()))) {
							this.className = tdElement.get(reqTitleMap.get("column")).text().trim();
							
						}
					} else {
						//if the type is container, it will be JavaBean 
						if ("Container".equals(tdElement.get(reqTitleMap.get("type")).text().trim())) {
							String nametemp = filterHtml(tdElement.get(reqTitleMap.get("column")).text().trim());
							String maxallowed = tdElement.get(reqTitleMap.get("maxallowed")).text().trim();
							String typetemp = "";
							//if the maxAllowed is 1 , the type will be set List
							if ("1".equals(maxallowed))
								typetemp = CommonTool.UpperCase(tdElement.get(reqTitleMap.get("column")).text().trim());
							else
								typetemp = "List";
							//use the responseMode to generate JavaBean
							ResponseModel resModel = new ResponseModel(nametemp, typetemp);
							//set the isFromRequest true 
							resModel.isFromRequest = true;
							resModel.setDesc(tdElement.get(reqTitleMap.get("description")).text().trim());
							responseList.add(resModel);
							//add the responseMap to the clallMap
							classMap.put(tdElement.get(reqTitleMap.get("column")).text().trim(), resModel);
							
							ResponseModel parent = getParent(getContainer(tdElement.get(reqTitleMap.get("xpath")).text().trim()));
							//if the parent of the container is not null
							if (parent != null) {
								String childtemp = tdElement.get(reqTitleMap.get("xpath")).text().trim();
								Property proModel = resModel.new Property(nametemp, childtemp, typetemp);
								proModel.setDesc(tdElement.get(reqTitleMap.get("description")).text().trim());
								if ("Y".equals(tdElement.get(reqTitleMap.get("required")).text().trim()))
									proModel.required = true;
								else
									proModel.required = false;
								parent.add(proModel);
							} 
							//if the parent of the container is the main class 
							else if (this.className.equals(getContainer(tdElement.get(reqTitleMap.get("xpath")).text().trim()))) {
								RequestModel reqModel = new RequestModel();
								reqModel.name = CommonTool.LowerCase(tdElement.get(reqTitleMap.get("column")).text().trim());
								if ("Y".equals(tdElement.get(reqTitleMap.get("required")).text().trim()))
									reqModel.required = true;
								else
									reqModel.required = false;
								reqModel.setType(typetemp);
								reqModel.setDesc(tdElement.get(reqTitleMap.get("description")).text().trim());
								requestList.add(reqModel);
							}
						} 
						//if the type of the "td" is not container
						else {
							//if the parent of the "td" is the main class
							if (this.className.equals(getContainer(tdElement.get(reqTitleMap.get("xpath")).text().trim()))) {
								RequestModel reqModel = new RequestModel();
								reqModel.name = CommonTool.LowerCase(tdElement.get(reqTitleMap.get("column")).text().trim());
								if ("Y".equals(tdElement.get(reqTitleMap.get("required")).text().trim()))
									reqModel.required = true;
								else
									reqModel.required = false;
								String typetemp = tdElement.get(reqTitleMap.get("type")).text().trim();
								if (!verifyType(typetemp))
									warnList.add(String.format("@warning: '%2$s' may not be the right type of '%1$s' in table 'Request'", reqModel.name, typetemp));
								reqModel.setType(typetemp);
								reqModel.setDesc(tdElement.get(reqTitleMap.get("description")).text().trim());
								requestList.add(reqModel);
							} else {
								ResponseModel resModel = getParent(getContainer(tdElement.get(reqTitleMap.get("xpath")).text().trim()));
								if (resModel != null) {
									String nametemp = filterHtml(tdElement.get(reqTitleMap.get("column")).text().trim());
									String typetemp = tdElement.get(reqTitleMap.get("type")).text().trim();
									if (!verifyType(typetemp))
										warnList.add(String.format("@warning: '%2$s' may not be the right type of '%1$s' in table 'Response'", nametemp, typetemp));
									String childtemp = tdElement.get(reqTitleMap.get("xpath")).text().trim();
									Property proModel = resModel.new Property(nametemp, childtemp, typetemp);
									proModel.setDesc(tdElement.get(reqTitleMap.get("description")).text().trim());
									resModel.add(proModel);
								} else {
									errorList.add(String.format("@warning: '%1$s' lacks Container in table 'Request'", tdElement.get(reqTitleMap.get("column")).text().trim()));
								}
							}
						}
					}
				}
			}

			// url
			if (hasTitle) {
//				NodeList urlList = selectNodes("/map/urls/url", root);
				List urlList = constantHelper.getUrlList();
				boolean isSetPackage = false;
				for (int i = 0; i < urlList.size(); i++) {
//					Element urlElement = (Element) urlList.item(i);
//					String url = urlElement.getTextContent().trim();
					String url =urlList.get(i).toString().trim();
					String[] item = url.replace("https://", "").split("/");
					String path = "";
					for (int j = 1; j < item.length; j++) {
						path += "/" + item[j];
						if (item[j].matches("^v[0-9]+")) {
							if (!isSetPackage) {
								packagePath = packagePrefix + path.replace("/", ".");
								//className = item[j + 1];
								isSetPackage = true;
								RequestModel reqtemp = FindRequestModel("versionNumber");
								reqtemp.path = "/" + item[j];
							}
							path = "";
						}
						if (j == item.length - 1) {
							String name = "";
							RequestModel reqtemp;
							if (item[j].startsWith("?")) {
								name = item[j].substring(1, item[j].indexOf("="));
								if ((reqtemp = FindRequestModel(name)) != null) {
									reqtemp.path = path.substring(0, path.lastIndexOf("/"));
									reqtemp.setParameterType("query");
								}
							} else {
								name = item[j].substring(1, item[j].indexOf("}"));
								if ((reqtemp = FindRequestModel(name)) != null) {
									reqtemp.path = path;
									reqtemp.setParameterType("URL");
								} else {
									reqtemp.path = "/";
								}
							}
						}
					}
				}
			}

			// response
//			Element response = (Element) selectSingleNode("/map/response", root);
//			String restable = response.getTextContent().trim();
			String restable = constantHelper.getResponseText();
			htmldoc = Jsoup.parse(restable);
			trElement = htmldoc.getElementsByTag("tr");
			ResponseModel resModel = null;
			hasTitle = false;
			resTitleMap.put("column", -1);
			resTitleMap.put("xpath", -1);
			resTitleMap.put("required", -1);
			resTitleMap.put("type", -1);
			resTitleMap.put("description", -1);
			resTitleMap.put("maxallowed", -1);
			if (trElement.size() > 0) {
				Elements thElement = trElement.get(0).getElementsByTag("th");
				if (thElement.size() == 0)
					errorList.add("@Error: titles of table 'Response' are missing.");
				for (int col = 0; col < thElement.size(); col++) {
					String title = thElement.get(col).text().trim().toLowerCase();
					if (resTitleMap.containsKey(title)) {
						resTitleMap.put(title, col);
					}
				}
				hasTitle = true;
				// verify
				if (resTitleMap.get("column") == -1) {
					errorList.add("@Error: title 'Column' of table 'Response' is missing.");
					hasTitle = false;
				}
				if (resTitleMap.get("xpath") == -1) {
					errorList.add("@Error: title 'XPath' of table 'Response' is missing.");
					hasTitle = false;
				}
				if (resTitleMap.get("required") == -1) {
					errorList.add("@Error: title 'Required' of table 'Response' is missing.");
					hasTitle = false;
				}
				if (resTitleMap.get("type") == -1) {
					errorList.add("@Error: title 'Type' of table 'Response' is missing.");
					hasTitle = false;
				}
				if (resTitleMap.get("description") == -1) {
					errorList.add("@Error: title 'Description' of table 'Response' is missing.");
					hasTitle = false;
				}
				if (resTitleMap.get("maxallowed") == -1) {
					errorList.add("@Error: title 'MaxAllowed' of table 'Response' is missing.");
					hasTitle = false;
				}
			}
			if (hasTitle) {
				for (int row = 0; row < trElement.size(); row++) {
					Elements tdElement = trElement.get(row).getElementsByTag("td");
					if (tdElement.size() == 0)
						continue;
					if (Jsoup.parse("&nbsp;").text().equals(tdElement.get(resTitleMap.get("column")).text().trim()))
						continue;

					String nametemp = filterHtml(tdElement.get(resTitleMap.get("column")).text().trim());
					String typetemp = tdElement.get(resTitleMap.get("type")).text().trim();
					if (!verifyType(typetemp))
						warnList.add(String.format("@warning: '%2$s' may not be the right type of '%1$s' in table 'Response'", nametemp, typetemp));

					if (this.rclassName == "") {
						if ("Container".equals(tdElement.get(resTitleMap.get("type")).text().trim()) && "".equals(getContainer(tdElement.get(resTitleMap.get("xpath")).text().trim()))) {
							this.rclassName = tdElement.get(resTitleMap.get("column")).text().trim();
						}
					} else {
						//if the type is container
						if ("Container".equals(tdElement.get(resTitleMap.get("type")).text().trim())) {
							String maxallowed = tdElement.get(resTitleMap.get("maxallowed")).text().trim();
							if ("1".equals(maxallowed))
								typetemp = CommonTool.UpperCase(tdElement.get(resTitleMap.get("column")).text().trim());
							else
								typetemp = "List";

							resModel = new ResponseModel(nametemp, typetemp);
							resModel.setDesc(tdElement.get(resTitleMap.get("description")).text().trim());
							responseList.add(resModel);
							classMap.put(tdElement.get(resTitleMap.get("column")).text().trim(), resModel);
							//the container is not in the main class
							if(this.rclassName.equals(getContainer(tdElement.get(resTitleMap.get("xpath")).text().trim())))
									resModel.isChildOfContainer = false;
							
							if (!"".equals(getContainer(tdElement.get(resTitleMap.get("xpath")).text().trim()))) {
								ResponseModel parent = getParent(getContainer(tdElement.get(resTitleMap.get("xpath")).text().trim()));
								if (parent != null) {
									String childtemp = tdElement.get(resTitleMap.get("xpath")).text().trim();
									Property proModel = resModel.new Property(nametemp, childtemp, typetemp);
									proModel.setDesc(tdElement.get(resTitleMap.get("description")).text().trim());
									parent.add(proModel);
								} 
							}
						} 
						//if the type is not container 
						else {
							ResponseModel parent = getParent(getContainer(tdElement.get(resTitleMap.get("xpath")).text().trim()));
							if (parent != null) {
								String childtemp = tdElement.get(resTitleMap.get("xpath")).text().trim();
								Property proModel = resModel.new Property(nametemp, childtemp, typetemp);
								proModel.setDesc(tdElement.get(resTitleMap.get("description")).text().trim());
								if ("Y".equals(tdElement.get(resTitleMap.get("required")).text().trim()))
									proModel.required = true;
								else
									proModel.required = false;
								parent.add(proModel);
							} 
							//if the parent is main class
							else if ("".equals(getContainer(tdElement.get(resTitleMap.get("xpath")).text().trim()))) {
								resModel = new ResponseModel(nametemp, typetemp);
								resModel.setDesc(tdElement.get(resTitleMap.get("description")).text().trim());
								resModel.isContainer = false;
								responseList.add(resModel);

							} else {
								errorList.add(String.format("@warning: '%1$s' lacks Container in table 'Response'", nametemp));
							}
						}
					}
				}
			}

		}
		
		if (errorList.size() > 0)
			isAnalysed = false;
		else
			isAnalysed = true;
		return isAnalysed;
	}

	/*
	 * convert the parent to the ResponseModel
	 */
	private ResponseModel getParent(String name) {
		if (classMap.containsKey(name))
			return classMap.get(name);
		else
			return null;
	}
	/*
	 * split the XPath such as /parent/child
	 * return the parent or ""
	 */
	private String getContainer(String path) {
		String[] pathSplit = path.split("/");
		int length = pathSplit.length;
		if (length >= 2)
			return pathSplit[length - 2];
		else
			return "";
	}

	public void generateCode() {
		if (!isAnalysed)
			return;
		try {
			ConfigurationHelper.setTemplateDir(EnvironmentConstant.TEMPLATE_DIR);
			generateResponseTemplate();
			for (ResponseModel response : this.responseList) {
				if (response.isContainer)
					generateEntityTemplate(response);
			}
			generateServiceTemplate();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void generateServiceTemplate() {
		String packageName = this.packagePath + ".intf";
		String outPath = packageName.replace(".", "/");
		String className = CommonTool.UpperCase(this.className);
		if (!className.endsWith("Service"))
			className += "Service";
		String classFile = className + ".java";
		String outputFile = EnvironmentConstant.OUTPUT_DIR + "/" + outPath + "/" + classFile;
		ServiceTemplate template = new ServiceTemplate(outputFile, packageName, className, CommonTool.UpperCase(this.className));
		for (RequestModel req : this.requestList) {
			template.addRequestModel(req);
		}
		template.generate();
	}

	private void generateResponseTemplate() {
		String packageName = this.packagePath + ".intf";
		String outPath = packageName.replace(".", "/");
		String className = CommonTool.UpperCase(this.rclassName);
		if (!className.endsWith("Response"))
			className += "Response";
		String classFile = className + ".java";
		String outputFile = EnvironmentConstant.OUTPUT_DIR + "/" + outPath + "/" + classFile;
		ResponseTemplate template = new ResponseTemplate(outputFile, packageName, className);
		for (ResponseModel res : responseList) {
			if (res.isFromRequest || res.isChildOfContainer)
				continue;
			PropertyModel property;
			if (res.isContainer)
				property = new PropertyModel(res.name, res.classname, res.type);
			else
				property = new PropertyModel(res.name, res.classname, res.type, false);
			property.setDesc(res.desc);
			template.addProperty(property);
		}
		template.generate();
	}

	private void generateEntityTemplate(ResponseModel response) {
		String packageName = this.packagePath + ".intf";
		String outPath = packageName.replace(".", "/");
		String classFile = response.classname + ".java";
		String outputFile = EnvironmentConstant.OUTPUT_DIR + "/" + outPath + "/" + classFile;
		EntityTemplate template = new EntityTemplate(outputFile, packageName, response.classname);
		for (Property prop : response.proplist) {
			PropertyModel property = new PropertyModel(prop.name, prop.name, prop.type);
			property.setRequired(prop.required);
			property.setDesc(prop.desc);
			template.addProperty(property);
		}
		template.generate();
	}

	// private String getServiceName(String name) {
	// char[] arr = name.toCharArray();
	// for (int i = 1; i < arr.length; i++) {
	// if (arr[i] >= 'A' && arr[i] <= 'Z') {
	// return name.substring(0, i);
	// }
	// }
	// return name;
	// }

	private String filterHtml(String html) {
		if (html.contains("<span>"))
			return html.substring(html.indexOf("<span>"), html.indexOf("</span>"));
		if (html.contains("<p>"))
			return html.substring(html.indexOf("<p>"), html.indexOf("</p>"));
		return html;
	}

	private RequestModel FindRequestModel(String name) {
		for (RequestModel req : requestList) {
			if (req.name.equals(name))
				return req;
		}
		return null;
	}

	private Node selectSingleNode(String express, Object source) {
		Node result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (Node) xpath.evaluate(express, source, XPathConstants.NODE);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}

	private NodeList selectNodes(String express, Object source) {
		NodeList result = null;
		XPathFactory xpathFactory = XPathFactory.newInstance();
		XPath xpath = xpathFactory.newXPath();
		try {
			result = (NodeList) xpath.evaluate(express, source, XPathConstants.NODESET);
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return result;
	}

	// // version 1
	// public boolean analyse() {
	// init();
	// Element root = doc.getDocumentElement(); // package prefix
	// Element prefix = (Element) selectSingleNode("/map/package", root);
	// packagePrefix = prefix.getTextContent();
	// // request
	// Element request = (Element) selectSingleNode("/map/request", root);
	// String reqtable = request.getTextContent().trim();
	// org.jsoup.nodes.Document htmldoc = Jsoup.parse(reqtable);
	// Elements trElement = htmldoc.getElementsByTag("tr");
	// boolean hasTitle = false;
	// reqTitleMap.put("parameter", -1);
	// reqTitleMap.put("required?", -1);
	// reqTitleMap.put("parameter type", -1);
	// reqTitleMap.put("type", -1);
	// reqTitleMap.put("description", -1);
	// if (trElement.size() > 0) {
	// Elements thElement = trElement.get(0).getElementsByTag("th");
	// if (thElement.size() == 0)
	// errorList.add("@Error: titles of table 'Request' are missing.");
	// for (int col = 0; col < thElement.size(); col++) {
	// String title = thElement.get(col).text().trim().toLowerCase();
	// if (reqTitleMap.containsKey(title)) {
	// reqTitleMap.put(title, col);
	// }
	// }
	// hasTitle = true;
	// // verify
	// if (reqTitleMap.get("parameter") == -1) {
	// errorList.add("@Error: title 'Parameter' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (reqTitleMap.get("required?") == -1) {
	// errorList.add("@Error: title 'Required?' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (reqTitleMap.get("parameter type") == -1) {
	// errorList.add("@Error: title 'Parameter Type' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (reqTitleMap.get("type") == -1) {
	// errorList.add("@Error: title 'Type' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (reqTitleMap.get("description") == -1) {
	// errorList.add("@Error: title 'Description' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// }
	// if (hasTitle) {
	// for (int row = 1; row < trElement.size(); row++) {
	// // td
	// Elements tdElement = trElement.get(row).getElementsByTag("td");
	// if (tdElement.size() == 0)
	// continue;
	// if (Jsoup.parse("&nbsp;").text().equals(tdElement.get(0).text().trim()))
	// continue;
	// RequestModel reqModel = new RequestModel();
	// reqModel.name =
	// tdElement.get(reqTitleMap.get("parameter")).text().trim();
	// if
	// ("Y".equals(tdElement.get(reqTitleMap.get("required?")).text().trim()))
	// reqModel.required = true;
	// else
	// reqModel.required = false;
	// reqModel.setParameterType(tdElement.get(reqTitleMap.get("parameter type")).text().trim());
	// String typetemp = tdElement.get(reqTitleMap.get("type")).text().trim();
	// if (!verifyType(typetemp))
	// warnList.add(String.format("@warning: '%2$s' may not be the right type of '%1$s' in table 'Request'",
	// reqModel.name, typetemp));
	// reqModel.setType(typetemp);
	// reqModel.setDesc(tdElement.get(reqTitleMap.get("description")).text().trim());
	// requestList.add(reqModel);
	// }
	// }
	// // url
	// if (hasTitle) {
	// NodeList urlList = selectNodes("/map/urls/url", root);
	// boolean isSetPackage = false;
	// for (int i = 0; i < urlList.getLength(); i++) {
	// Element urlElement = (Element) urlList.item(i);
	// String url = urlElement.getTextContent().trim();
	// String[] item = url.replace("https://", "").split("/");
	// String path = "";
	// for (int j = 1; j < item.length; j++) {
	// path += "/" + item[j];
	// if (item[j].matches("^v[0-9]+")) {
	// if (!isSetPackage) {
	// packagePath = packagePrefix + path.replace("/", ".");
	// className = item[j + 1];
	// rclassName = className;
	// isSetPackage = true;
	// RequestModel reqtemp = FindRequestModel("versionNumber");
	// reqtemp.path = "/" + item[j];
	// }
	// path = "";
	// }
	// if (j == item.length - 1) {
	// String name = "";
	// RequestModel reqtemp;
	// if (item[j].startsWith("?")) {
	// name = item[j].substring(1, item[j].indexOf("="));
	// if ((reqtemp = FindRequestModel(name)) != null) {
	// reqtemp.path = path.substring(0, path.lastIndexOf("/"));
	// }
	// } else {
	// name = item[j].substring(1, item[j].indexOf("}"));
	// if ((reqtemp = FindRequestModel(name)) != null) {
	// reqtemp.path = path;
	// } else {
	// reqtemp.path = "/";
	// }
	// }
	// }
	// }
	// }
	// }
	// // response
	// Element response = (Element) selectSingleNode("/map/response", root);
	// String restable = response.getTextContent().trim();
	// htmldoc = Jsoup.parse(restable);
	// trElement = htmldoc.getElementsByTag("tr");
	// ResponseModel resModel = null;
	// hasTitle = false;
	// resTitleMap.put("element", -1);
	// resTitleMap.put("child of", -1);
	// resTitleMap.put("type", -1);
	// resTitleMap.put("description", -1);
	// if (trElement.size() > 0) {
	// Elements thElement = trElement.get(0).getElementsByTag("th");
	// if (thElement.size() == 0)
	// errorList.add("@Error: titles of table 'Response' are missing.");
	// for (int col = 0; col < thElement.size(); col++) {
	// String title = thElement.get(col).text().trim().toLowerCase();
	// if (resTitleMap.containsKey(title)) {
	// resTitleMap.put(title, col);
	// }
	// }
	// hasTitle = true; // verify
	// if (resTitleMap.get("element") == -1) {
	// errorList.add("@Error: title 'Element' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (resTitleMap.get("child of") == -1) {
	// errorList.add("@Error: title 'Child of' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (resTitleMap.get("type") == -1) {
	// errorList.add("@Error: title 'Type' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// if (resTitleMap.get("description") == -1) {
	// errorList.add("@Error: title 'Description' of table 'Request' is missing.");
	// hasTitle = false;
	// }
	// }
	// if (hasTitle) {
	// for (int row = 0; row < trElement.size(); row++) {
	// Elements tdElement = trElement.get(row).getElementsByTag("td");
	// if (tdElement.size() == 0)
	// continue;
	// if
	// (Jsoup.parse("&nbsp;").text().equals(tdElement.get(resTitleMap.get("element")).text().trim()))
	// continue;
	//
	// if
	// (Jsoup.parse("&nbsp;").text().equals(tdElement.get(resTitleMap.get("child of")).text().trim()))
	// { // responsemodel
	// String nametemp =
	// filterHtml(tdElement.get(resTitleMap.get("element")).text().trim());
	// String typetemp = tdElement.get(resTitleMap.get("type")).text().trim();
	// if (!verifyType(typetemp))
	// warnList.add(String.format("@warning: '%2$s' may not be the right type of '%1$s' in table 'Response'",
	// nametemp, typetemp));
	// resModel = new ResponseModel(nametemp, typetemp);
	// resModel.setDesc(tdElement.get(resTitleMap.get("description")).text().trim());
	// responseList.add(resModel);
	// } else { // propertymodel
	// if (resModel == null)
	// continue;
	// String nametemp =
	// filterHtml(tdElement.get(resTitleMap.get("element")).text().trim());
	// String typetemp = tdElement.get(resTitleMap.get("type")).text().trim();
	// if (!verifyType(typetemp))
	// warnList.add(String.format("@warning: '%2$s' may not be the right type of '%1$s' in table 'Response'",
	// nametemp, typetemp));
	// String childtemp =
	// tdElement.get(resTitleMap.get("child of")).text().trim();
	// Property proModel = resModel.new Property(nametemp, childtemp, typetemp);
	// proModel.setDesc(tdElement.get(resTitleMap.get("description")).text().trim());
	// resModel.add(proModel);
	// }
	// }
	// }
	// if (errorList.size() > 0)
	// isAnalysed = false;
	// else
	// isAnalysed = true;
	// return isAnalysed;
	// }

}
