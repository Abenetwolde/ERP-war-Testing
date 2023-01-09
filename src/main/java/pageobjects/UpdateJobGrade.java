package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateJobGrade {
	
	
	WebDriver driver;
	
	public UpdateJobGrade(WebDriver driver) {
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
	}

	@FindBy(xpath="	//*[@id=\"formPayGrade:drdGrade\"]/div[3]")
	private WebElement clickDropDown;
	@FindBy(xpath="	//*[@id=\"formPayGrade:drdGrade_panel\"]/div/ul/li[3]")
	private WebElement selectGrade;
//	@FindBy(id="formPayGrade:drdGrade_label")
//	private WebElement gradeSelection;
	@FindBy(id="formPayGrade:tblSalScale:0:j_idt120")
	private WebElement editLink;
	@FindBy(id="formPayGrade:txtDescription")
	private WebElement updateDiscription;
	@FindBy(id="formPayGrade:txtMaximumSalary")
	private WebElement updateMaximumSalary;
	@FindBy(id="formPayGrade:txtSalary")
	private WebElement updateSalary;
//	@FindBy(id="frmJobRegistration:dlgDpt")
//	private WebElement DepartmentModal;
	@FindBy(xpath="//*[@id=\"formPayGrade:btnAdd\"]/span")
	private WebElement AddButton;
	@FindBy(xpath="//*[@id=\"formPayGrade:btnSave\"]/span")
	private WebElement SaveButton;
	@FindBy(xpath="//*[text()='Success!']")
	private WebElement Message;


public void clickonGradeDropDownButton() {
		
	clickDropDown.click();
		
		
	}

public void SelectGrade() {

	selectGrade.click();
	
	
}
public void clickonEditAction() {

	editLink.click();
	
	
}

public void enterUpdateDiscription(String updateDiscText) {
	updateDiscription.clear();
	updateDiscription.sendKeys(updateDiscText);
		
	}
public void enterUpdateMaximumSalary(String updateMaxSalaryText) {
	updateMaximumSalary.clear();
	updateMaximumSalary.sendKeys(updateMaxSalaryText);
		
	}
public void enterUpdatedSalary(String updateMaxSalaryText) {
	updateSalary.clear();
	updateSalary.sendKeys(updateMaxSalaryText);
		
	}
public void clickonAddUpdate() {
	
	AddButton.click();
		
		
	}
public void clickonSave() {
	
	SaveButton.click();
		
		
	}
public boolean verifyUpdated() {
	boolean Status;
	
	try {
		Status = Message.isDisplayed();
	}catch(Throwable e) {
		Status = false;
	}
	
	return Status;
}
}
