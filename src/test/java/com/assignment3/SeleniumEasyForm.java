package com.assignment3;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.junit.Assert;

public class SeleniumEasyForm {


	WebDriver driver;
	String pagetitle="Selenium Easy Demo - Simple Form to Automate using Selenium";
	String a="I am learning Selenium";

	@Before
	public void startup() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");

		try{
			WebElement popup=driver.findElement(By.linkText("No, thanks!"));
			popup.click();

		}
		catch(Exception e)
		{
			System.out.println(e);
		}	
		Thread.sleep(3000);

	}

	
	@Test
	public void validateTitle()
	{
		Assert.assertEquals("title is wrong", pagetitle, driver.getTitle());
		System.out.println("test case is pass");
	}


	@Test
	public void fillform() throws InterruptedException
	{		

		WebElement searchmsgbox=driver.findElement(By.id("user-message"));
		//searchmsgbox.sendKeys("I am learning Selenium");
		searchmsgbox.sendKeys(a);
		Thread.sleep(3000);

		WebElement clickshowmsg=driver.findElement(By.className("btn"));
		clickshowmsg.click();

		WebElement resulttext=driver.findElement(By.xpath("//span[@id='display']"));
		Assert.assertEquals("text are not matching",a,resulttext.getText());
		System.out.println("actual and result text are same");
		Thread.sleep(2000);
	}
	 
	@Test
	public void sum() throws InterruptedException
	{
		
		WebElement enterA=driver.findElement(By.id("sum1"));
		enterA.sendKeys("20");

		WebElement enterB=driver.findElement(By.id("sum2"));
		enterB.sendKeys("30");

		WebElement gettotal=driver.findElement(By.xpath("//button[@onclick='return total()' and @type='button']"));
		gettotal.click();
		int add=20+30;
		
		WebElement sum=driver.findElement(By.xpath("//span[@id='displayvalue']"));
		String total=Integer.toString(add);
		
		Assert.assertEquals("value is not matching",total,sum.getText());
		System.out.println("sum and total are matching");
		Thread.sleep(2000);
	}

	/*@After
	public void endsession()
	{

		driver.quit();
	}*/
}
