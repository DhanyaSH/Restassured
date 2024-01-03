package com.api.test;

import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.Header;

public class MappedEngineerUnderSupervisorITestContest {
	private Header h1;
	private Header h3;
	{
		baseURI = "http://139.59.91.96:9000/v1";
		
	}
	@BeforeMethod
	public void SetUp1() {
		h1 = new Header("Content-type", "application/json");
		h3 = new Header("Authorization",getTokenFor("sup"));	
		

	}
@Test(description = "list of mapped enginneer under the supervisor for that specific location", groups = {"smoke","sanity"})

	
	public void MappedEngineerUnderSupervisor(ITestContext context) {
		
		int id1 =	given()
		         .header(h1)
		   .and()
		        .header(h3)
		        .log().all()
			.and()
			     .when()
			     .get("engineer/mapped")
			.then()
			      .log().all()	      
			      .assertThat()
		            .statusCode(200)
		            .statusLine("HTTP/1.1 200 OK")
		         .and()
		             .body("message", equalTo("Success"))
		         .and()
		             .extract().jsonPath().getInt("data[0].id");
		 
			context.getSuite().setAttribute("engineer_id", id1);
		        System.out.println(id1);
		}
	
	
	
	

}
