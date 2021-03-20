package com.visionIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com");
		String title=driver.getTitle();
		System.out.println("title on homepage is : "+title);
		
		Thread.sleep(2000);
		
		WebElement searchbox=driver.findElement(By.name("q"));
		searchbox.sendKeys("facebook login");
		
		WebElement Googlesearch=driver.findElement(By.name("btnK"));
		Googlesearch.click();
		Thread.sleep(3000);
		
		
		
		//WebElement fblogin1=driver.findElement(By.linkText("Facebook - Log In or Sign Up"));
		//fblogin1.click();
		WebElement fblogin=driver.findElement(By.partialLinkText("Log In or Sign Up"));
		fblogin.click();
		String newtitle=driver.getTitle();
		System.out.println("title after clicking on facebooklink is : "+newtitle);

	}

}
