package day5;

import static io.restassured.RestAssured.*;

import static io.restassured.matcher.RestAssuredMatchers.*;

import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Authentication {

	@Test(priority=1)

	public void testBasicAuth() {

		

		given()

		  .auth().basic("postman", "password")

		

		.when()

		  .get("https://postman-echo.com/basic-auth")

		

		.then()

		  .statusCode(200)

		  .body("authenticated", equalTo(true))

		  .log().all();

		

		

	}

	

	@Test(priority=2)

	public void testDigestAuth() {

		

		given()

		  .auth().digest("postman", "password")

		

		.when()

		  .get("https://postman-echo.com/basic-auth")

		

		.then()

		  .statusCode(200)

		  .body("authenticated", equalTo(true))

		  .log().all();

		

		

	}

	

	@Test(priority=3)

	public void testPremtiveAuth() {

		

		given()

		  .auth().preemptive().basic("postman", "password")

		

		.when()

		  .get("https://postman-echo.com/basic-auth")

		

		.then()

		  .statusCode(200)

		  .body("authenticated", equalTo(true))

		  .log().all();

		

		

	}

	

	@Test(priority=4)

	public void testBearerTokenAuth() {

		

		//Create a String obeject and add in given headers "BrererToken" 

		System.out.println("------");

		

		given()

	//	  .headers("Authorization" ,"Bearer "+BearerToken)

		

		.when()

		  .get("https://api.github.com/user/repos")

		

		.then()

		  .statusCode(200)

		  .log().all();

	}

	

	public void testOAuth1Auth() {

		

		given()

		  .auth().oauth("ConsumerKey", "ConsumerSecrat", "accessToken", "tokenSecrat")

		

		.when()

		  .get("url")

		

		.then()

		  .statusCode(200)

		  .log().all();

	}

}


