package com.api.test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.util.List;
import java.util.Map;

import static com.utility.TestUtility.*;
import org.testng.TestNG.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.annotations.Test.*;

import com.jayway.jsonpath.JsonPath;

import io.restassured.http.Header;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyExtractionOptions;
@Listeners(com.listeners.MyTestListener.class)

public class Master {
	private Header h1;
	private Header h2;

	static {
		baseURI = "http://139.59.91.96:9000/v1";
	}
	
	File jsonShemaFile = new File(System.getProperty("user.dir")+"//src//test//resources//responseSchemas//Master.json");
     @BeforeMethod
	public void SetUP() {
    	 
    	 h1 = new Header("Content-Type","application/json");
    	 h2 = new Header("Authorization",getTokenFor("fd"));

	}

	@Test(description = "Masterdata",groups = {"e2e"})
public void masterData() {

  Object data =	given()
         .header(h1)
   .and()
        .header(h2)
        .log().all()
   .and()
        .when()
        .post("master")
    .then()
         .log().all()
	  .and()
	      .assertThat()
          .statusCode(200)
          .time(lessThan(2000L))
      .and()
          .body(JsonSchemaValidator.matchesJsonSchema(jsonShemaFile))
          .body("data.mst_oem[0].name",equalTo("Google"))
          .body("data.map_fst_pincode[6].pincode", equalTo(200012))
         
          .extract().jsonPath().getJsonObject("$");
          

//Map<String,String> resIDs = data.jsonPath().get("data");

//List<String> resIDs = data.jsonPath().get("data.mst_model");
//System.out.println("Retrieved IDs from Response : " + resIDs);
//System.out.println("ArraySize for IDs from Response : " + resIDs.size());//size of array.
//boolean resIDs1 = resIDs.contains("data.mst_oem[0].name");//name is prsent or not
  

//List<String> resIDs = data.jsonPath().get("data.mst_model.id");
//System.out.println("Retrieved IDs from Response : " + resIDs);
//System.out.println("ArraySize for IDs from Response : " + resIDs.size());
//




//List<Object> resIDs = data.jsonPath().getList("data.mst_action_status.findAll{it.is_active > 0}.name"); //is active atatus greater than 1 and their name.
//               
//    int  resIDs1 = data.jsonPath().getInt("data.mst_action_status.name.collect{it.length()}.sum()");//sum of length of all names present in data.mst_action_status

            
            //.extract().jsonPath().getString("data");
  
// String value = JsonPath.read(data, "$..*").toString();//retrived everything from first array using jsonpath expression
// String value1 = JsonPath.read(data, "$..data").toString();
// String value2 = JsonPath.read(data, "$..mst_action_status.length()").toString();
// String value3 = JsonPath.read(data,"$..mst_model[*].name").toString(); //all names from mst_model
// String value4 = JsonPath.read(data,"$..mst_model[:2].name").toString();
 


//      System.out.println("-----------------------------------------");
 System.out.println(data); 


	}
}

	