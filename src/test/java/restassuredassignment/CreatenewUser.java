package restassuredassignment;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

import org.hamcrest.collection.HasItemInArray;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utility.TestUtility;
import restassuredassignment.*;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreatenewUser {

	private CreateNewUserPojo newUserPojo;

	static {

		baseURI = "https://reqres.in/api";
	}


	@Test(description = "Create new user", groups = {"sanity"})
		
	public void   CreatenewUserTest() {
   newUserPojo = new CreateNewUserPojo("dhanya","tester");		
   JsonPath jsonPath =    given()        
         .and()
          .body(newUserPojo)
		.and()
			.log().all()
		.when()
			.post("/users")
	    .then()
         .log().all()
         .assertThat()
         .statusCode(201)
    
         .time(lessThan(5000L)) 
      .and()
          .extract().response().jsonPath();
   
  System.out.println( jsonPath.getInt("id"));
  Object obj = jsonPath.get("$");
  System.out.println(obj);
 
 
  
  
  
  
  
   

}
}
