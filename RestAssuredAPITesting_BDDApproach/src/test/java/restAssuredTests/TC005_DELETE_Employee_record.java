package restAssuredTests;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC005_DELETE_Employee_record {
	
	
	@Test
	public void deleteEmployeeRecord() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/1 ";
		
		Response response=
		given()
		.when()
			.delete()
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			//.body("status", equalTo("success"))
			//.body("message", equalTo("successfully! deleted Records"))
			.log().all()
			.extract().response(); // extract the response
		
		String jsonAsString=response.asString(); // get it as String
		Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"), true); // assert the delete message
		
			
				
	} 

}
