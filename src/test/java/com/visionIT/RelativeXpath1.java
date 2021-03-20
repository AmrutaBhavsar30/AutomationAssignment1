package com.visionIT;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath1 {
WebDriver driver;
String TextToBeClick="Pepe Jeans Sweatshirt";

@Before
public void setup()
{
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().deleteAllCookies();
driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

driver.get("https://www.myntra.com/");
}

@Test
public void searchBox() throws InterruptedException
{
	String title=driver.getTitle();
	System.out.println("page title is : "+title);
	WebElement searchBox = driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
	searchBox.sendKeys("pepe");
	Thread.sleep(2000);

	WebElement searchItem = driver.findElement(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null' and text()='"+TextToBeClick+"']"));
	
	searchItem.click();
	Thread.sleep(3000);

}
@After
public void teardown()
{
	driver.quit();
}
}
