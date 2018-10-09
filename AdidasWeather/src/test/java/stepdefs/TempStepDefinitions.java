package stepdefs;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsInAnyOrder;
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

public class TempStepDefinitions {

	private Response response;
	private ValidatableResponse json;
	private RequestSpecification request;


	@Given("a City exists with an name of (.*)")
	public void city_exists_with_an_name_of(String name) {

		Map<String, String> parametersMap = new HashMap();
		parametersMap.put("q", name);
		parametersMap.put("appid", Utils.APP_ID);

		request = given().params(parametersMap);
	}

	@When("a user retrieves the temprature by name")
	public void a_user_retrieves_the_temprature_by_name() {
		response = request.when().get(Utils.WEATHERURL);
		System.out.println("response: " + response.prettyPrint());

	}

	@Then("the status code  (\\d+)")
	public void verify_status_code(int statusCode) {
		json = response.then().statusCode(statusCode);
	}

	@And("response includes the following in any order")
	public void response_equals(Map<String, String> responseFields) {
		for (Map.Entry<String, String> field : responseFields.entrySet()) {
			if (StringUtils.isNumeric(field.getValue())) {
				json.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
			} else {
				json.body(field.getKey(), equalTo(field.getValue()));
			}
		}
	}

}
