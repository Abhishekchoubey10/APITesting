package day2;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {

	@Test(priority = 1)
	public void testCookies() {

		given()

				.when().get("https://www.google.com")

				.then()
				.log().all();
		      //  .log().cookies();  //It will print only the cookies in console S

	}

	@Test(priority = 2)
	public void getCookies() {

		Response res = given()

				.when().get("https://www.google.com"); // here we must have to end and add semicolon, otherwise res
														// will not store, because if we add then method , it means it
														// is continuous method and it will skip to save the response in
														// res variable

		// get single cookies info
		//String cookie_value = res.getCookie("AEC");
		//System.out.println("Value of Cookies: " + cookie_value);
		
		//get all cookies info 
		Map<String,String> cookies_value = res.getCookies();
		//System.out.println(cookies_value.keySet());
		
		for(String K:cookies_value.keySet()) {
			String cookie_value=res.getCookie(K);
			System.out.println(K+"      "+cookie_value);
		}
		
	}

}
