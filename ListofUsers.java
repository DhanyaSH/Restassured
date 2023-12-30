package restassuredassignment;
import io.restassured.response.Response;
import io.restassured.specification.RedirectSpecification;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;
import java.util.List;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import groovyjarjarantlr4.v4.parse.ANTLRParser.id_return;


public class ListofUsers {

	static {
		
		baseURI ="https://reqres.in/api";
	}
	@Test(description = "get userlist", groups = {"sanity"})
		
	public void  ListofUsersTest() {
Response response	=	 given()
		.and()
			.log().all()
		.when()
			.get("users?page=2")
	    .then()
         .log().all()
		    .assertThat()
            .statusCode(200)
          .and()
            .body("data[2].first_name",equalTo("Tobias"))
           .and()
             .body("data.last_name",hasItems("Funke","Ferguson"))
		    .and()
		    .extract().response();
            
//List dataList = response.jsonPath().get("data");
//	System.out.println(dataList);

//List dataList1 = response.jsonPath().get("data.email");
//System.out.println(dataList1);

//List dataList1 = response.jsonPath().getList("data.findAll{it.id >9}.first_name");
//System.out.println(dataList1); 






	
	
	
	
}
}
