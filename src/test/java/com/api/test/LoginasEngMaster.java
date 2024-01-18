package com.api.test;

import static com.utility.TestUtility.getCreatJobPOJO;
import static com.utility.TestUtility.getJsonObject;
import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.http.Header;
@Listeners(com.listeners.MyTestListener.class)

public class LoginasEngMaster {

	private Header h1 ;
	private	Header h2;


	
	
	
	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}
	
	@BeforeMethod(description = "Intializing the headers")
	public void setup() {
		h1 = new Header("Content-type", "application/json");
		 h2 = new Header("Authorization", getTokenFor("eng"));
		
	}
	

	@Test(description = "Master details", groups = {"e2e"})
	
	public void createjobTest() {
		// TODO Auto-generated method stub
		
	 given()
			.header(h1)
		.and()
			.header(h2)
		.and()
			.log().all()
		.when()
			.post("master")
	    .then()
            .log().all()
		    .assertThat()
            .statusCode(200);
	
}}
