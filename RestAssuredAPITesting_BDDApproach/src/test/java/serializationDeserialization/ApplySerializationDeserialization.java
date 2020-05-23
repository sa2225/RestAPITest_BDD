package serializationDeserialization;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class ApplySerializationDeserialization {


	@Test(priority=1)
	public void postUserSerialization() {
		
		//create an object and set values in it
		User user=new User();
		
		user.setUID(101);
		user.setTitle("Saniya");
		user.setBody("Test Body");
		
		// now send object which has values in it as a file i.e. JSON format
		
		given()
			.contentType(ContentType.JSON)
			.body(user)
		.when()
			.post("http://jsonplaceholder.typicode.com/posts")
		.then()
			.statusCode(201)
			.log().all();
	
	}
	

	@Test(priority=2)
	public void getUserDeserialization() {
		 
		//get the file and extract the object back from it (its a type of User.class
		User user = 
				get("http://jsonplaceholder.typicode.com/posts/101").as(User.class);
		
		assertEquals(user.getTitle(), "Saniya");
		
	} 
	

	
	
}
