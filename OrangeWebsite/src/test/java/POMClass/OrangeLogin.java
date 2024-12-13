package POMClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class OrangeLogin {
	WebDriver driver; 
@BeforeClass
	void ViewPortal() {
	driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://orangehrmlive.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Pricing']")).click();
		
		}
@Test
void POM() throws InterruptedException {
	
	POMClass obj= new POMClass(driver);
	
	obj.EnterUserName("Admin");
	obj.EnterEmail("Orange@gmail.com");
	obj.EnterCompanyName("ORANGE");
	obj.EnterContact("123456789");
	
	
	//DropDown
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement drop = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='Form_getForm_Country']")));
	 Select dropDown=new Select(drop);
	 dropDown.selectByValue("Afghanistan");
	
	
	WebElement drop2=driver.findElement(By.xpath("//*[@id='Form_getForm_NoOfEmployees']"));
	Select dropDown2= new Select(drop2);
	 dropDown2.selectByValue("11 - 50");
	obj.Submit();
	Thread.sleep(7000);
}
@AfterClass
void logOut() {
	driver.close();
}
}
