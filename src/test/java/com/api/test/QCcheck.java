package com.api.test;

import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.jobidpojo;

import io.restassured.http.Header;

public class QCcheck {
	private Header h1 ;
	private	Header h2;

	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}
	
	@BeforeMethod(description = "Intializing the headers")
	public void setup() {
		h1 = new Header("Content-type", "application/json");
		 h2 = new Header("Authorization", getTokenFor("qc"));
		
	}
	@Test(description = "test create job api requests generates job number", groups = {"sanity", "smoke","e2e"})
	
	public void createjobTest() {
			
	 given()
			.header(h1)
		.and()
			.header(h2)
		.and()		
			.log().all()
		.when()
			.get("/qc")
	    .then()
            .log().all()
		    .assertThat()
            .statusCode(200);
           
	}}


