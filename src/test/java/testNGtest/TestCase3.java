package testNGtest;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

public class TestCase3 {
	
	@Test(priority = 1, groups = "med")
	public void doRegister() {
		System.out.println("Executing user rege");
		Assert.fail("failed to register");
	}

	
	@Test(priority = 2 , dependsOnMethods = "doRegister", groups = "med")
	public void doLogin() {
		System.out.println("entering password");
	}
	
	
	@Test(priority = 3, groups = "high")
	public void isSkip() {
		throw new SkipException("Skipping the test as condtion is not met");
	}

}
