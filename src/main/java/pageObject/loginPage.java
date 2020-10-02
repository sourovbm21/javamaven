package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {
	
	public WebDriver driver;
	
	
	
	
  By email=	By.id("user_email");
	By password=By.name(" password");
	By loginbutton=By.name("commit");
	
	//@FindBy(xpath="//input[@type='password']")
	public loginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getemail() {
		
		return driver.findElement(email);
	}
	
	public WebElement getpassword() {
		
		return driver.findElement(password);
	}
	

	public WebElement getloginbutton() {
		
		return driver.findElement(loginbutton);
	}
	
	
}
