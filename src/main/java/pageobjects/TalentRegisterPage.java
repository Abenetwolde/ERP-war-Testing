package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TalentRegisterPage {
	
	
	WebDriver driver;
	
	public TalentRegisterPage(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
	}

	@FindBy(xpath="//*[@id=\"frmHeader:btnNew\"]/span[1]")
	private WebElement PluseButton;
	@FindBy(id="frmMain:txtTenName")
	private WebElement txtTenName;
	@FindBy(id="frmMain:txtNameAb")
	private WebElement txtNameAb;
	@FindBy(id="frmMain:txtYearOfE")
	private WebElement txtYearOfE;
	@FindBy(id="frmMain:txtMissiin")
	private WebElement txtMissiin;
	@FindBy(id="frmMain:txtVision")
	private WebElement txtVision;
//	@FindBy(id="frmJobRegistration:dlgDpt")
//	private WebElement DepartmentModal;
	@FindBy(xpath="//*[@id=\"btn33\"]")
	private WebElement selectDate;
	@FindBy(xpath="//*[@id=\"frmMain:j_idt141_input\"]")
	private WebElement fileInputButton;
	@FindBy(xpath="//*[@id=\"frmMain:j_idt141\"]/div[1]/button[1]")
	private WebElement UploadButton;
	@FindBy(xpath="//*[@id=\"frmMain:btnSave\"]/span")
	private WebElement SaveButton;
	@FindBy(xpath="//*[text()='Tenant Saved Successfully']")
	private WebElement Message;


public void clickonPluseButtonButton() {
		
	PluseButton.click();
		
		
	}

public void enterTenetName(String tnateText) {
	
	txtTenName.sendKeys(tnateText);
		
	}

public void enterAbrivateName(String txtNameAbv) {

	txtNameAb.sendKeys(txtNameAbv);
		
	}
public void clickonEstablishedOnTextField() {
	txtYearOfE.click();
	
	
}
public void SelectDate() {
	selectDate.click();
	
	
}



public void clickonFileInputButton(String url) {
	
	fileInputButton.sendKeys(url);;
		
		
	}
public void clickonUploadButton() {
	
	UploadButton.click();
		
		
	}

//public void enterFileUrl(String url) {
//
//	fileInputButton.sendKeys(url);
//		
//	}
public void enterVision(String VisionTExt) {

	txtVision.sendKeys(VisionTExt);
		
	}
public void enterMission(String MissionTExt) {

	txtMissiin.sendKeys(MissionTExt);
		
	}
public void clickonSave() {
	
	SaveButton.click();
		
		
	}
public boolean verifyIfItIsRegisterd() {
	boolean Status;
	
	try {
		Status = Message.isDisplayed();
	}catch(Throwable e) {
		Status = false;
	}
	
	return Status;
}
}
