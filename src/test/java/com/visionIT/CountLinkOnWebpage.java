package com.visionIT;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CountLinkOnWebpage {
	
	@Test
	public void findlinks() throws InterruptedException
	{
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	
	driver.get("https://www.google.co.in");
	List<WebElement> linksOnThePage=driver.findElements(By.tagName("a"));
	System.out.println("total no of links on the page are : "+linksOnThePage.size());
	
	System.out.println("text of all links are as below :");
	
	for(int i=0;i<linksOnThePage.size();i++)
	{
		System.out.println((i+1)+"."+linksOnThePage.get(i).getText());
		System.out.println(linksOnThePage.get(i).getAttribute("href"));
		
	}
	System.out.println("111------------------------------------------------------");
		
		System.out.println("text of all links withput blank value are : ");
		
		for(int i=0;i<linksOnThePage.size();i++)
		{
			if(!(linksOnThePage.get(i).getText().isEmpty()))
			{
				System.out.println((i+1) +" . "+linksOnThePage.get(i).getText());
			}
			
		}
		
		
		Thread.sleep(1000);
		driver.quit();
	}
	}

