package POMClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMClass {
	
	POMClass(WebDriver driver){
		PageFactory.initElements(driver, this);
		}
	
	@FindBy(xpath="//*[@name='FullName']")
	WebElement UserName;
	@FindBy (xpath="//*[@name='Email']")WebElement Email;
	@FindBy (xpath="//*[@name='CompanyName']")WebElement CompanyName;
	@FindBy (xpath="//*[@name='Contact']")WebElement Contact;
	@FindBy (xpath="//*[@name='action_submitForm']")WebElement ONCLICK;
void EnterUserName(String name ) {
UserName.sendKeys(name);
}
void EnterEmail(String email) {
	Email.sendKeys(email);
}
void EnterCompanyName(String companyname) {
	CompanyName.sendKeys(companyname);
	
}
void EnterContact(String contact) {
	Contact.sendKeys(contact);
}
void Submit() {
	ONCLICK.click();
}
}