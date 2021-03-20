package dropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadFile {

	WebDriver driver;
	@Before
	public void setup()
	{
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
	}
	@Test
	public void uploadFile() throws InterruptedException
	{
		WebElement choosefile=driver.findElement(By.xpath("//input[@type='file']"));
		choosefile.sendKeys("C:\\Amruta_Dawande\\VisionIT\\test_uplod.txt");
		Thread.sleep(3000);
		
		WebElement pressButton = driver.findElement(By.xpath("//input[@type='submit']"));
		pressButton.click();
		
		WebElement textafteraddfile=driver.findElement(By.xpath("//pre[contains(text(),'Amruta is learning selenium:P')]"));
		System.out.println("text in uploaded file is : "+textafteraddfile.getText());
		
	}
	@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}
