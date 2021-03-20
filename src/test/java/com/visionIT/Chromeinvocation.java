package com.visionIT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chromeinvocation {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.google.com");
		String pagetitle=driver.getTitle();
		System.out.println("currnet page title is : "+pagetitle);
		Thread.sleep(1000);
		String url=driver.getCurrentUrl();
		System.out.println("url of the current page is : "+url);
		
		if(pagetitle.equals("Google"))
		{
			System.out.println("page title is correct");
		}
		else
		{
			System.out.println("page title is wrong");
		}
		driver.quit();

	}

}
