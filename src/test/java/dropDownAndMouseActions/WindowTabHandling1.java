package dropDownAndMouseActions;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowTabHandling1 {

	WebDriver driver;
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/browser-windows");
	}
	
	@Test
	public void windowHandle() throws InterruptedException
	{
		System.out.println("Tab handling using Set");
		WebElement Newtabbutton=driver.findElement(By.id("tabButton"));
		Newtabbutton.click();
		System.out.println("current window title is :"+driver.getTitle());
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String> it=handles.iterator();
		
		String parentwindowID=it.next();
		String childWindowID=it.next();
		
		System.out.println("parent window id is :"+parentwindowID);
		
		driver.switchTo().window(childWindowID);
		Thread.sleep(2000);
		System.out.println("child window title is :"+driver.getTitle());
		System.out.println("child window id is :"+childWindowID);
		Thread.sleep(2000);
		WebElement textInTheNextTab = driver.findElement(By.id("sampleHeading"));
		Thread.sleep(2000);
		System.out.println("After opening the tab the text available on the page is -> " + textInTheNextTab.getText());
		driver.close();
		driver.switchTo().window(parentwindowID);
		
		System.out.println("Parent window title is - " + driver.getTitle());
		System.out.println("Parent window id is - " + parentwindowID);
	
		
	}
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
	
}
