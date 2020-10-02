package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class seconntestcase {

	
	WebDriver driver;
	
	By Search =By.cssSelector(".search-keyword");
	
	
	
	
	public seconntestcase(WebDriver driver) {
		this.driver=driver;
	}

	
	
	public WebElement   searchBox() {
		
		
		return driver.findElement(Search);
		
	}
	
	
	
	
}
