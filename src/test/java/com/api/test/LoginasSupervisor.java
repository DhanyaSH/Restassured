package com.api.test;
import static io.restassured.RestAssured.*;
import static com.utility.TestUtility.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test.*;

import com.api.pojo.Data;
import com.api.pojo.LoginasSupervisorPojo;

import io.restassured.http.Header;
import io.restassured.response.ValidatableResponse;
@Listeners(com.listeners.MyTestListener.class)

public class LoginasSupervisor {

	private Header header;
	private LoginasSupervisorPojo loginassup;
	static {
		
		baseURI = "http://139.59.91.96:9000/v1";
		
	}
	
	@BeforeMethod
	
	public void setUp() {
	header = new Header("Content-Type","application/json");
	loginassup = new LoginasSupervisorPojo ("iamsup","password");
	}
	
	@Test(description = "Login as Supervisor", groups = {"sanity"})
	
	public void LoginAsSpervisor() {
		 String token =	  given()
	        .header(header)
	  .and()  
	       .body(getJsonObject(loginassup))
	  .and()
	       .log().all()
	       .when()
	       .post("/login")
	   .then()
	        .log().all()
	        .assertThat()
	        .statusCode(200)
	        .statusLine("HTTP/1.1 200 OK")
	        .time(lessThan(2000L))
	    .and()
           .body("message", equalTo("Success"))
         .and()
              .extract().jsonPath().getString("data.token");

	System.out.println(token);        
	        		
	        
	       
	  
	       
	  
	
	
	
	
	
	
}
}