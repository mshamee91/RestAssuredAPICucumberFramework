package com.qa.testdata;

import java.util.ArrayList;
import java.util.List;

import com.qa.util.AddPlace;
import com.qa.util.Location;

public class AddPlacePayload {
	
	AddPlace p =new AddPlace();
	Location l = new Location();
	List<String> types = new ArrayList<String>();
	
	public AddPlace AddPayload(String name, String address) {
		types.add("shoe park");
		types.add("shop");
		l.setLat(-38.383494);
		l.setLng(33.427362);
		p.setLocation(l);
		p.setAccuracy(50);
		p.setName(name);
		p.setPhone_number("(+91) 983 893 3937");
		p.setAddress(address);
		p.setWebsite("http://google.com");
		p.setLanguage("French-IN");
		p.setTypes(types);
		return p;
	}
}
