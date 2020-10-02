package updated;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class amazon {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/tohidur/Downloads/chromedriver");
		WebDriver driver = new ChromeDriver();
		//driver.get("https://www.amazon.co.uk/");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		/*Actions a = new Actions(driver);
		//a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				//.doubleClick().build().perform();

		WebElement move = driver.findElement(By.cssSelector("#nav-link-accountList"));
		a.moveToElement(move).build().perform();
	driver.findElement(By.xpath("//div[@id='nav-flyout-accountList'] //span[@class='nav-action-inner']")).click();
	System.out.println(driver.getTitle());
      driver.findElement(By.cssSelector(".a-link-normal:nth-child(2)")).click();
    System.out.println("before swiching "+ driver.getTitle());
 Set<String>  ids= driver.getWindowHandles();
 Iterator<String> it=ids.iterator();
 String parentid=it.next();
 String childid=it.next();
 driver.switchTo().window(childid);
 System.out.println("after swiching "+driver.getTitle());
 driver.switchTo().window(parentid);
System.out.println("after swiching "+driver.getTitle());*/
//window handles		
/*driver.get("http://the-internet.herokuapp.com/");
driver.findElement(By.xpath("//a[contains(text(),'Multiple Windows')]")).click();
driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();
Set<String> ids=driver.getWindowHandles();
Iterator<String> it=ids.iterator();
String parent=it.next();
String child=it.next();
driver.switchTo().window(child);
System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
driver.switchTo().window(parent);
System.out.println(driver.findElement(By.xpath(" //h3[contains(text(),'Opening a new window')]")).getText());*/
 //frames
	/*	driver.get("https://jqueryui.com/");
		
        driver.findElement(By.xpath("//a[contains(text(),'Droppable')]")).click();
        driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        WebElement source=driver.findElement(By.id("draggable"));
		WebElement target=driver.findElement(By.id("droppable"));
		Actions a=new Actions(driver);
		a.dragAndDrop(source, target).build().perform();*/
		
//amazon link 
		driver.get("https://www.amazon.co.uk/");
	int totalLinkCount=	driver.findElements(By.tagName("a")).size();
	System.out.println(totalLinkCount);
	WebElement footerdriver=driver.findElement(By.cssSelector("#navFooter"));
	int footerLink=footerdriver.findElements(By.tagName("a")).size();
	System.out.println(footerLink);
	WebElement columlinkdriver=driver.findElement(By.xpath("//div[@class='navFooterVerticalColumn navAccessibility']//div[3]"));
	int columnlink=columlinkdriver.findElements(By.tagName("a")).size();
	System.out.println(columnlink);
	
	for (int i=0;i<columnlink;i++) 
	{
	String clickOnLink=	Keys.chord(Keys.COMMAND,Keys.ENTER);
	columlinkdriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
	Thread.sleep(3l);
	}
	 Set<String> ids= driver.getWindowHandles();
	 Iterator<String> it=ids.iterator();
	 
	       while(it.hasNext())
	       {
	    	driver.switchTo().window(it.next());
	    	System.out.println(driver.getTitle());
	    	
	       }
	
		
		
		
        
        
        
        
	}

}
