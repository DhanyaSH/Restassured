package com.api.test;

import static com.utility.TestUtility.getCreatJobPOJO;
import static com.utility.TestUtility.getJsonObject;
import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.Problem;
import com.api.pojo.RepairCompletePojo;
import com.utility.TestUtility;

import io.restassured.http.Header;

public class RepairComplete {

	private Header h1 ;
	private	Header h2;
	private Problem problems[];
	private RepairCompletePojo repair;
	
	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}
	
	@BeforeMethod(description = "Intializing the headers")
	public void setup() {
		h1 = new Header("Content-type", "application/json");
		 h2 = new Header("Authorization", getTokenFor("eng"));
	
		 
	}
	

	@Test(description = "Repair Complete", groups = {"sanity", "smoke","e2e"})
	public void createjobTest(ITestContext context) {
		
		int job_id =(int) context.getSuite().getAttribute("job_id");
		 Problem problems[] = new Problem[1];
		 problems[0] = new Problem(1,"solved");
		RepairCompletePojo repairdone = new RepairCompletePojo(job_id,problems);
		    		
	given()
			.header(h1)
		.and()
			.header(h2)
		.and()
			.body(repairdone)
			.log().all()
		.when()
			.post("/engineer/repaircomplete")
	    .then()
            .log().all()
		    .assertThat()
            .statusCode(200);
	
	
	
}
}
