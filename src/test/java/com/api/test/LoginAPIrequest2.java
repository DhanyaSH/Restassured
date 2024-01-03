package com.api.test;

import com.api.pojo.LoginRequestPOJO;
import static com.utility.TestUtility.*;
import static io.restassured.RestAssured.*;

import  static org.hamcrest.Matchers.*;

import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class LoginAPIrequest2 {
	static
	{
		
	baseURI = "http://139.59.91.96:9000/v1";
	}
	public static void main(String[] args) {
	Header header = new Header("Content-Type","application/json");
	LoginRequestPOJO loginpojo = new LoginRequestPOJO ("iamfd","password");


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
	                     .time(lessThan(2000L))
	                 .and()
	                     .body("message",equalTo("Success")) 
				         .extract().jsonPath().getString("data.token");

	System.out.println("-----------------------------------------");	
	System.out.println(token);
	}
}
