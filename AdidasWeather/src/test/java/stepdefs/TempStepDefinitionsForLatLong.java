package stepdefs;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class TempStepDefinitionsForLatLong {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;

	private String ENDPOINT_GET_WEATHER = "http://api.openweathermap.org/data/2.5/weather";
	private static String APPID ="57068c7d8e950d3784dd9c16f904d2a4";

	@Given("a LatLong exists with an lat of (\\d+) and long of (\\d+)")
	public void city_exists_with_an_name_of(String lat , String lon)
	{

		Map<String, String> parametersMap = new HashMap();
		parametersMap.put("lat",lat );
		parametersMap.put("lon",lon );
		parametersMap.put("appid", APPID);

		request = given().params(parametersMap);
	}


	@When("a user retrieves the temprature by LatLong")
	public void a_user_retrieves_the_temprature_by_name(){
		response = request.when().get(ENDPOINT_GET_WEATHER);
		System.out.println("response: " + response.prettyPrint());

	}

	@Then("the status code for LatLong  (\\d+)")
	public void verify_status_code_latlong(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@And("response of latlong includes the following in any order")
	public void response_equals(Map<String,String> responseFields){
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if(StringUtils.isNumeric(field.getValue())){
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			}
			else{
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}

}
	

