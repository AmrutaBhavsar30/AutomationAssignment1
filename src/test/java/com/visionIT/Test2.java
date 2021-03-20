package com.visionIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver.exe");

		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize(); 
		driver.manage().deleteAllCookies(); 
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 

		
		driver.get("http://www.google.co.in");
		
		
		WebElement searchBox = driver.findElement(By.name("q"));
		
		
		searchBox.sendKeys("Selenium");
		
		Thread.sleep(4000);
		
		WebElement searchButton = driver.findElement(By.name("btnK"));
		
		searchButton.click();
		
		Thread.sleep(5000);
		
		System.out.println("The Page Title is : " + driver.getTitle());

			//driver.quit();


	}

}
