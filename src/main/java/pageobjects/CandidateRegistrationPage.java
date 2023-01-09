package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CandidateRegistrationPage {
	
	
	WebDriver driver;
	
	public CandidateRegistrationPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
	}

	@FindBy(xpath="//*[@id=\"frmTop:btnNew\"]/span[1]]")
	private WebElement PluseButton;
	@FindBy(xpath="//*[@id=\"frmCandidate:somBatchCode\"]/div[3]/span")
	private WebElement drop1;
	@FindBy(xpath="//*[@id=\"frmCandidate:somBatchCode_panel\"]/div[2]/ul/li[2]")
	private WebElement select1;
	@FindBy(xpath="//*[@id=\"frmCandidate:somJobTypes\"]/div[3]")
	private WebElement drop2;
	@FindBy(xpath="//*[@id=\"frmCandidate:somJobTypes\"]/div[3]")
	private WebElement select2;
	@FindBy(id="frmCandidate:txtFirstName")
	private WebElement txtFirstName;
	@FindBy(id="frmCandidate:txtMiddleName")
	private WebElement txtMiddleName;
	@FindBy(id="frmCandidate:txtLastName")
	private WebElement txtLastName;
	@FindBy(id="frmCandidate:txtDateOfBirth")
	private WebElement txtDateOfBirth;
	@FindBy(xpath="//*[@id=\"btn26\"]")
	private WebElement selectDate;
	@FindBy(id="frmMain:txtVision")
	private WebElement txtVision;
//	@FindBy(id="frmJobRegistration:dlgDpt")
//	private WebElement DepartmentModal;
	@FindBy(xpath="//*[@id=\"frmCandidate:txtNationality\"]/div[3]")
	private WebElement nationalityDropdownIcon;
	@FindBy(xpath="//*[@id=\"frmCandidate:txtNationality_panel\"]/div/ul/li[4]")
	private WebElement selectNationality;
	@FindBy(xpath="//*[@id=\"frmCandidate:drlMaritalStatus\"]/div[3]")
	private WebElement MaritalStatusDropdownIcon;
	@FindBy(xpath="//*[@id=\"frmCandidate:drlMaritalStatus_panel\"]/div/ul/li[2]")
	private WebElement selectMaritalStatus;
	@FindBy(xpath="//*[@id=\"frmCandidate:btnResidentialAddress\"]/span")
	private WebElement AddAddressButton;
	@FindBy(id="frmCandidate:addressTree:62:nodetxt")
	private WebElement selectEthiopia;
	@FindBy(id="frmCandidate:txtHomPhoneNo")
	private WebElement txtHomPhoneNo;
	@FindBy(id="frmCandidate:txtOfficcePhoneNo")
	private WebElement txtOfficcePhoneNo;
	@FindBy(id="frmCandidate:txtRelevantSkills")
	private WebElement txtRelevantSkills;
	@FindBy(id="frmCandidate:txtOtherInformation")
	private WebElement txtOtherInformation;
	@FindBy(id="frmCandidate:txtHouseNumber")
	private WebElement txtHouseNumber;
	@FindBy(id="frmCandidate:txtMobileNo")
	private WebElement txtMobileNo;
	@FindBy(id="frmCandidate:txtPOBox")
	private WebElement txtPOBox;
	@FindBy(id="frmCandidate:txtEmail")
	private WebElement txtEmail;
	@FindBy(id="frmCandidate:txtHobbies")
	private WebElement txtHobbies;
	@FindBy(xpath="//*[@id=\"frmCandidate:btnSave\"]/span")
	private WebElement Save;
	@FindBy(xpath="//*[text()='Tenant Saved Successfully']")
	private WebElement Message;


public void clickonPluseButtonButton() {
		
	PluseButton.click();
		
		
	}
public void clickonVacancyNoButton() {
	
	drop1.click();
		
		
	}
public void selectVacancyNo() {
	
	select2.click();
		
		
	}
public void clickonJobTitleDropDown() {
	
	drop2.click();
		
		
	}
public void selectJobTitle() {
	
	select2.click();
		
		
	}

public void enterFirstName(String enterFirstName) {
	
	txtFirstName.sendKeys(enterFirstName);
		
	}

public void enterMiddleName(String enterMiddleName) {

	txtMiddleName.sendKeys(enterMiddleName);
		
	}
public void enterLastName(String enterLastName) {

	txtLastName.sendKeys(enterLastName);
		
	}
public void clickonNationalityDropDown() {
	
	nationalityDropdownIcon.click();
		
		
	}
public void selectNationality() {
	
	selectNationality.click();
		
		
	}
public void clickonDateofBirthTextField() {
	
	txtDateOfBirth.click();
		
		
	}
public void selectdate() {
	
	selectDate.click();
		
		
	}
public void clickonMaritalStatus() {
	
	MaritalStatusDropdownIcon.click();
		
		
	}
public void selectMaritalStatus() {
	
	selectMaritalStatus.click();
		
		
	}
public void clickOnAddAdressButton() {
	
	AddAddressButton.click();
		
		
	}
public void selectAddress() {
	
	selectEthiopia.click();
		
		
	}
public void enterHomePhoneNo(String enterHomePhoneNo) {

	txtHomPhoneNo.sendKeys(enterHomePhoneNo);
		
	}
public void enterOfficeNumber(String enterOfficeNumber) {

	txtOfficcePhoneNo.sendKeys(enterOfficeNumber);
		
	}
public void enterRelevantSkills(String enterRelevantSkills) {

	txtRelevantSkills.sendKeys(enterRelevantSkills);
		
	}
public void enterOtherInformation(String enterOtherInformation) {

	txtOtherInformation.sendKeys(enterOtherInformation);
		
	}
public void enterHomePhone(String enterHomePhone) {

	txtHomPhoneNo.sendKeys(enterHomePhone);
		
	}
public void enterMobile(String enterMobile) {

	txtMobileNo.sendKeys(enterMobile);
		
	}
public void enterPOBox(String enterPOBox) {

	txtPOBox.sendKeys(enterPOBox);
		
	}
public void enterEmail(String enterEmail) {

	txtEmail.sendKeys(enterEmail);
		
	}
public void enterHobbies(String enterHobbies) {

	txtHobbies.sendKeys(enterHobbies);
		
	}






//public void enterFileUrl(String url) {
//
//	fileInputButton.sendKeys(url);
//		
//	}
public void enterVision(String VisionTExt) {

	txtVision.sendKeys(VisionTExt);
		
	}

public void clickonSave() {
	
	Save.click();
		
		
	}
public boolean verifySubmition() {
	boolean Status;
	
	try {
		Status = Message.isDisplayed();
	}catch(Throwable e) {
		Status = false;
	}
	
	return Status;
}
}
