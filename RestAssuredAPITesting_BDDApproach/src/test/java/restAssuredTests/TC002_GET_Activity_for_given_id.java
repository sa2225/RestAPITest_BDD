package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class TC002_GET_Activity_for_given_id {
	
	@Test
	public void getActivityDetailsForGivenID() {
		given()
		.when()
			.get("https://fakerestapi.azurewebsites.net/api/Activities/1")
		.then()
			.statusCode(200)
			.assertThat().body("Title", equalTo("Activity 1"))
			.header("Content-Encoding", "gzip")
			.statusLine("HTTP/1.1 200 OK");	
		
		
	}

}
