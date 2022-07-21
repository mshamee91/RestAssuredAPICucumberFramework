package com.qa.util;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Utils {
	public String getValueFromJsonPath(Response response, String key)
	{
		JsonPath jp = new JsonPath(response.asString());
		String value = jp.getString(key);
		return value;
	}
}
