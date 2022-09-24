package testNGtest;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestCase2 {

	@Test( groups = { "high","med"})
	public void getTitle() {
		
		SoftAssert softAssert = new SoftAssert();
		String actual ="Gmail.com";
		String expected="Yahoo.com";
		softAssert.assertEquals(actual, expected,"Title is not matching");
		
	//	Assert.fail("Forcefully failing the test");
	
		System.out.println("Ending");
		softAssert.assertAll();
		Reporter.log("capturing scr");
		
		
	}
}
