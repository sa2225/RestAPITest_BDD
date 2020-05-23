package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.annotations.Test;

/* Status Code
 * log response
 * verifying single content in response body
 * verifying multiple content in response body
 * Setting parameters and headers when sending the request
 */

public class TC006_BasicValidations_Json {
	
	@Test(priority=1)
	public void getData() {
		given()
		
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
			
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all(); // this logs everything along with the response body
	}
	
	// Test logging
	@Test(priority=2)
	public void testLogging(){
		
		given()
		
		.when()
			.get("http://dummy.restapiexample.com/employees")
		.then()
			.statusCode(200)
			.log().all();
			
	}
	
	//verify single content in the response body. 
	@Test(priority=3)
	public void validateSingleContent() {
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.body("title", equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
			.log().all();
	}
	
	//Handling complex hierarchical json responses and validating single content by getting Json path using jJon path finder
	@Test (priority=4)
	public void validateSingleContentComplexJson() {
		given()
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.body("ad.company", equalTo( "StatusCode Weekly"))
			.log().all();
			
	}
	
	//validating multiple contents in the json response using hasItems method
	@Test(priority=5)
	public void validateMultipleContents() {
		given()
		.when()
			.get("https://reqres.in/api/users/")
		.then()
			.body("data.first_name", hasItems("George", "Charles"))
			.log().all();
	}
	
	//setting parameters and headers to the request
	@Test(priority=6)
	public void setParamsAndHeaders() {
		
		given()
			.param("first_name", "George")
			.header("MyName", "Saniya")
		.when()
			.get("https://reqres.in/api/users/2")
		.then()
			.body("ad.company", equalTo( "StatusCode Weekly"))
			.log().all();
			
	}
	
}
