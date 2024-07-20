package day6;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateUser {

	@Test
	public void test_UpdateUserData(ITestContext context) {
		
		Faker  faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken ="2fdaf9a021f14137192afa000dd3c2cbad4833aaf52f2c106a9b728d0b003455";
		
         int id =(int) context.getAttribute("user_id");  //We will get this from create user test class
		
		 given()
	      .headers("Authorization","Bearer "+bearerToken)
	      .contentType("application/json")
	      .body(data.toString())
	      .pathParam("id", id)
	
		.when()
		  .put("https://gorest.co.in/public/v2/users/{id}")
		
		.then()
		  .statusCode(200)
		  .log().all();
	
		
		
	}
}
