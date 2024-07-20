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

public class CreateUser {

	@Test
	public void test_CreateUserData(ITestContext context) {
		
		Faker  faker = new Faker();
		
		JSONObject data = new JSONObject();
		
		data.put("name", faker.name().fullName());
		data.put("gender", "Male");
		data.put("email", faker.internet().emailAddress());
		data.put("status", "inactive");
		
		String bearerToken ="2fdaf9a021f14137192afa000dd3c2cbad4833aaf52f2c106a9b728d0b003455";
		

		 RequestSpecification request = given()
	      .headers("Authorization","Bearer "+bearerToken)
	      .contentType("application/json")
	      .body(data.toString());
		
	    Response response = request
		.when()
		 .post("https://gorest.co.in/public/v2/users");
		Integer id = response.jsonPath().getInt("id");
		
		 System.out.println("System generated id is: "+id);
		 context.setAttribute("user_id", id);  //now we have create a variable for id, that we use in get, update and delete
	
		
		
	}
	
}
