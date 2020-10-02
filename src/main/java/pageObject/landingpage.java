package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {

	WebDriver driver;
	
	By login=By.xpath("//div//nav//ul//li[4]//a[1]");
	
	
	
	public landingpage(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement login() {
		
		return driver.findElement(login);
	
	}
	
	
	
	
	
	
	
}
