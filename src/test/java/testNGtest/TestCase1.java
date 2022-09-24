package testNGtest;

import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1 {

	@BeforeTest
	public void createDBconn()
	{
		System.out.println("open db connection");
	}
	
	@BeforeMethod
	
	public void launchBrowser() {
		System.out.println("launch browser");
	}
	
	@Test(priority = 2, groups = "low")
	public void doLogin() {
		System.out.println("entering password");
		Reporter.log("password entered");
	}
	
	@Test(priority = 1, groups = "high")
	public void doRegister() {
		System.out.println("Executing user rege");
		Reporter.log("user registered");
	}
	
	@AfterMethod
	public void closeBrowser() {
		
		System.out.println("closing the browser");
	}
	
	@AfterTest
	public void closeDBconn()
	{
		System.out.println("close db connection");
	}
	

}
