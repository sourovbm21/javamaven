package javaMaven;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pageObject.landingpage;
import pageObject.loginPage;
import resources.Xls_Reader;
import resources.base;
import resources.excelData;

public class homepage extends base {
	
	Logger log=Logger.getLogger(homepage.class);
	
	static ExtentReports extent;
	@BeforeTest

	public static ExtentReports config()

	{

	String path=System.getProperty("user.dir")+"\\reports\\index.html";

	ExtentSparkReporter reporter=new ExtentSparkReporter(path);

	reporter.config().setReportName("We Automation Result");

	reporter.config().setDocumentTitle("Test Results");

	extent=new ExtentReports();

	extent.attachReporter(reporter);

	extent.setSystemInfo("Tester", "Ramesh K");
	return extent;

	}
	
	@BeforeMethod
	public void driver() throws IOException {
		
		
		driver=	initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	
		
	}

	@Test(dataProvider="getTestdata")
	public void  bassepage(String email,String password) throws IOException {
	
	
	
	landingpage ln=new landingpage(driver);
	ln.login().click();
	
		loginPage lp=new loginPage(driver);
		lp.getemail().sendKeys(email);
		log.info("sending email");
		lp.getpassword().sendKeys(password);
		log.info("sending password");
		lp.getloginbutton().click();
	
		
	}
	

	@DataProvider
	public Iterator<Object[]> getTestdata() {
		ArrayList<Object[]>testdata=excelData.getDatafromExcel();
		return testdata.iterator();
	}
	
	
	
	@AfterMethod
	
	public void teardown() {
		driver.quit();
	}
	
}
