package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import resources.base;

public class HomePage extends base{
	//public WebDriver driver;
	public static Logger log =LogManager.getLogger(base.class.getName());
	@BeforeMethod
	public void initialize() throws IOException
	{
	
		 driver =initializeDriver();

	}
	
	@Test(dataProvider="getData")
	
	public void basePageNavigation(String username,String password) throws IOException {
		//driver=initializeDriver();
		log.info("Entering HomePage method");
		System.out.println("Entering HomePage method");
		driver.get("http://qaclickacademy.com");
		LandingPage lp=new LandingPage(driver);
		lp.getLogin().click();
		LoginPage lop=new LoginPage(driver);
		lop.getEmail().sendKeys(username);
		lop.getPassword().sendKeys(password);
		lop.getLogin().click();
		log.info("Exiting HomePage method");
		System.out.println("Exiting HomePage method");
	}
	@DataProvider
	public Object[][] getData() {
		Object[][] data=new Object[2][2];
		data[0][0]="nonrestricteduser@qw.com";
		data[0][1]="123456";
		data[1][0]="restricteduser@qw.com";
		data[1][1]="1234";
		return data;
		
	}
	@AfterMethod
	public void teardown()
	{
		
		driver.close();
	System.out.println("closing homepage title");
		
	}

}
