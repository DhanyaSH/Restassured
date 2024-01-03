package com.api.test;

import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.jobidpojo;

import io.restassured.http.Header;

public class Delivertothecustomer {
	
	private Header h1;
	private Header h2;

	static {

		baseURI = "http://139.59.91.96:9000/v1";
	}

	@BeforeMethod
	public void setUp() {
		h1 = new Header("Content-Type", "application/json");
		h2 = new Header("Authorization", getTokenFor("fd"));
	}

	@Test(description = "login api request", groups = { "sanity" }, retryAnalyzer = com.listeners.ReRunTest.class)
	public void DelivertothecustomerTest(ITestContext context) {
	
	int job_id =(int) context.getSuite().getAttribute("job_id");
		
	 jobidpojo job = new  jobidpojo(job_id);
		
	 given()
			.header(h1)
		.and()
			.header(h2)
		.and()
			.body(job)
			.log().all()
		.when()
			.post("fd/delivertocustomer")
	    .then()
            .log().all()
		    .assertThat()
            .statusCode(200);
           
	}}


