package restAssuredTests;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC003_POST_dummydata {
	
	public static HashMap map=new HashMap();
	
	public static String userID=RestUtils.getUserId();
	public static String body=RestUtils.getBody();
	public static String title=RestUtils.getTitle();
	
	
	
	@BeforeClass
	public void postData() {
		
		map.put("userId", userID);
		map.put("title", body);
		map.put("body", title);
	
		RestAssured.baseURI="http://jsonplaceholder.typicode.com";
		RestAssured.basePath="/posts";
	}
	
	@Test
	public void testPost() {
		
		given()
			.contentType("application/json")
			.body(map) //specify map as map contains the data
		
		
		.when()
			.post()
		
		.then()
			.statusCode(201)
			//.body("title", equalTo("somedata"))
			.and()
			.header("Content-Type", "application/json")
			.and()
			.statusLine("HTTP/1.1 201 OK");
		
	}

}
