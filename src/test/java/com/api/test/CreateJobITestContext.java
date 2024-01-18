package com.api.test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.pojo.Data;
import com.utility.TestUtility;

import static com.utility.TestUtility.*;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

@Listeners(com.listeners.MyTestListener.class)

public class CreateJobITestContext {
	private Header h1;
	private Header h2;

	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}


	@BeforeMethod
	public void setup() {
		h1 = new Header("Content-type", "application/json");
		h2 = new Header("Authorization", getTokenFor("fd"));

	}

	/**
	 * STATUS CODE RESPONSE BODY--RESPONSE FIELD RESPONSE TIME SCHEMA
	 * VALIDATION--NEGATIVE TESTING-----API TESTING Componenet! DB CROSS
	 * Check---jdbc---singleton design -----private constructor
	 * 
	 * @param context
	 */
	@Test(description = "test create job api requests generates job number", groups = { "smoke" })
	public void createjobTest(ITestContext context) {
	
		// TODO Auto-generated method stub

		int id = given().header(h1).and().header(h2).and().body(getJsonObject(getCreatJobPOJO())).log().all().when()
				.post("/job/create").then().log().all().assertThat().statusCode(200).statusLine("HTTP/1.1 200 OK").and()
				.body("message", equalTo("Job created successfully. ")).and().extract().jsonPath().getInt("data.id");

		context.getSuite().setAttribute("job_id", id);
		System.out.println(id);

	}

}
