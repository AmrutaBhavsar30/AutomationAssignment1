package dropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandlingBySelectClass {

	WebDriver driver;
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}
	@Test
	public void dropDown() throws InterruptedException
	{
		WebElement creatnewAcountButton=driver.findElement(By.xpath("//a[@role='button' and text()= 'Create New Account']"));
		creatnewAcountButton.click();
		WebElement bday=driver.findElement(By.id("day"));
		WebElement birthMonth = driver.findElement(By.id("month"));
		WebElement birthYear = driver.findElement(By.id("year"));
		Select dayselect=new Select(bday);
		dayselect.selectByVisibleText("30");
		
		Select monthselect=new Select(birthMonth);
		monthselect.selectByVisibleText("May");
		
		Select yrselect=new Select(birthYear);
		yrselect.selectByVisibleText("1990");
		Thread.sleep(3000);
	}
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.quit();
	}
}

