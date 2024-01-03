package com.api.test;

import static com.utility.TestUtility.getJsonObject;
import static com.utility.TestUtility.getTokenFor;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.pojo.LoginRequestPOJO;

import io.restassured.http.Header;

public class LoginasfdAndreadyfordelivery {

	private Header h1;
	private Header h2;

	static {

		baseURI = "http://139.59.91.96:9000/v1";
	}

	@BeforeMethod
	public void setUp() {
		h1 = new Header("Content-Type", "application/json");
		h2 = new Header("Authorization", getTokenFor("fd"));
	}

	@Test(description = "login api request", groups = { "sanity" }, retryAnalyzer = com.listeners.ReRunTest.class)

	public void loginAPITest() {
		given().header(h1).and().header(h2).and().log().all().when().get("fd/readyfordelivery").then().log().all()
				.assertThat().statusCode(200).and().time(lessThan(5000L));

	}
}