package updated;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class totalCountLinks {

	public static void main(String[] args) throws IOException {
		

		

		System.setProperty("webdriver.chrome.driver", "/Users/tohidur/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
	//how to count all links in a webpage and how get text of all links present in that page	
//		driver.get("https://www.amazon.co.uk/");
//		List<WebElement>link_list=driver.findElements(By.tagName("a"));
//		
//		System.out.println(link_list.size());
//		
//		for(int i=0;i<link_list.size();i++) {
//			
//			System.out.println(link_list.get(i).getText());
//		}
//		
		
//how to find broken links and images 	
		
		
		driver.get("https://www.ebay.com/");
		List<WebElement>link_list=driver.findElements(By.tagName("a"));
		List<WebElement>img_list=driver.findElements(By.tagName("img"));
		
		System.out.println("size of all links in this page : "+link_list.size());
		System.out.println("size of all image in this page : "+img_list.size());
		link_list.addAll(img_list);
		
		List<WebElement> active_links=new ArrayList();
		
		for(int i=0;i<link_list.size();i++) {
			
			System.out.println(link_list.get(i).getAttribute("href"));
			if(link_list.get(i).getAttribute("href")!=null && (! link_list.get(i).getAttribute("href").contains("javascript")) ) {
				active_links.add(link_list.get(i));
				
			}
		}
	
		System.out.println("size of all active links in this page : "+active_links.size());
		
		//check the href url with httpconnection api;
		
		
		
		for(int j=0;j<active_links.size();j++) {
			
			HttpURLConnection connection=(HttpURLConnection) new URL(active_links.get(j).getAttribute("href")).openConnection();
			connection.connect();
			String response=connection.getResponseMessage();
			connection.disconnect();
		System.out.println(active_links.get(j).getAttribute("href") +" -->"+response);
		}
		
		
		
		driver.quit();
		
		
		
	}

}
