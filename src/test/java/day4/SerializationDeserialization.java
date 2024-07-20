package day4;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import day1.Pojo_PostRequests;

//pojo --> Serialize ---> Json OBject ---> Deserialize ---> Pojo
public class SerializationDeserialization {

	//Pojo ---> Json (Serialization) 
	@Test(priority=1)
	public void convertPojo2Json() throws JsonProcessingException {
		
		//Created Java object using pojo class 
		//Actually POJO will provide is a Java Object 
		Pojo_PostRequests data1 = new Pojo_PostRequests();

		data1.setName("Ram");
		data1.setLocation("Delhi");
		data1.setPhone("99349328904");
        String CourseArr[] = { "C++", "Selenium" };
        data1.setCourses(CourseArr);
        
        //convert java object ---> JSON Object (Serialization) 
        ObjectMapper objMap = new ObjectMapper();  // we have import jackson databind and not a Rest Assured 
        
        String JsonData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(data1);
        
        System.out.println(JsonData);
        
        
	}
	
	//Json ---> Pojo (deserialization) 
		@Test(priority=2)
		public void convertJson2Pojo() throws JsonProcessingException {
			
			String JsonData = "{\r\n"
					+ "  \"location\" : \"Delhi\",\r\n"
					+ "  \"name\" : \"Ram\",\r\n"
					+ "  \"phone\" : \"99349328904\",\r\n"
					+ "  \"courses\" : [ \"C++\", \"Selenium\" ]\r\n"
					+ "}";
	        
	        //Convert JsonData --> Java Object
			ObjectMapper objMap = new ObjectMapper();
			
			Pojo_PostRequests stupojo = objMap.readValue(JsonData,Pojo_PostRequests.class);
			
			System.out.println("Name: "+stupojo.getName());
			System.out.println("Location: "+stupojo.getLocation());
			System.out.println("Phone: "+stupojo.getPhone());
			System.out.println("Course 1: "+stupojo.getCourses()[0]);
			System.out.println("Course 2: "+stupojo.getCourses()[1]);
			
			
		}
	
}
