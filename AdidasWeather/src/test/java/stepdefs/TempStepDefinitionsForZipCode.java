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
import services.Utils;

public class TempStepDefinitionsForZipCode 

{

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	@Given("a ZipCode exists with an id of (.*)")
	public void city_exists_with_an_name_of(String zip){

		Map<String, String> parametersMap = new HashMap();
		parametersMap.put("zip", zip);
		parametersMap.put("appid", Utils.APP_ID);

		request = given().params(parametersMap);
	}


	@When("a user retrieves the temprature by ZipCode")
	public void a_user_retrieves_the_temprature_by_name(){
		response = request.when().get(Utils.WEATHERURL);
		System.out.println("response: " + response.prettyPrint());

	}

	@Then("the status code for zip  (\\d+)")
	public void verify_status_code_zip(int statusCode){
		json = response.then().statusCode(statusCode);
	}

	@And("response of zipcode includes the following in any order")
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
