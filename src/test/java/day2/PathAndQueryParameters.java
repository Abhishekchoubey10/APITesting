package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PathAndQueryParameters {

	// https://reqres.in/api/users?page=2&id=5

	@Test
	public void testPathAndQueryParameters() {
		
		given()
		  .pathParam("mypath", "users") //path parameters
		  .queryParam("page", 2) //query parameters 
		  .queryParam("id", 5)  //query parameters 
		
		.when()
		  .get("https://reqres.in/api/{mypath}") //no need to pass the query parameter, query parameters that is define in given will go along this
		
		.then()
		  .statusCode(200)
		  .log().all();
		
		
	}

}
