package javaMaven;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.seconntestcase;
import resources.secondtestUtility;

public class secondTestRun{
	
	 
	 static WebDriver driver;
	
	@BeforeTest
	public void basepagesetup() throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/tohidur/Downloads/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
	}

	
	@Test
	public static void basepage() {
		
		seconntestcase st=new seconntestcase(driver);
		st.searchBox().clear();
		st.searchBox().sendKeys("ca");
		secondtestUtility.trimingproductname(driver);
		driver.findElement(By.cssSelector("cart-header-navlink")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		Assert.assertTrue(true);
		
		

	}

	@Test
public void validationlogo() {
		
		String logotext=driver.findElement(By.cssSelector(".brand.greenLogo")).getText();
		Assert.assertEquals(logotext,"GREENKART");
		Assert.assertFalse(false, "greenkart");
		
		
		
	}
	
	
	
	
	



	
	
	
	
	
}
