package creatingExtendReports;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
            
	
	static  ExtentReports extent;
	static ExtentSparkReporter reporter;
	

	public static ExtentReports extendReportRahul() {
		
//		EntentReport and ExtentSpertReporter

		String path=System.getProperty("user.dir"+"//reportsRahul//index.html");
	reporter=new ExtentSparkReporter(path);
		 reporter.config().setReportName("extend report using rahul");
		 reporter.config().setDocumentTitle("test result");
		
		          extent=new ExtentReports();
		          extent.attachReporter(reporter);
		      	
		                       
		                        
		                       return extent;
		                        
		
	}
	
	
}
