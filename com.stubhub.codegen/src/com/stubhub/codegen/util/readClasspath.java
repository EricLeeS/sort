/**
 * 
 */
package com.stubhub.codegen.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * @author huanli2
 *
 */
public class readClasspath {
	public List getSrcFolder(IFile file){
		List<String> srcList = new ArrayList<String>();
		try {
			
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			try {
				
				
				File f = new File(file.getLocation().toString());
				System.out.println(f.exists());
				System.out.println(file.getLocation().toString());
				
				
//				BufferedReader br = new BufferedReader(new FileReader(f));
//				br.readLine();
				
				
				
				
				Document doc = builder.parse(f);

				System.out.println(doc.toString());
				Element Info = doc.getDocumentElement();
				
				NodeList nodes = Info.getChildNodes();
				for(int i=0;i<nodes.getLength();i++){
					Node record = nodes.item(i);
//					NamedNodeMap attributes=record.getAttributes();
//					for(int m=0;m<attributes.getLength();m++){
//						Node attribute=attributes.item(m);
//						System.out.println("dbstore的属性名为:"+attribute.getNodeName()+" 相对应的属性值为:"+attribute.getNodeValue());
//						}
					if(record.getNodeName().equals("classpathentry")){
						NamedNodeMap attributes = record.getAttributes();
						Node node =attributes.getNamedItem("kind");
						if(node.getNodeValue().equalsIgnoreCase("src")){
							Node srcNode = attributes.getNamedItem("path");
							String src = srcNode.getNodeValue();
							srcList.add(src);
						
						}
						//String name =node.getNodeName();
						//System.out.println("this is classpathentry");
					}
				}
				
				
//				for(int i=0;i<nl.getLength();i++){
//					Node node = nl.item(i);
//					NodeList childList = node.getChildNodes();
//					for(int j=0;j<childList.getLength();j++){
//						Node record = childList.item(j);
//						NamedNodeMap map = record.getAttributes();
//						for(int m=0;m<map.getLength();m++){
//							Node attribute = map.item(m);
//							System.out.println("attribute:   "+attribute.getNodeName()+"   value:   "+attribute.getNodeValue());
//						}
//					}
//					
//				}
				
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return srcList;
		
	}
}
