package com.visionIT;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RelativeXpath {
WebDriver driver;
String textToBeclick="Pepe T Shirts";

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
WebElement searchBox=driver.findElement(By.xpath("//input[@class='desktop-searchBar']"));
searchBox.sendKeys("pepe");
Thread.sleep(5000);

List <WebElement> searchlist=driver.findElements(By.xpath("//ul[@class='desktop-group']//li[@class='desktop-suggestion null']"));
System.out.println("The search result count is :> " + searchlist.size());

for(int i=0;i<searchlist.size();i++)
{
if(searchlist.get(i).getText().equals(textToBeclick))
{
searchlist.get(i).click();

List<WebElement> allPricesOfMensJackets = driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));


System.out.println("All Jackets prices are as below -> ");

int x = 0;

for (int j = 0; j < allPricesOfMensJackets.size(); j++) 
{
	System.out.println(allPricesOfMensJackets.get(j).getText());
	x = x + Integer.valueOf(allPricesOfMensJackets.get(j).getText().substring(5));
}
	System.out.println("Total for all " +  textToBeclick + " is +-> " + x);

}
}
Thread.sleep(3000);
}
@After
public void teardown()
{
	driver.quit();
}
}
