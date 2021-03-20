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

public class RightClick {

	WebDriver driver;
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}


	@Test
	public void dropdown() throws InterruptedException
	{
		WebElement rightclick=driver.findElement(By.xpath("//span[text()='right click me']"));
		Thread.sleep(2000);
		Actions act=new Actions(driver);
		act.contextClick(rightclick).build().perform();
		//act.doubleClick(rightclick).build().perform();
	}
	@After
	public void end() throws InterruptedException
	{
		
		Thread.sleep(3000);
		driver.quit();
	}
}
