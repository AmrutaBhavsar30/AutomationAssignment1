package com.assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Selenium2 {
	String ExpectedURL = "http://automationpractice.com/index.php";
	String Title="My Store";
	WebDriver driver;
	
	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://automationpractice.com/");
	}
	
	@Test
	public void testURL()
	{
		Assert.assertEquals("URL redirection is fail",ExpectedURL, driver.getCurrentUrl());
		System.out.println("URL redirection is success");
			
	}
	
	@Test
	public void landingpageTest()
	{
		String title=driver.getTitle();
		Assert.assertEquals("title is not matching", Title, driver.getTitle());
		System.out.println("titles are matching");
		System.out.println("current page title is : "+title);
		
	}
	
	@Test
	public void productSearch()
	{
		ArrayList<String> actualproduct=new ArrayList<>();
		actualproduct.add("WOMEN");
		actualproduct.add("DRESSES");
		actualproduct.add("SHIRTS");
	
		//List<WebElement> productsearch=driver.findElements(By.xpath("//ul[@class='sf-menu']//li[@class='sf-with']"));
		List<WebElement> productsearch=driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li/a"));
		
		System.out.println("search result count is :"+productsearch.size());
		
		for(int i=0;i<productsearch.size();i++)
		{
			//System.out.println(productsearch.get(i).getText());
		Assert.assertEquals("product list is wrong", actualproduct.get(i), productsearch.get(i).getText());
		System.out.println("product are in sequence");
		}
	}	
	
	@Test
	public void logoDisplayTest()
	{
		WebElement logoDisplay=driver.findElement(By.xpath("//img[@class='logo img-responsive']"));
		//System.out.println(logoDisplay.isDisplayed());
		Assert.assertEquals("Logo is not displayed", true, logoDisplay.isDisplayed());
		System.out.println("logo is displayed");
		
	}
	@Test
	public void logoHeight()
	{
		WebElement ht=driver.findElement(By.xpath("//img[@height='99']"));
		Assert.assertEquals("height is not matching","99", ht.getAttribute("height"));
		System.out.println("height is 99");
	}
	
	@Test
	public void logoWidth()
	{
		WebElement wth=driver.findElement(By.xpath("//img[@width='350']"));
		Assert.assertEquals("width is not matching","350", wth.getAttribute("width"));
		System.out.println("width is 350");
	}
	
	//testcase7 sighinpageTitle validation
	@Test
	public void sighinpageTitle()
	{
		
	}
	
	
}

