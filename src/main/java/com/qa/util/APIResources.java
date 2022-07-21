package com.qa.util;

//enum is special class in java which has collection of constants or  methods

public enum APIResources {
	
	AddPlace("/maps/api/place/add/json"), 
	GetPlace("/maps/api/place/get/json"),
	DeletePlace("/maps/api/place/delete/json");

	private String resource;
	
	APIResources(String resource) {
		this.resource = resource;
	}
	
	public String getResource() {
		return resource;
	}


}
