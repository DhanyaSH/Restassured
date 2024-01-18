package com.api.test;

import com.api.pojo.LoginRequestPOJO;
import io.restassured.path.json.JsonPath.*;
import com.utility.TestUtility;

import static com.utility.TestUtility.*;
import static io.restassured.RestAssured.*;

import  static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
@Listeners(com.listeners.MyTestListener.class)

public class UserdetailsAPIrequest {
	private Header myHeader;
	
	static {
		
		baseURI =  "http://139.59.91.96:9000/v1";	
	}

	
	File jsonSchemaFile = new File (System.getProperty("user.dir")+ "//src//test//resources//responseSchemas//GetUserdetails.json");
	
	@Test(description = "userdetails", groups = {"e2e"})
	
//	@BeforeMethod
//	public void setUp() {
	
	 
//}
	
	public void Userdetails() { 
	myHeader = new Header("Authorization",getTokenFor("fd"));
	Response ds = given()
		           .header(myHeader)
		      .and()     
		           .log().all()
		      .and()
		           .when()
		           .get("userdetails")//request type
		      .then()
		           .log().all()
		       .and()
		           .assertThat()
		           .statusCode(200)
		           .statusLine("HTTP/1.1 200 OK")
		           .time(lessThan(1500L))
		       .and()
		           .header("Content-Type","application/json; charset=utf-8")
		           .body("data.id",equalTo(4))
		        .and()   
		             .extract().response();
	
	
	
	Map<String,String> resIDs = ds.jsonPath().get("data");
//		System.out.println(resIDs .keySet().size()); //size of object
//boolean se= ds.jsonPath().get("data.first_name").equals(ds.jsonPath().get("data.last_name"));

	System.out.println( resIDs );
	
	}
}
	