package creatingExtendReports;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class extendReportRahul {

	
	
	
	
	
	public static WebDriver driver;
	public static  ExtentReports extent;
	public static ExtentSparkReporter reporter;

	
//	@BeforeTest
//	public static ExtentReports extendReportRahul() {
//	
////		EntentReport and ExtentSpertReporter
//
////	extent.attachReporter(reporter);
//		String path=System.getProperty("user.dir"+"\\reportsRahul\\index.html");
//		 reporter=new ExtentSparkReporter(path);
//		 reporter.config().setReportName("extend report using rahul");
//		 reporter.config().setDocumentTitle("test result");
//		
//		          extent=new ExtentReports(path);
//		      	
//		                        extent.addSystemInfo("host name","tohidur-mac");
//		                        extent.addSystemInfo("username","tohidur");
//		                        
//		                       return extent;
//		                        
//		
//	}
//	
//	@AfterTest
//	public void addReport() {
//		extent.flush();
//		extent.close();
//	}
	
	public void getScreenshot() throws IOException {
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir"+"//picture//pic.png");
		FileUtils.copyFile(sourcefile, new File(destination));
	}
	
	@BeforeTest
	public static void initialdriver() {
		System.setProperty("webdriver.chrome.driver","/Users/tohidur/Downloads/chromedriver");
		 driver=new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	
		}
	
	@BeforeMethod
	public void printing(){
		
		System.out.println("i am starting a method");
		
	         }
	 
        @Test
        public void getTitle() {
	         
        	String titleName=driver.getTitle();
        	System.out.println("title name is : "+titleName);
        	Assert.assertEquals(titleName,"Practice Page");
               }

	@Test
	public static void suggestion() throws InterruptedException {
		//driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.findElement(By.id("autocomplete")).sendKeys("unitedKingdom");
		
       	}
	
	@Test
	public void getalert() {
		driver.findElement(By.id("name")).sendKeys("hello");
		driver.findElement(By.id("alertbtn")).click();

		String Alerttext=driver.switchTo().alert().getText();
		System.out.println("alert message is : "+Alerttext);
		driver.switchTo().alert().accept();
		
      	}
	
	

	
	
	@AfterTest
	public void tearDown() {
		
		driver.quit();
	}
}
