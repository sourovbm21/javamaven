package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		
		prop=new Properties();
		FileInputStream fis=new FileInputStream("/Users/tohidur/Downloads/javaMaven/src/main/java/resources/data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		 
		if (browserName.equalsIgnoreCase("chrome")  )///Users/tohidur/Downloads
		{
			System.setProperty("webdriver.chrome.driver", "/Users/tohidur/Downloads/chromedriver");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox")) 
		{
			driver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("IE")) 
		{
			//driver=new ie();
		}
		
	
	driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
	
	return driver;
	
		
	}
	public void getScreenshotPath(String testCaseName,WebDriver driver) throws IOException 
	{
		TakesScreenshot	ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		String destinationFile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png" ;
		FileUtils.copyFile(source,new File(destinationFile));
	}
}
