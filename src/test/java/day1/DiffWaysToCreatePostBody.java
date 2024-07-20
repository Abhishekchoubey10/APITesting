package day1;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class DiffWaysToCreatePostBody {
	/*
	 * @Author Abhishek Different ways to create Post Request Body 1. Using Hash map
	 * 2. Using org.json 3. Using POJO class 4. Using external json file data
	 * 
	 */

	// Post request body using hash map

//	@Test(priority=1)
	public void postUsingHashMap() {

		HashMap data = new HashMap();

		data.put("Name", "Mohan");
		data.put("location", "Delhi");
		data.put("Phone", "9388383822");

		String courseArr[] = { "C++", "Python" };
		data.put("Courses", courseArr);

		given().contentType("application/json").body(data)

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("Name", equalTo("Mohan")).body("location", equalTo("Delhi"))
				.body("Phone", equalTo("9388383822")).body("Courses[0]", equalTo("C++"))
				.body("Courses[1]", equalTo("Python")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	// Post Request body using org.json library
//	@Test(priority=1)
	public void postUsingOrgJsonLibrary() {

		JSONObject data = new JSONObject();

		data.put("Name", "Mohan");
		data.put("location", "Delhi");
		data.put("Phone", "9388383822");

		String courseArr[] = { "C++", "Python" };
		data.put("Courses", courseArr);

		given().contentType("application/json").body(data.toString())

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("Name", equalTo("Mohan")).body("location", equalTo("Delhi"))
				.body("Phone", equalTo("9388383822")).body("Courses[0]", equalTo("C++"))
				.body("Courses[1]", equalTo("Python")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	// @Test(priority=1)
	public void postUsingPOJO() {

		Pojo_PostRequests data1 = new Pojo_PostRequests();

		data1.setName("Ram");
		data1.setLocation("Delhi");
		data1.setPhone("99349328904");

		String CourseArr[] = { "C++", "Selenium" };

		data1.setCourses(CourseArr);

		given().contentType("application/json").body(data1) // here toString method is not required at time of pojo
															// class

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("Name", equalTo("Ram")).body("location", equalTo("Delhi"))
				.body("Phone", equalTo("99349328904")).body("Courses[0]", equalTo("C++"))
				.body("Courses[1]", equalTo("Selenium")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	@Test(priority=1)
	public void postUsingExternalJsonFile() throws FileNotFoundException {

		File f = new File("./src/main/resources/data/body.json");

		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);

		JSONObject data2 = new JSONObject(jt);

		given().contentType("application/json").body(data2.toString())

				.when().post("http://localhost:3000/students")

				.then().statusCode(201).body("Name", equalTo("Ram")).body("location", equalTo("Delhi"))
				.body("Phone", equalTo("99349328904")).body("Courses[0]", equalTo("C++"))
				.body("Courses[1]", equalTo("Selenium")).header("Content-Type", "application/json; charset=utf-8").log()
				.all();

	}

	// Deleting Student record
	// @Test(priority=2,dependsOnMethods = {"postUsingHashMap"})
	@Test(priority = 2)
	public void testDelete() {

		given()

				.when().delete("http://localhost:3000/students/9")

				.then().statusCode(200);
	}

}
