package restAssuredTests;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {
	
	public static String getUserId() {
		
		String generatedstring=RandomStringUtils.randomNumeric(3);
		return(generatedstring);
	
	}
	
	public static String getTitle() {
		String generatedstring=RandomStringUtils.randomAlphabetic(10);
		return("Title is"+generatedstring);
	}
	
	
	public static String getBody() {
		String generatedstring=RandomStringUtils.randomAlphabetic(100);
		return("Body is"+generatedstring);
	}
	
	
	public static String getEmpName() {
		String generatedstring=RandomStringUtils.randomAlphabetic(5);
		return("Saniya"+generatedstring);
	}
	
	public static String getEmpSal() {
		String generatedstring=RandomStringUtils.randomNumeric(3);
		return(generatedstring);
	}
	
	public static String getEmpAge(){
		String generatedstring=RandomStringUtils.randomNumeric(2);
		return(generatedstring);
	}

	}


