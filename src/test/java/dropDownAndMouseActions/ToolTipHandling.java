package dropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipHandling {
WebDriver driver;
@Before
public void setup()
{
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
driver.get("https://demoqa.com/tool-tips/");
}
@Test
public void dropDown() throws InterruptedException
{
WebElement hoverbutton=driver.findElement(By.id("toolTipButton"));	
Thread.sleep(2000);
Actions act=new Actions(driver);
act.moveToElement(hoverbutton).build().perform();
Thread.sleep(2000);
WebElement sugestionTextEle=driver.findElement(By.xpath("//div[@class='tooltip-inner']"));
//or
//WebElement sugestionTextEle = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));

String suggestionText = sugestionTextEle.getText();
System.out.println("Suggestion Box text is : " + suggestionText);
Assert.assertEquals("You hovered over the Button", suggestionText);
}
@After
public void teardown() throws InterruptedException
{
	
	Thread.sleep(3000);
	driver.quit();
}

}
