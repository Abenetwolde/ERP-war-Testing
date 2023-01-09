package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage1 {
	
	WebDriver driver;
	
	public HomePage1(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(linkText="Human Resource Management System")
	private WebElement HRMSlinkText;
	public Dashboard selectHRMSlinkTextLink() {
		
		HRMSlinkText.click();		
		return new Dashboard(driver);
		
	}
//	
//	@FindBy(xpath="//span[text()='My Account']")
//	private WebElement myAccountDropMenu;
//	
//	@FindBy(linkText="Login")
//	private WebElement loginOption;
//	
//	public void clickOnMyAccountDropMenu() {
//		
//		myAccountDropMenu.click();
//	
//	}
//	
//	public LoginPage selectLoginOption() {
//		
//		loginOption.click();
//		
//		return new LoginPage(driver);
//		
//	}

}