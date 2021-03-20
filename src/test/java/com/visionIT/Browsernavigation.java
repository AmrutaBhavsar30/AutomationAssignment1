package com.visionIT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browsernavigation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com");
		String pagetitle=driver.getTitle();
		System.out.println("page title is : "+pagetitle);
		Thread.sleep(2000);
		
		String url=driver.getCurrentUrl();
		System.out.println("current page url is : "+url);
		Thread.sleep(2000);
		
		if(pagetitle.equals("google"))
		{
			System.out.println("page title is correct");
		}
		else
		{
			System.out.println("page title is wrong");
		}
		Thread.sleep(3000);
		
		driver.navigate().to("https://www.facebook.com");
		String pagrtitle1=driver.getTitle();
		System.out.println("aftre navigating pagetitle is now : "+pagrtitle1);
		
		driver.navigate().back();
		Thread.sleep(1000);
		driver.close();
		

	}

}
