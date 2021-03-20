package dropDownAndMouseActions;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandle1 {

	WebDriver driver;

	@Before
	public void setUp()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.automationtesting.in/Alerts.html");
	}

	@SuppressWarnings("deprecation")
	@Test
	public void alertHandle() throws InterruptedException
	{
		WebElement alertbutton=driver.findElement(By.xpath("//button[contains(text(),'click the button to display an  alert box:')]"));
		alertbutton.click();
		Alert alert=driver.switchTo().alert();
		Thread.sleep(2000);
		System.out.println("text of alert is : "+alert.getText());
		Assert.assertEquals("alert text is not matching","I am an alert box!",alert.getText());
		System.out.println("alert text n actull text are matching");
		alert.accept();
	}
	/*@After
	public void teardown() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}*/
}
