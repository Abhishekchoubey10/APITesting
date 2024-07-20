package day5;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;


public class FakerDataGenerator {

	@Test
	public void testGeneateData() {
	
		Faker  faker = new Faker();
		
		String fullName = faker.name().fullName();
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		
		String username =faker.name().username();
		String password =faker.internet().password();
		
		String mobileNo =faker.phoneNumber().cellPhone();
		String email=faker.internet().safeEmailAddress();
		
		System.out.println("Full Name: "+fullName);
		System.out.println("First Name: "+firstName);
		System.out.println("Last Name: "+lastName);
		System.out.println("UserName: "+username);
		System.out.println("Password: "+password);
		System.out.println("Mobile Number: "+mobileNo);
		System.out.println("Email: "+email);
		
	}
	
	
    
	
}
