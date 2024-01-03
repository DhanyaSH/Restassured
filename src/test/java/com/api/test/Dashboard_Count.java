package com.api.test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONArray;
import org.testng.TestNG.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import com.api.pojo.Data;
import com.jayway.jsonpath.JsonPath.*;
import static com.utility.TestUtility.*;


public class Dashboard_Count {
	private Header myHeader;
	static
	{
		baseURI = "http://139.59.91.96:9000/v1";
	}
	
	@BeforeMethod
  public void SetUP() {
  myHeader = new Header("Authorization",getTokenFor("fd"));
	}
	@Test(description = "dashboradcount",groups = {"sanity"})
  public void dashBoardCount() {
  
	String value          =   given()
                             .header(myHeader)
                       .and()
                            .log().all()
                       .and()
                            .when()
                            .get("dashboard/count")
                        .then()
	                         .log().all()
	                     .and()
	                         .assertThat()
	                         .statusCode(200)
	                         .time(lessThan(2500L))
	                     .and()
	                     .extract().response().asString();

	
	JsonPath js = new JsonPath(value);
//	System.out.println(js.getString("data[0].label"));// items in index 0.
int size = js.getInt("data.size()"); //size of array
	
	
	//print all key,count

//	for(int i =0; i<size;i++) {
////		String key = js.getString("data["+i+"].key");
//		String count = js.getString("data["+i+"].count");
//
//		System.out.println(count);
//		
//	}
//	
	//sum of  count
int totalcount = 0;
for (int i=0; i<size;i++) {
	totalcount+= js.getInt("data["+i+"].count");
}
	
	System.out.println(totalcount);
	
	
	
//	                     .extract().jsonPath().get("$").toString();
	

// 
//    
//                 JsonPath js = new JsonPath(value);
//                    System.out.println(js);
                 
//                 
//  
	                     
	                     
//	                          .body("data[0].label",equalTo("Pending for delivery"))
//	                          
//	                      .and()
//	                           .body("data.label",hasItem("Created today")).toString();
//	                      
//                  
//                    
	                     
                  
	                      
	                           
               
	                         
	                         
	                         
	
	
	

}
}
