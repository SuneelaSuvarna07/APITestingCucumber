package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDefinition {

	RequestSpecification reqSpec;
	Response resp;
	
	@Given("path param {string} with value {string}")
	public void pathParamWithValue(String key, String value) {
		reqSpec=RestAssured
					.given()
						.pathParam(key, value);
		
	}
	
	@When("GET request is executed with {string}")
	public void getRequestIsExecutedWith(String url) {

		resp=reqSpec
				.when()
					.log().all()
						.get(url);
	}

	@Then("verify status code is {int}")
	public void verifyStatusCodeIs(Integer statusCode) {
		
		resp
			.then()
				.log().all()
					.statusCode(statusCode);

	}
	
	@Given("query param {string} with value {string}")
	public void queryParamWithValue(String key, String value) {
		
			reqSpec.queryParam(key, value);
		
	  }
	@Given("header {string} with value {string}")
	public void headerWithValue(String key, String value) {
		
			reqSpec.headers(key, value);
	}

	@Given("query param {string} with value {int}")
	public void queryParamWithValue(String key, Integer value) {
		reqSpec.queryParam(key, value);
	}

	@Then("verify repo count is {int}")
	public void verifyRepoCountIs(Integer int1) {
	   
		
	}


}
