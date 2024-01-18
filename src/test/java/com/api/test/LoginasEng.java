package com.api.test;

import static com.utility.TestUtility.getJsonObject;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.pojo.LoginAsEngPojo;
import com.api.pojo.LoginRequestPOJO;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
@Listeners(com.listeners.MyTestListener.class)

public class LoginasEng {
	
	private Header header;
	private LoginAsEngPojo loginpojo;
	static
	{
		
	baseURI = "http://139.59.91.96:9000/v1";
	}
	
	@BeforeMethod
	public void setUp() {
    header = new Header("Content-Type","application/json");
    loginpojo = new LoginAsEngPojo ("iameng","password");
	}
	
	
	@Test(description = "login api request",groups ={"e2e"},
	       retryAnalyzer = com.listeners.ReRunTest.class)
	
	public  void loginAPITest() {
   String token =     given()
			             .header(header)
			         .and()
				          .body(getJsonObject(loginpojo))
			         .and()
			              .log().all()
			              .when()
				          .post("/login")
	                 .then()
	                     .log().all()
                         .assertThat()
                         .statusCode(200)
	                 .and()
	                     .time(lessThan(5000L))
	                  .and()
	                     .body("message",equalTo("Success")) 
	                   .and()
				         .extract().jsonPath().getString("data.token");

	System.out.println("-----------------------------------------");	
	System.out.println(token);
	

}
}
