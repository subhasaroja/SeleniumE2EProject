package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy(id="user_email")
	WebElement email;
	@FindBy(css="#user_password")
	WebElement password;
	@FindBy(xpath="//input[@value='Log In']")
	WebElement LogIn;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getEmail() {
		return email;
		
	}
	public WebElement getPassword() {
		return password;
		
	}
	public WebElement getLogin() {
		return LogIn;
		
	}

}
