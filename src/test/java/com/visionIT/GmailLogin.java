package com.visionIT;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLogin {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrom.driver","chromediver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
		driver.get("https://accounts.google.com/");
		String title=driver.getTitle();
		System.out.println("title of home page is : "+title);
		
		WebElement email=driver.findElement(By.id("identifierId"));
		email.sendKeys("bhavsaramruta30@gmail.com");
		
		Thread.sleep(2000);
		WebElement nextbutton=driver.findElement(By.className("VfPpkd-RLmnJb"));
		nextbutton.click();

	}

}
