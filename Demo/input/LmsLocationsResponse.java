package com.stubhub.domain.fulfillment.lms.v1.intf;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.stubhub.domain.fulfillment.common.BaseResponse;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "LmsLocationsResponse")
@XmlType(name = "LmsLocationsResponse", propOrder = {"lmsRegions", "eventLmsLocations", "lmsLocations"})

public class LmsLocationsResponse extends BaseResponse{
	@XmlElement(name = "lmsRegions",type = LmsRegion.class)
	private List<LmsRegion> lmsRegions;
	@XmlElement(name = "eventLmsLocations",type = EventLmsLocation.class)
	private List<EventLmsLocation> eventLmsLocations;
	@XmlElement(name = "lmsLocations",type = LmsLocation.class)
	private List<LmsLocation> lmsLocations;
	
	public void setLmsRegions(List<LmsRegion> lmsRegions){
		this.lmsRegions = lmsRegions;
	}
	
	public List<LmsRegion> getLmsRegions(){
		return lmsRegions;
	}
	
	public void setEventLmsLocations(List<EventLmsLocation> eventLmsLocations){
		this.eventLmsLocations = eventLmsLocations;
	}
	
	public List<EventLmsLocation> getEventLmsLocations(){
		return eventLmsLocations;
	}
	
	public void setLmsLocations(List<LmsLocation> lmsLocations){
		this.lmsLocations = lmsLocations;
	}
	
	public List<LmsLocation> getLmsLocations(){
		return lmsLocations;
	}
}
