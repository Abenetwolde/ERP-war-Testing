package pageobjects;

//import java.text.DecimalFormat;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RecruitmentRequestPage {
	
	WebDriver driver;
	
	public RecruitmentRequestPage(WebDriver driver) {
		
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
		
	}

	@FindBy(xpath="//*[@id=\"frmSample:btnNew\"]/span[1]")
	private WebElement AddIcon;
	@FindBy(xpath="//*[@id=\"frmRecruitment:txttenantId\"]/div[3]")
	private WebElement TenatDropdownIcon;
	@FindBy(xpath="//*[@id=\"frmRecruitment:txttenantId_panel\"]/div/ul/li[2]")
	private WebElement selectTenatName;
	@FindBy(id="frmRecruitment:txtRequester_input")
	private WebElement RequesterId;
	@FindBy(xpath="//*[@id=\"frmRecruitment:txtJob\"]/div[3]")
	private WebElement jobTitleDropDownIcon;
	@FindBy(xpath="//*[@id=\"frmRecruitment:txtJob_panel\"]/div/ul/li[3]")
	private WebElement selectJobTitle;
	@FindBy(id="frmRecruitment:txtNoOfEmployee")
	private WebElement NumberofemployeesrequestedText;
	@FindBy(id="frmRecruitment:txtCommentGiven")
	private WebElement commentGivenText;
	@FindBy(xpath="//*[@id=\"frmRecruitment:btnSave\"]/span")
	private WebElement saveButton;
	@FindBy(xpath="//*[@id=\"frmRecruitment:txtRequester_panel\"]/table/tbody/tr")
	private WebElement selectTable;
	@FindBy(xpath="//*[text()='Success!']")
	private WebElement Message;
//sq-100
	

	

public void clickOnRecruitmentRequestsButton() {
		
	AddIcon.click();
		
		
	}
public void clickOnTenatNameDropDownIcon() {
	TenatDropdownIcon.click();
		
		
	}
public void clickOnSelectTenatName() {
	selectTenatName.click();
		
		
	}

public void enterRequester_Id(String userNameText) {
		
	RequesterId.sendKeys(userNameText);
		
	}
public void clickonTable() {
	
	selectTable.click();
		
		
	}
public void clickonJobTitleDropDownIconButton() {
	
	jobTitleDropDownIcon.click();
		
		
	}
public void selectOnJobTitle() {
	
	selectJobTitle.click();
		
		
	}
public void enterNumberofEmployeesRequested(String txtNoOfEmployee) {
//	 double parseDouble = Double.parseDouble(txtNoOfEmployee);
//	 DecimalFormat df = new DecimalFormat("0");
//       String formatNumber = df.format(parseDouble);
	
	NumberofemployeesrequestedText.sendKeys(txtNoOfEmployee);
		
	}
public void enterComment(String txtComment) {
	
	commentGivenText.sendKeys(txtComment);
		
	}
public void clickonSaveButton() {
	
	saveButton.click();
		
		
	}

public boolean verifyRecruitmentRequestSend() {
	boolean submitStatus;
	
	try {
		submitStatus = Message.isDisplayed();
	}catch(Throwable e) {
		submitStatus = false;
	}
	
	return submitStatus;
}
}

	
	
	
	
	


