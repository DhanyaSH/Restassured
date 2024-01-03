package com.api.test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.RestAssured;

public class LoginAPIrequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
	RestAssured.baseURI = "http://139.59.91.96:9000/v1";
	Header header = new Header("Content-Type","application/json");
	
//	make request
	
	RequestSpecification request =RestAssured.given();
	request.header(header);
	request.body("{\r\n"
			+ "    \"username\":\"iamfd\",\"password\":\"password\"\r\n"
			+ "    }\r\n"
			+ "");
	
		Response response = request.post("login");
		System.out.println("Response Body" + response.asPrettyString());
		System.out.println("Time" +response.time());
		System.out.println("SC" + response.statusCode());
	}

}
