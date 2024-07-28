package day6;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.ITestContext;
import org.testng.annotations.Test;

public class GetUser {

	@Test
	public void test_getUser(ITestContext context) {
		
		int id =(int) context.getAttribute("user_id");  //We will get this from create user test class
		
		String bearerToken ="Add git personal token here";
		
		given()
		  .headers("Authorization","Bearer "+bearerToken)
		  .pathParam("id", id)
		
		.when()
		  .get("https://gorest.co.in/public/v2/users/{id}")
		  
		.then()
		  .statusCode(200)
		  .log().all();
	}
}
