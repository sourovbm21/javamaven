package updated;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class googlDynamicDropDown {

	public static void main(String[] args) {

		
		System.setProperty("webdriver.chrome.driver","/Users/tohidur/Downloads/chromedriver");
		WebDriver driver =new ChromeDriver();
	     driver.manage().window().maximize();
	     driver.manage().deleteAllCookies();
	     
		driver.get("https://www.google.com/");
		driver.findElement(By.cssSelector(".SDkEP")).sendKeys("git");
		List <WebElement>list=driver.findElements(By.xpath("//ul[@class='erkvQe']//li/descendant::div[@class='sbl1 sbl1p']"));
		System.out.println("total list of link is : "+list);
		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().contains("github account")) {
				list.get(i).click();
			}
		}
		
		
	}

}
