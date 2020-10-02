package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class secondtestUtility {

	
	static WebDriver  driver;
	public static void trimingproductname(WebDriver driver) {
		
		driver.findElements(By.cssSelector(".product")).size();	
		for(int i=0;i<	driver.findElements(By.cssSelector(".product")).size();i++) {
			
			String productname =driver.findElements(By.cssSelector(".product-name")).get(i).getText();
			System.out.println(productname);
			String []text=productname.split(" ");
			String Actualtext=text[0];
			String finaltext=Actualtext.trim();
			System.out.println(finaltext);
			
		
		
		}
	}
	
	
	  public void takeScreenShot() throws IOException {
		  
	    	TakesScreenshot ts=(TakesScreenshot)driver;
	    	File source=ts.getScreenshotAs(OutputType.FILE);
	    	String destinationFile=System.getProperty("user.dir")+"//reportsssss//"+".png";
	    	FileUtils.copyFile(source, new File(destinationFile));
	    	
	    	
	        }

}
