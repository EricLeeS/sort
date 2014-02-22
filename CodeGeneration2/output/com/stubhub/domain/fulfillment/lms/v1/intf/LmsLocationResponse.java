package com.stubhub.domain.fulfillment.lms.v1.intf;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.stubhub.domain.fulfillment.common.BaseResponse;

/** 
 * Version 1.0 Java JDT Code Generation
 * @author lihuan
 */
@Produces({ MEDIATYPE.APPLICATION_JSON, MEDIATYPE.APPLICATION_XML })
@XmlType(name = "LmsLocationsResponse", propOrder = { "lmsRegions", eventLmsLocations })
@XmlAccessorType("XmlAccessType.FIELD")
@XmlAccessorType(XmlAccessType.FIELD)
@MarkerAnnotation
public class LmsLocationResponse extends BaseResponse {
	public int testInt = 1024;
	public boolean testBool = true;
	public Generator.TEST testClass = new GeneratorImpl();
	public List<Integer, String> testGeneric = new ArrayList<Integer, String>();
	public int[][] intArray = new int[10][20];

	public LmsLocationsResponse(@QueryParam(value = "eventIds") Composite composite);
}
