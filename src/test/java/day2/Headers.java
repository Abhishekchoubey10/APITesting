package day2;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.http.*;

public class Headers {

	@Test(priority = 1)
	public void testHeaders() {

		given()

				.when().get("https://www.google.com/")

				.then().header("Content-Type", "text/html; charset=ISO-8859-1")
				.header("Content-Encoding", "gzip")
				.header("Server", "gws")
				.log().all();
		      //  .log().Headers();  //print all headers with its value in console
		      //  .log().body();     //print only response in console

		// we can also add like this
		// .then()
		// .header("Content-Type", "text/html; charset=ISO-8859-1")
		// .and()
		// .header("Content-Encoding", "gzip")
		// .add()
		// .header("Server", "gws")

	}

	@Test(priority = 2)
	public void getHeaders() {

		Response res = given()

				.when().get("https://www.google.com");

		// Get Single Headers
		String header_value = res.getHeader("Content-Type");
		System.out.println("Value of Header: " + header_value);

		// get all headers
		io.restassured.http.Headers Headers_values = res.getHeaders();

		for (Header hp : Headers_values) {
			System.out.println(hp.getName() + "   " + hp.getValue());

		}

	}

}
