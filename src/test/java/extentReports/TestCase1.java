package extentReports;

import java.util.Arrays;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class TestCase1 {

	public ExtentSparkReporter htmlRepoter;
	public ExtentReports extent;
	public ExtentTest test;

	@BeforeTest
	public void setReort() {
		htmlRepoter = new ExtentSparkReporter("./reports/extent.html");

		htmlRepoter.config().setEncoding("utf-8");
		htmlRepoter.config().setDocumentTitle("W2automation Reports");
		htmlRepoter.config().setReportName("Automation Test Results");
		htmlRepoter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(htmlRepoter);

		extent.setSystemInfo("Automation Tester", "Mithil");
		extent.setSystemInfo("Organization", "Mithil");
		extent.setSystemInfo("Build no", "1.1");

	}

	@AfterTest
	public void endReport() {
		extent.flush();
	}

	@Test
	public void doLoging() {

		test = extent.createTest("Login Test");
		test.log(Status.INFO, "Inside do login test");

	}

	@Test
	public void doUserReg() {

		test = extent.createTest("User Reg Test");
		test.log(Status.INFO, "Enter username");
		test.log(Status.INFO, "Enter Password");
		test.log(Status.FAIL, "Failling the test - screen shot attached");
		Assert.fail("failling user reg test");

	}

	@Test
	public void ValidateTitle() {

		test = extent.createTest("Validate title Test");
		throw new SkipException("Skipping the test case");

	}

	@AfterMethod
	public void tearDown(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String exceptionMessage = Arrays.toString(result.getThrowable().getStackTrace());
			test.fail(exceptionMessage);
			
			String screenShot = "C:\\Users\\Mithil\\Pictures\\Screenshots\\Screenshot(51).png";
			//test.fail("<b><FONT COLOR=RED>Screenshot of Failure</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(screenShot));
		
			
			//test.addScreenCaptureFromPath(exceptionMessage, screenShot);
		
			String methodName = result.getMethod().getMethodName();
			String text = "<b>TEST CASE:-"+methodName.toUpperCase()+"FAILED</b>";
			
			Markup m =	MarkupHelper.createLabel(text, ExtentColor.RED);
			test.log(Status.FAIL, m).addScreenCaptureFromPath(screenShot);

		} else if (result.getStatus() == ITestResult.SUCCESS) {

			String methodName = result.getMethod().getMethodName();
			String text = "<b>TEST CASE:-"+methodName.toUpperCase()+"PASSED</b>";
			
			Markup m =	MarkupHelper.createLabel(text, ExtentColor.GREEN);
	

			test.log(Status.PASS, m);

		} else if (result.getStatus() == ITestResult.SKIP) {

			String methodName = result.getMethod().getMethodName();
			String text = "<b>TEST CASE:-"+methodName.toUpperCase()+"Skiiped</b>";
			
			Markup m =	MarkupHelper.createLabel(text, ExtentColor.BROWN);
	
			test.log(Status.SKIP, m);

		}
	}

}
