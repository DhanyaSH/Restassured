package com.api.test;

import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.http.Header;
@Listeners(com.listeners.MyTestListener.class)

public class PendingjobstoAssign {
	private Header h1 ;
	private	Header h2;


	

	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}
	
	@BeforeMethod(description = "Intializing the headers")
	public void setup() {
		h1 = new Header("Content-type", "application/json");
		 h2 = new Header("Authorization", getTokenFor("sup"));
		
	}
	

	@Test(description = "pending jobs to assign to engineer", groups = {"e2e"})
public void MappedEngineerUnderSupervisor() {
		
		int id1 =	given()
		         .header(h1)
		   .and()
		        .header(h2)
		        .log().all()
			.and()
			     .when()
			     .get("job/pending")
			.then()
			      .log().all()	      
			 .and()
			    .assertThat()
	            .statusCode(200)
	            .statusLine("HTTP/1.1 200 OK")
	         .and()
	             .body("message", equalTo("Success"))
	         .and()
			     .extract().jsonPath().getInt("data[3].id");

}
}
