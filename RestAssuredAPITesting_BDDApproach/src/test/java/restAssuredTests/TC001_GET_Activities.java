package restAssuredTests;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

	/*
 * given()
Set cookies, add auth, add param, set headers info etc.
when()
Get, post, put, delete
then()
Validate status code,extract response, status line, verify response body, headers
 */

public class TC001_GET_Activities {

	@Test
	public void getActivities() {
		given()
		.when()
			.get("https://fakerestapi.azurewebsites.net/api/Activities")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-Type", "application/json; charset=utf-8");

	}

}
