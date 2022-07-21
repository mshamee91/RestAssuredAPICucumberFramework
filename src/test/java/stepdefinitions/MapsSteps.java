package stepdefinitions;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.qa.testdata.AddPlacePayload;
import com.qa.util.APIResources;
import com.qa.util.AddPlace;
import com.qa.util.Location;
import com.qa.util.SpecBuilderUtils;
import com.qa.util.Utils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;

public class MapsSteps {
	
	SpecBuilderUtils specBuilderUtils = new SpecBuilderUtils();
	AddPlacePayload addPlacePayload = new AddPlacePayload();
	Utils u = new Utils();
	RequestSpecification reqSpec;
	RequestSpecification req;
	ResponseSpecification res;
	static Response response;
	static String place_id;
		
	
	@Given("Add Place API with {string} and {string}")
	public void add_place_api_with_name_and_address(String name, String address) throws IOException {
				
		req = given().spec(specBuilderUtils.requestSpecification()).body(addPlacePayload.AddPayload(name,address));
				
	}
	
	@Given("Get Place API")
	public void get_place_api() throws IOException {
		place_id = u.getValueFromJsonPath(response, "place_id");		
		req = given().spec(specBuilderUtils.requestSpecification()).queryParam("place_id", place_id);
				
	}
	
	@Given("Delete Place API")
	public void delete_place_api() throws IOException {
		
		req = given().spec(specBuilderUtils.requestSpecification()).body("{\r\n    \"place_id\":\""+place_id +"\"\r\n}");
	}

	@When("user calls {string} API with {string} http request")
	public void user_calls_api_with_http_request(String resource, String method) {
		
		APIResources apiResources = APIResources.valueOf(resource);
		
		//res = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200).build();
		if(method.equalsIgnoreCase("POST")) {
			response = req.when().post(apiResources.getResource());
		}else if(method.equalsIgnoreCase("GET")) {
			response = req.when().get(apiResources.getResource());
		}
	}

	@SuppressWarnings("deprecation")
	@Then("user gets response with status code as {int}")
	public void user_gets_response_with_status_code_as(int statuscode) {
		
		int statusCode  = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	
	@SuppressWarnings("deprecation")
	@Then("response shows {string} as {string}")
	public void response_shows_as(String key, String expectedValue) {
		String actualValue = u.getValueFromJsonPath(response, key);
		Assert.assertEquals(expectedValue, actualValue);
	}
}
