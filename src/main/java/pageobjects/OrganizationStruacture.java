package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationStruacture {
	WebDriver driver;
	
	public OrganizationStruacture(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(linkText="Online")
	private WebElement online;
	
	public boolean verifyLoginStatusOfUser() {
		
		boolean loginStatus;
		
		try {
			loginStatus = online.isDisplayed();
		}catch(Throwable e) {
			loginStatus = false;
		}
		
		return loginStatus;
		
	}
}
