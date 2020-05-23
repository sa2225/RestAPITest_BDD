package serializationDeserialization;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class NoSerializationDeserialization {
	
	public static HashMap map=new HashMap();
	
	
	@BeforeClass
	public void postData() {
		
		map.put("name", "Aakriti");
		map.put("salary", "11323");
		map.put("age", "25");
		
		RestAssured.baseURI="http://dummy.restapiexample.com";
		RestAssured.basePath="/create";
		
	}
	
	@Test
	public void testPostData() {
		
		given()
			.contentType(ContentType.JSON)
			.body(map)
		.when()
			.post()
		.then()
			.assertThat()
			.body("status", equalTo("success"));
	
		
		
	}

}
