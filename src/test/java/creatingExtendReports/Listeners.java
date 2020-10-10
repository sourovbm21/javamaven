package creatingExtendReports;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import resources.base;

public class Listeners extends base implements ITestListener{
	
	ExtentReports extent=ExtentReportsNG.extendReportRahul();
	com.aventstack.extentreports.ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		 test=extent.createTest(result.getMethod().getMethodName());
		
		 
	}

	public void onTestSuccess(ITestResult result) {
		
		
		
	}


	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
		
	}

	public void onStart(ITestContext context) {
		

	}

	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
