package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(linkText="Organization Information")
	private WebElement OrganizationInformationText;
	
	@FindBy(linkText="Job Registration")
	private WebElement JobRegistrationText;
	
	@FindBy(linkText="Pay Grade")
	private WebElement PayGradeText;
	
	@FindBy(linkText="Register Tenant")
	private WebElement registerTenaText;
	@FindBy(linkText="Recruitment")
	private WebElement RecruitmentText;
	@FindBy(linkText="Candidate Registration")
	private WebElement CandidateRegistrationText;
	@FindBy(linkText="Recruitment Request")
	private WebElement RecruitmentRequestText;
public void clickOrganizationInformationDropMenu() {
		
	OrganizationInformationText.click();
	
	}
public void clickRecruitmentTextDropMenu() {
	
	RecruitmentText.click();
	
	}
public LoginPage1 gotoCandidateRegistration() {
	
	CandidateRegistrationText.click();
	
	return new LoginPage1(driver);
	
}
public LoginPage1 RecruitmentRequestPage() {
	
	RecruitmentRequestText.click();
	
	return new LoginPage1(driver);
	
}

public LoginPage1 selectLoginOption() {
	
	JobRegistrationText.click();
	
	return new LoginPage1(driver);
	
}
public LoginPage1 selectPayGradeOption() {
	
	PayGradeText.click();
	
	return new LoginPage1(driver);
	
}
public LoginPage1 goToRegisterTenat() {
	
	registerTenaText.click();
	
	return new LoginPage1(driver);
	
}

}