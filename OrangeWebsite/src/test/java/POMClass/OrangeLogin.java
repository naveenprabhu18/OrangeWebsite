package POMClass;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
	obj.Submit();
	Thread.sleep(7000);
}
@AfterClass
void logOut() {
	driver.close();
}
}
