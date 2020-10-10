package javaMaven;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.AssertJUnit;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
	 public static ExtentReports extent;
	 public static ExtentTest extentTest ;
	 
	 @BeforeTest
	 public void  setExtend() {
		 extent =new ExtentReports(System.getProperty("user.dir")+"/test_ex/Nav_ExtentReport.html",true);
		 extent.addSystemInfo("host name","tohidur-mac");
		 extent.addSystemInfo("environment","qa-environment");
		 
		 
	 }
	 @AfterTest
	 public void andReport() {
		 extent.flush();
		 extent.close();
	 }
	 
	 public static String getScreenShots(WebDriver driver,String screenshotName) throws IOException {
		String  datename=new SimpleDateFormat("yyyyMMddhhss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir")+"/failedScreenShots/"+screenshotName+datename+".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
		     
	 }
	
	@BeforeMethod
	public void basepagesetup() throws IOException {
		
		
		System.setProperty("webdriver.chrome.driver", "/Users/tohidur/Downloads/chromedriver");
		 driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	
		
	}

	
	@Test
	public static void basepage() {
		
		extentTest=extent.startTest("basepage");
		seconntestcase st=new seconntestcase(driver);
		st.searchBox().clear();
		st.searchBox().sendKeys("ca");
		secondtestUtility.trimingproductname(driver);
		driver.findElement(By.cssSelector("cart-header-navlink")).click();
		System.out.println(driver.getTitle());
		System.out.println(driver.getPageSource());
		AssertJUnit.assertTrue(false);
		
		

	}

	@Test
public void validationlogo() {
		extentTest=extent.startTest("validationlogo");
		String logotext=driver.findElement(By.cssSelector(".brand.greenLogo")).getText();
		AssertJUnit.assertEquals(logotext,"GREENKART");
		AssertJUnit.assertFalse("greenkart", false);
		
		
		
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException {
		if(result.getStatus()==result.FAILURE) {
			extentTest.log(LogStatus.FAIL,"TEST CASE FAILED"+result.getName());
			extentTest.log(LogStatus.FAIL,"TEST CASE FAILED"+result.getThrowable());
			String screen_shots_path=secondTestRun.getScreenShots(driver, result.getName());
			extentTest.log(LogStatus.FAIL,extentTest.addScreenCapture(screen_shots_path));
		}
		else if(result.getStatus()==ITestResult.SKIP) {
			extentTest.log(LogStatus.SKIP,"test case skip"+result.getName());
		}
		extent.endTest(extentTest);
		
		driver.quit();
	}
	
	
	
	
	



	
	
	
	
	
}
