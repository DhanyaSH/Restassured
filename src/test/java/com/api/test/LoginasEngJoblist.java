package com.api.test;

import static com.utility.TestUtility.getCreatJobPOJO;
import static com.utility.TestUtility.getJsonObject;
import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.Header;

public class LoginasEngJoblist {

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
	

	@Test(description = "joblist after login as Engineer", groups = {"sanity", "smoke","e2e"})
	
	public void LoginasEngjoblistTest() {
		// TODO Auto-generated method stub
		
	 given()
			.header(h1)
		.and()
			.header(h2)
		.and()
			.log().all()
		.when()
			.get("/engineer/myjobs")
	    .then()
            .log().all()
		    .assertThat()
            .statusCode(200)
            .and()
            .time(lessThan(5000L))
         .and()
            .body("message",equalTo("Success")) 
          .and()
          .extract().jsonPath().getString("data[3].id");
        
}
}