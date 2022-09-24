package testNGtest;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {

		Reporter.log("Capture ss");

	}

	public void onTestFailure(ITestResult result) {

		Reporter.log(null);
	}

	public void onTestSkipped(ITestResult result) {

		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("<a href=\"C:\\Users\\Mithil\\Pictures\\Screenshots\\Screenshot(51).png\"target=\"_blank\">ScreenShot Link</a>");
		Reporter.log("<br>");
		Reporter.log("<a href=\"C:\\Users\\Mithil\\Pictures\\Screenshots\\Screenshot(51).png\"target=\"_blank\"><img src=\"C:\\Users\\Mithil\\Pictures\\Screenshots\\Screenshot(51).png\" height=200 width=200></a>");

	
	
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
