package com.visionIT;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PageelementByID {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		//Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.get("http://demo.automationtesting.in/Index.html");
		String title=driver.getTitle();
		System.out.println("page title is: "+title);
		WebElement username=driver.findElement(By.id("email"));
		
		username.sendKeys("amrutabhavsar@gmail.com");
		
		WebElement webbutton=driver.findElement(By.id("enterimg"));
		webbutton.click();
		
		String nextpagetitle=driver.getTitle();
		System.out.println("after index page next title is : "+nextpagetitle);
		//Thread.sleep(2000);
				
		driver.navigate().to("http://www.google.co.in");
		WebElement serchbox=driver.findElement(By.name("q"));
		serchbox.sendKeys("Selenium");
		
		
		//Thread.sleep(4000);
		
		WebElement searchButton=driver.findElement(By.name("btnK"));
		searchButton.click();
		//Thread.sleep(5000);
		System.out.println("The Page Title is : " + driver.getTitle());
		driver.close();
		//driver.quit();
	}

}
