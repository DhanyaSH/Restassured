package com.api.test;

import com.api.pojo.LoginRequestPOJO;
import com.utility.TestUtility;

import static com.utility.TestUtility.*;
import static io.restassured.RestAssured.*;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class LoginAPIrequest1 {

	static
	{
		
	baseURI = "http://139.59.91.96:9000/v1";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Header header = new Header("Content-Type","application/json");
	
//	make request
	
	RequestSpecification request = given();
	request.header(header);
	LoginRequestPOJO loginpojo = new LoginRequestPOJO ("iamfd","password");
	request.body(TestUtility.getJsonObject(loginpojo));
		Response response = request.post("login");
		System.out.println("Response Body" + response.asPrettyString());
		System.out.println("Time" +response.time());
		System.out.println("SC" + response.statusCode());
	}

}
