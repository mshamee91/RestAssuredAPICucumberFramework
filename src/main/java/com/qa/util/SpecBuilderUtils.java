package com.qa.util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SpecBuilderUtils {
	
	public static RequestSpecification reqSpec;
	ConfigReader configReader = new ConfigReader();
	
	public RequestSpecification requestSpecification() throws IOException {
			
			if(reqSpec==null) {
				PrintStream p = new PrintStream(new FileOutputStream("logging.txt"));
				reqSpec = new RequestSpecBuilder().setBaseUri(configReader.getProperty("BaseURI"))
					.addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON)
					.addFilter(RequestLoggingFilter.logRequestTo(p))
					.addFilter(ResponseLoggingFilter.logResponseTo(p)).build();
			return reqSpec;
			}
		return reqSpec;
	}
}
