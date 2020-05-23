package restAssuredTests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasXPath;

import org.testng.annotations.Test;

public class TC007_BasicValidations_XML {
	
	//verifying single content in xml
	
	
	@Test(priority=1)
	void testSingleContent() {
		
		given()
		
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/15")
		
		.then()
			.body("CUSTOMER.ID", equalTo("15")) //to grab xmp path, construct is using hierarchy from XML response
			.log().all();
	}
	
	
	
	@Test(priority=2)
	void testMultipleContents() {
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.ID", equalTo("15"))
			.body("CUSTOMER.FIRSTNAME", equalTo("Bill"))
			.body("CUSTOMER.LASTNAME", equalTo("Clancy"))
			.log().all();
		
	}
	
	@Test(priority=3)
	void testMultipleInOneGo() {
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body("CUSTOMER.text()", equalTo("15BillClancy319 Upland Pl.Seattle")) // using text method we can validate contents in one go.
		
			.log().all();
	}
	
	@Test(priority=4)
	void testXmlPath() {
		given()
		.when()
			.get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/15")
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME", containsString("Bill"))); // write in xPath style		
		
	}
	
	@Test(priority=5)
	void testcomplexXPath() {
		given()
		.when()
			.get("http://www.thomas-bayer.com/restnames/namesincountry.groovy?country=Germany")
		.then()
			.body(hasXPath("/restnames/nameinfo/name[text()='Renee']"))
			.log().all();
	
	}

}
