package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ParsingJsonResponseData {

	@Test(priority =1)
	public void testJsonResponse() {
		
		//Approach 1 
		
		/*
		 * given() .contentType(ContentType.JSON)
		 * 
		 * .when() .get("http://localhost:3000/store")
		 * 
		 * .then() .statusCode(200)
		 * .header("Content-Type","application/json; charset=utf-8")
		 * .body("book[1].title",equalTo("What you think about youself"));
		 * 
		 * All these validation is done by Matchers function and not by TestNG
		 * we do TestNG validation when we save the response-- like i have written in 2nd approach 
		 */
		
		//Approach 2
		
		Response res = given()
			.contentType(ContentType.JSON)
			
			.when()
			  .get("http://localhost:3000/store");
		
		   //TestNG validation
		  // res.jsonPath().get("book[1].title") == it will give value in object format,
		  // so to apply the TestNG assertion we need a value in string format, to convert in string 
		  //we need to use .asString() function 
			/*
			 * Assert.assertEquals(res.getStatusCode(), 200);
			 * Assert.assertEquals(res.header("Content-Type"),
			 * "application/json; charset=utf-8");
			 */
		  // Assert.assertEquals(res.jsonPath().get("book[1].title").toString(), "What you think about youself");
		   
			/*
			 * String bookName = res.jsonPath().get("book[1].title").toString();
			 * Assert.assertEquals(bookName, "What you think about youself");
			 */
		   
		   
	       // Print all title of books 
		   //JSONObject class -- will be use only accept string type data and give the o/p of JSON object Type 
			/*
			 * JSONObject jo =new JSONObject(res.asString()); //Converting response type
			 * response to JSON object Type for(int i=0; i<jo.getJSONArray("book").length();
			 * i++) { String bookTitle =
			 * jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			 * System.out.println(bookTitle); }
			 */
			  
		  
		    //Check particular book title is present or not 
			/*
			 * JSONObject jo =new JSONObject(res.asString()); //Converting response type
			 * response to JSON object Type boolean status = false; for(int i=0;
			 * i<jo.getJSONArray("book").length(); i++) { String bookTitle =
			 * jo.getJSONArray("book").getJSONObject(i).get("title").toString();
			 * if(bookTitle.equals("Saying of the century")) { status = true; break; } }
			 * Assert.assertEquals(status, true);
			 */
		
			  
			 //Print total price of books 
			   JSONObject jo =new JSONObject(res.asString()); //Converting response type response to JSON object Type
			    double totalPrice =0;
				   for(int i=0; i<jo.getJSONArray("book").length(); i++) {
					 String bookPrice =  jo.getJSONArray("book").getJSONObject(i).get("Price").toString();
					  
					 totalPrice = totalPrice+Double.parseDouble(bookPrice);
				   }
				   System.out.println("Total Books price is: "+totalPrice);
	}
}
