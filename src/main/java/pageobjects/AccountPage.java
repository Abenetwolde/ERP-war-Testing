package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	WebElement Message = driver.findElement(By.xpath("//*[text()='Success!']"));
	private WebElement editYourAccountInformationOption;
	
	public boolean verifyLoginStatusOfUser() {
		
		boolean loginStatus;
		
		try {
			loginStatus = editYourAccountInformationOption.isDisplayed();
		}catch(Throwable e) {
			loginStatus = false;
		}
		
		return loginStatus;
		
	}

}
