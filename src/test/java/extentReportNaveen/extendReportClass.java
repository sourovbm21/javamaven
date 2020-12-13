package extentReportNaveen;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class extendReportClass {

	public static WebDriver driver;
	public ExtentReports extent;
	public ExtentSparkReporter reporter;
	public ExtentTest extentTest;

	
	@BeforeTest
	public void setEntentReport() {
		
		//EntentReport and ExtentSpertReporter
//		ExtentSparkReporter reporter=new ExtentSparkReporter();
//		extent.attachReporter(reporter);
		
		
		extent=new ExtentReports(System.getProperty("user.dir")+"//extentReportFileNAV//index.html",true);
		                        extent.addSystemInfo("host name","tohidur-mac");
		                        extent.addSystemInfo("username","tohidur");
		                        
		                       
		                        
		
	}
	
	@AfterTest
	public void addReport() {
		extent.flush();
		extent.close();
	}
	
	public  String getScreenshot(WebDriver driver,String ScreenshotName) throws IOException {
		
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		File sourcefile=ts.getScreenshotAs(OutputType.FILE);
		String destination=System.getProperty("user.dir"+" //picture//"+ScreenshotName+" pic.png");
		FileUtils.copyFile(sourcefile, new File(destination));
		return destination;
	}
	
	@BeforeClass
	public static void initialdriver() {
		System.setProperty("webdriver.chrome.driver","/Users/tohidur/Downloads/chromedriver");
		ChromeOptions op=new ChromeOptions();
		op.addArguments("--headless");
		 driver=new ChromeDriver(op);
		
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
		String Text=driver.findElement(By.id("autocomplete")).getText();
		System.out.println("the text is : "+Text);
		Assert.assertEquals(Text, "unitedKingdom");
       	}
	
	@Test
	public void getalert() {
		driver.findElement(By.id("name")).sendKeys("hello");
		driver.findElement(By.id("alertbtn")).click();

		String Alerttext=driver.switchTo().alert().getText();
		System.out.println("alert message is : "+Alerttext);
		driver.switchTo().alert().accept();
		
      	}
	
	

	
	
	@AfterClass
	public void tearDown(ITestResult result) {
		
//		if(result.getStatus()==result.FAILURE) {
//			//extentTest.log(LogStatus.FAIL,"test case fail is "+result.getName());
//		}
		driver.quit();
	}
	
}
