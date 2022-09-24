package testcase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestProperties {

	public static WebDriver driver;

	public static Properties OR = new Properties();

	public static Properties Confif = new Properties();

	public static Logger log = Logger.getLogger(TestProperties.class.getName());

	public static void click(String key) {
		if(key.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(key))).click();}
		if(key.endsWith("_ID")) {
			driver.findElement(By.xpath(OR.getProperty(key))).click();
			}
			
		log.info("Clicking on an Element"+ key);
		
	}
	
	public static void type(String key , String value) {
		if(key.endsWith("_XPATH")) {
		driver.findElement(By.xpath(OR.getProperty(key))).sendKeys(value);
		}
		
		else if(key.endsWith("_ID")) {
			driver.findElement(By.id(OR.getProperty(key))).sendKeys(value);
			}
			
		log.info("Typing in an Element : "+ key + "entered value as : " +value);
		
	}
	public static void main(String[] args) throws IOException {

		PropertyConfigurator.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");
		
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		OR.load(fis);

		log.info("OR prop loaded");
		// driver.findElement(By.id(OR.getProperty("username_ID")).sendKeys();
		System.out.println(OR.getProperty("username_ID"));

		Properties Config = new Properties();
		fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");

		Config.load(fis);

		log.info("Config prop loaded");

		System.out.println(Config.getProperty("browser"));
		// driver.get(Config.getProperty("testsiteurl"));
		System.out.println(Config.getProperty("testsiteurl"));

		if (Config.getProperty("browser").equals("firefox")) {

			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.info("Firefox is launched");

		} else if(Config.getProperty("browser").equals("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.info("Chrome is launched");

		}

		driver.get(Config.getProperty("testsiteurl"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(Config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		

		type("username_ID", "trainer@");
		click("nextBtn_XPATH");
		driver.quit();
		log.info("Test execution completed");
		
		
		

	}

}
