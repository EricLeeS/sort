/**
 * 
 */
package com.stubhub.codegen.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;

/**
 * @author huanli2
 *
 */
public class constantHelper {
	private static IProject project;
	private static String srcFolder;
	private static String packageName;
	private static String className;
	private static String requestText;
	private static String responseText;
	private static List urlList = new ArrayList();
	private static List warnList = new ArrayList();
	private static List erList = new ArrayList();
	public static String getSrcFolder() {
		return srcFolder;
	}
	public static void setSrcFolder(String srcFolder) {
		constantHelper.srcFolder = srcFolder;
	}
	public static String getPackageName() {
		return packageName;
	}
	public static void setPackageName(String packageName) {
		constantHelper.packageName = packageName;
	}
	public static String getClassName() {
		return className;
	}
	public static void setClassName(String className) {
		constantHelper.className = className;
	}
	public static IProject getProject() {
		return project;
	}
	public static void setProject(IProject project) {
		constantHelper.project = project;
	}
	public static String getRequestText() {
		return requestText;
	}
	public static void setRequestText(String requestText) {
		constantHelper.requestText = requestText;
	}
	public static String getResponseText() {
		return responseText;
	}
	public static void setResponseText(String responseText) {
		constantHelper.responseText = responseText;
	}
	public static List getUrlList() {
		return urlList;
	}
	public static void setUrlList(List urlList) {
		constantHelper.urlList = urlList;
	}
	public static List getWarnList() {
		return warnList;
	}
	public static void setWarnList(List warnList) {
		constantHelper.warnList = warnList;
	}
	public static List getErList() {
		return erList;
	}
	public static void setErList(List erList) {
		constantHelper.erList = erList;
	}

	
	

}
