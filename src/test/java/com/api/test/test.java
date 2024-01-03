//
//package com.api.test;
//import static org.hamcrest.Matchers.*;
//
//import org.apache.commons.logging.Log;
//import org.apache.xmlbeans.impl.xb.xsdschema.Public;
//
//import static com.utility.TestUtility.*;
//import static io.restassured.RestAssured.*;
//
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.api.pojo.AssigntoEngineerPOJO;
//import com.aventstack.extentreports.gherkin.model.Given;
//import com.utility.TestUtility;
//import com.utility.TestUtility.*;
//
//import io.opentelemetry.context.Context;
//import io.restassured.http.Header;
//import io.restassured.module.jsv.JsonSchemaValidator;
//
//import org.testng.ITestContext;
//import org.testng.TestNG;
//import org.testng.TestNG.*;
//
//public class test {
//private Header h1;
//private Header h2;
//private Header h3;
//
//{
//	baseURI = "http://139.59.91.96:9000/v1";
//	
//}
//@BeforeMethod
//public void SetUp() {
//	h1 = new Header("Content-type", "application/json");
//    h2 = new Header("Authorization", getTokenFor("fd"));
//		
//	
//	
//}
////@Test(description = "test create job api requests generates job number", groups = {"sanity", "smoke","e2e"})
//@Test(priority = 1)
//public void createjobTest(ITestContext context) {
//	// TODO Auto-generated method stub
//	
//int job_Id = given()
//		.header(h1)
//	.and()
//		.header(h2)
//	.and()
//		.body(getJsonObject(getCreatJobPOJO()))
//		
//		.log().all()
//	.when()
//		.post("/job/create")
//    .then()
//        .log().all()
//	    .assertThat()
//        .statusCode(200)
//        .statusLine("HTTP/1.1 200 OK")
//     .and()
//         .body("message", equalTo("Job created successfully. "))
//     .and()
//         .extract().jsonPath().getInt("data.id");
//context.setAttribute("job_id",job_Id);
//
//
//
//}
//@BeforeMethod
//public void SetUp1() {
//	h1 = new Header("Content-type", "application/json");
//	h3 = new Header("Authorization",getTokenFor("sup"));	
//	
//
//}
////@Test(description = "list of mapped enginneer under the supervisor for that specific location", groups = {"smoke","sanity"})
//@Test(priority = 2)
//
//public void MappedEngineerUnderSupervisor(ITestContext context) {
//	
//int engineer_id =	given()
//         .header(h1)
//   .and()
//        .header(h3)
//        .log().all()
//	.and()
//	     .when()
//	     .get("engineer/mapped")
//	.then()
//	      .log().all()	      
//	 .and()
//	     .extract().jsonPath().getInt("data[0].id");
//  context.setAttribute("engineer_id", engineer_id);
//}
//@BeforeMethod
//public void SetUp3() {
//	h1 = new Header("Content-type", "application/json");
//	h3 = new Header("Authorization",getTokenFor("sup"));	
//}
//
////@Test(description = "AssignjobtoEngineer", groups = {"smoke","sanity"},dependsOnMethods = {"createjobTest","MappedEngineerUnderSupervisor"})
//
//@Test(priority = 3)
//
//public void AssignjobtoEngineer(ITestContext context) {
//	
//	 
//	int job_id = (int) context.getAttribute("job_id");
//	int engineer_id = (int) context.getAttribute("engineer_id");
//	AssigntoEngineerPOJO jobidemployeeid = new AssigntoEngineerPOJO(job_id,engineer_id);
//	
//	
//	given()
//    .header(h1)
//.and()
//   .header(h3)
//.and()
//   .body(jobidemployeeid)
//.and()
//  .log().all()
//   .when()
//    .post("engineer/assign")
//.then()
//    .log().all();
//	
//
//
//}}
