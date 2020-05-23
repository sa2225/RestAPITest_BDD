package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC004_PUT_Employee_record {
	
	public static HashMap map=new HashMap();
	
	String empname=RestUtils.getEmpName();
	String empsal=RestUtils.getEmpSal();
	String empage=RestUtils.getEmpAge();
	int empid=23;
	
	@BeforeClass
	public void putData() {
		
		map.put("name", empname);
		map.put("salary", empsal);
		map.put("age", empage);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+empid;
		
	}

	@Test
	public void testPutData() {
		given()
			.contentType("application/json")
			.body(map) // map contains the data
		
		.when()
			.put()
		
		.then()
			.statusCode(200)
			.and()
			.body("status", equalTo("success"))
			.log().all(); //log everything
	
	}
}
