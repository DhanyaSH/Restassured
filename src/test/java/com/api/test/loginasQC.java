
	
	package com.api.test;

	import com.api.pojo.LoginRequestPOJO;
	import static com.utility.TestUtility.*;
	import static io.restassured.RestAssured.*;

	import  static org.hamcrest.Matchers.*;

	import java.io.File;

	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import io.restassured.http.Header;
	import io.restassured.module.jsv.JsonSchemaValidator;
	import io.restassured.response.Response;
	import io.restassured.specification.RequestSpecification;
	@Listeners(com.listeners.MyTestListener.class)

	public class loginasQC {
		private Header header;
		private LoginRequestPOJO loginpojo;
		static
		{
			
		baseURI = "http://139.59.91.96:9000/v1";
		}
	
		
		@BeforeMethod
		public void setUp() {
	    header = new Header("Content-Type","application/json");
	    loginpojo = new LoginRequestPOJO ("iamqc","password");
		}
		
		
		@Test(description = "login api request",groups ={"sanity"},
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



