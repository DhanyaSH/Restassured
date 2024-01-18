package com.api.test;

import static io.restassured.RestAssured.*;

import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import com.api.pojo.AssigntoEngineerPOJO;
import com.api.test.*;

import static com.utility.TestUtility.*;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;

@Listeners(com.listeners.MyTestListener.class)

public class AssignjobtoEngineer {

	private Header h1;
	private Header h2;

	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}

	@BeforeMethod(description = "Intializing the headers", alwaysRun = true)
	public void setup() {

		h1 = new Header("Content-type", "application/json");
		h2 = new Header("Authorization", getTokenFor("sup"));

	}

	@Test(description = "test create job api requests generates job number", groups = { "sanity" })

	public void createjobTest(ITestContext context) {

		int job_id = (int) context.getSuite().getAttribute("job_id");
		int engineer_id = (int) context.getSuite().getAttribute("engineer_id");
		AssigntoEngineerPOJO jobidemployeeid = new AssigntoEngineerPOJO(job_id, engineer_id);

		given().header(h1).and().header(h2).and().body(jobidemployeeid).log().all().when().post("engineer/assign")
				.then().log().all();

	}
}
