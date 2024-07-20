package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidation {

	@Test(priority =1)
	public void JSONSchemaValidation() {
		
		given()
		
		.when()
		  .get("http://localhost:3000/store")
		  
		 .then()
		   .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("storesSchema.json"));
		  // When we are validating xml schema -- that time we actaully converted xml to xsd using online xml to xsd converter 
		 // so at place of "JsonSchemaValidator.matchesJsonSchemaInClasspath" we have write "RestAssuredMatchers.matchesXsdInClasspath"
		
	}
	
}
