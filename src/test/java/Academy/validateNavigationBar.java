package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import resources.base;

public class validateNavigationBar extends base{
	//public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException
	{
		System.out.println("Before mwthod called");
		 driver =initializeDriver();
			
		driver.get(prop.getProperty("url"));
	}
	@Test
	public void basePageNavigation() throws IOException {
		log.info("entering navbar test");
		System.out.println("entering navbar test");
		//driver=initializeDriver();
		//driver.get(prop.getProperty("url"));
		LandingPage lp=new LandingPage(driver);
		Assert.assertTrue(lp.getNavigationBar().isDisplayed());
		log.info("Navigation Bar is displayed");
		log.info("exiting navBar method");
		System.out.println("exiting navBar method");
	}
	@AfterMethod
	public void teardown()
	{
		System.out.println("closing nav driver");
		driver.close();
	}

}
