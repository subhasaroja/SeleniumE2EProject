package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.base;

public class ValidateTitle extends base{
	public WebDriver driver;
	 public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException
	{
		
	
		 driver =initializeDriver();
		 //log.info("Driver is initialized");
			
		driver.get(prop.getProperty("url"));
		 //log.info("Navigated to Home page");
	}

	@Test
	public void basePageNavigation() throws IOException {
		/*
		 * driver=initializeDriver(); driver.get("http://qaclickacademy.com");
		 */
		log.info("Entering ValidateTitle");
		System.out.println("Entering ValidateTitle");
		LandingPage lp=new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES123");
		log.info("Successfully validated Text message");
		log.info("Exiting ValidateTitle");
		System.out.println("Exiting ValidateTitle");
		
	}
	@AfterMethod
	public void teardown()
	{
		
		driver.close();
		System.out.println("closing title browser");
	
		
	}
}
