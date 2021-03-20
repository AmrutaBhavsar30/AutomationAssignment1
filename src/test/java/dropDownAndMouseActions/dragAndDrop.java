package dropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class dragAndDrop {
	WebDriver driver;
	
	@Before
	public void setup()
	{
		
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.get("https://demoqa.com/droppable");
	}
	@Test
	public void dragAndeDrop() throws InterruptedException
	{
		
		
		// Alternate way for url:"https://jqueryui.com/droppable/"
		//driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement drag=driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions act=new Actions(driver);
		dragAndDrop act1=new dragAndDrop();
		Thread.sleep(2000);
		
		//act.clickAndHold(drag).moveToElement(drop).build().perform();
		act.dragAndDrop(drag, drop).build().perform();
		
	}
	@After
	public void endsesssion() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}

}
