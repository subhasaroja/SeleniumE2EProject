package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
public WebDriver initializeDriver() throws IOException {
	prop=new Properties();
	
	FileInputStream fis=new FileInputStream("E:\\subha\\softwares\\selenium_workspace\\E2EProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	String browserName=prop.getProperty("browser");
	switch (browserName) {
	case "chrome":
		System.setProperty("webdriver.chrome.driver", "E:\\subha\\softwares\\chromedriver_win32\\chromedriver.exe");
	driver=new ChromeDriver();
		break;
     case "firefox":
    	 System.setProperty("webdriver.gecko.driver", "E:\\subha\\softwares\\geckodriver-v0.31.0-win64\\geckodriver.exe");
    	 driver=new FirefoxDriver();
		break;
     case "IE":
 		
 		break;
	default:
		break;
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	return driver;
}

public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException {
	TakesScreenshot ts=(TakesScreenshot) driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destination=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
	FileUtils.copyFile(source,new File(destination));
	return destination;
}
}
