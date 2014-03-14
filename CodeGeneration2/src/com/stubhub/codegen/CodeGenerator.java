package com.stubhub.codegen;

import java.util.ArrayList;
import java.util.List;

import com.stubhub.codegen.template.PropEntity;
import com.stubhub.codegen.template.ResponseTemplate;


public class CodeGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ResponseTemplate response = new ResponseTemplate();
		response.setPackageName("com.stubhub.domain.fulfillment.lms.v1.intf");
		response.setClassName("LMSLocationsResponse");
		List<PropEntity> proplist = new ArrayList<PropEntity>();
		proplist.add(new PropEntity("lmsRegions","LMSRegion","List"));
		proplist.add(new PropEntity("eventLmsLocations","EventLmsLocation","List"));
		proplist.add(new PropEntity("lmsLocations","LMSLocation","List"));
		response.setPropList(proplist);
		response.generate("");
	}

}
