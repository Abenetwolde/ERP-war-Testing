package pageobjects;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	
	WebDriver driver;
	
	public LoginPage1(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
	}

	@FindBy(id="loginform:login-username")
	private WebElement loginusername;
	
	@FindBy(id="loginform:login-password")
	private WebElement loginpassword;
	
	@FindBy(id="loginform:j_idt11")
	private WebElement loginButton;
	
//	@FindBy(xpath="//input[@value='Login']")
//	private WebElement loginButton;
	
	
	public void enterUserName(String userNameText) {
		
		loginusername.sendKeys(userNameText);
		
	}
	
	public void enterPassword(String passwordText) {
		 double parseDouble = Double.parseDouble(passwordText);
		 DecimalFormat df = new DecimalFormat("0");
	        String formatNumber = df.format(parseDouble);
		loginpassword.sendKeys(formatNumber);
		
	}
	
	public OrganizationStruacture clickOnLoginButton() {
		
		loginButton.click();
		return new OrganizationStruacture(driver);
		
	}
public RegistrationPage goToRegister() {
		
		loginButton.click();
		return new RegistrationPage(driver);
		
	}
public UpdateJobGrade goToPayGradePage() {
	
	loginButton.click();
	return new UpdateJobGrade(driver);
	
}
public TalentRegisterPage goToTalentRegisterPage() {
	
	loginButton.click();
	return new TalentRegisterPage(driver);
	
}
public RecruitmentRequestPage gotoRecruitmentRequestPage() {
	
	loginButton.click();
	return new RecruitmentRequestPage(driver);
	
}
public CandidateRegistrationPage gotoCandidateRegistrationPage() {
	
	loginButton.click();
	return new CandidateRegistrationPage(driver);
	
}

}