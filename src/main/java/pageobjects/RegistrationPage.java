package pageobjects;
//import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	
	WebDriver driver;
	
	public RegistrationPage(WebDriver driver) {
		
		
		this.driver = driver;
		
		PageFactory.initElements(driver,this);
	
		
	}
	@FindBy(id="frmTop:btnNew")
	private WebElement addButton;
	@FindBy(id="frmJobRegistration:txtJobCode")
	private WebElement txtJobCode;
	@FindBy(id="frmJobRegistration:btnDepartment")
	private WebElement AddDepartmentButton;
//	@FindBy(id="frmJobRegistration:dlgDpt")
//	private WebElement DepartmentModal;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:j_idt170:0\"]/span/span[1]")
	private WebElement DropDownIcon;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:j_idt170:0_2\"]/span/span[3]")
	private WebElement selectDepartment;
	
	@FindBy(id="frmJobRegistration:txtJobTitle")
	private WebElement txtJobTitle;
	@FindBy(id="frmJobRegistration:txtNoEmpNeeded")
	private WebElement txtNoEmpNeeded;
	@FindBy(id="frmJobRegistration:txtJobDes")
	private WebElement txtJobDes;
	@FindBy(id="frmJobRegistration:txtRelevantExperience")
	private WebElement txtRelevantExperience;
	@FindBy(id="frmJobRegistration:txtRemark")
	private WebElement txtRemark;
	@FindBy(id="frmJobRegistration:somJobGrade_label")
	private WebElement jobGradeDropdown;
	@FindBy(xpath="//*[@id=\\\"frmJobRegistration:somJobGrade_panel\\\"]/div/ul/li[3]")
	private WebElement selectJopGrade;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somJobGrade\"]/div[3]")
	private WebElement jobCatagoryDropdown;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somCatagory\"]/div[3]")
	private WebElement selectCatagory;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somType\"]/tbody/tr/td[3]/div/div[2]/span")
	private WebElement radioButton;
	
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somEdulevel\"]/div[3]/span")
	private WebElement educationLevelDropdown;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somEdulevel_panel\"]/div/ul/li[16]")
	private WebElement selecteducationLevel;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somEducType\"]/div[3]")
	private WebElement qualificationDropdown;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:somEducType_panel\"]/div/ul/li[28]")
	private WebElement selectQualification;
	@FindBy(id="frmJobRegistration:txtNoMinExp")
	private WebElement txtNoMinExp;
	@FindBy(id="frmJobRegistration:btnEduQualAdd")
	private WebElement Add;
	@FindBy(xpath="	//*[@id=\"frmJobRegistration:btnSave\"]/span")
	private WebElement submitButton;
	@FindBy(xpath="	//*[@id=\"frmJobRegistration:drdSearchBy\"]/div[3]")
	private WebElement SearchDropDown;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:drdSearchBy_panel\"]/div/ul/li[3]")
	private WebElement SearchByJobCode;
	@FindBy(id="frmJobRegistration:autoJobCode_input")
	private WebElement JobCodeTextFild;
	@FindBy(xpath="//*[text()='Success!']")
	private WebElement Message;
	@FindBy(xpath="	//*[@id=\"frmJobRegistration:autoJobCode_panel\"]/ul/li")
	private WebElement SelectSearchResult;
	@FindBy(xpath="//*[text()='Job Registration']")
	private WebElement jobRegistrationisDisplay;
	@FindBy(xpath="//*[@id=\"frmJobRegistration:btnSave\"]/span")
	private WebElement saveTheSeachResult;
//sq-100
	

	

public void clickOnAddJobButton() {
		
	   addButton.click();
		
		
	}

public void enterJobCode(String userNameText) {
		
	txtJobCode.sendKeys(userNameText);
		
	}
public void clickonAddDepartmentButton() {
	
	AddDepartmentButton.click();
		
		
	}
public void clickonDropDownButton() {
	
	DropDownIcon.click();
		
		
	}
public void SelectDepartment() {
	
	selectDepartment.click();
		
		
	}

public void enterJobTitle(String jobTitleText) {
	
	txtJobTitle.sendKeys(jobTitleText);
		
	}
public void enterNoEmpNeeded(String NoEmpNeededeText) {
	
//	 double parseDouble = Double.parseDouble(NoEmpNeededeText);
//	 DecimalFormat df = new DecimalFormat("0");
//        String formatNumber = df.format(parseDouble);
        txtNoEmpNeeded.sendKeys(NoEmpNeededeText);
	
	}
	
public void enterJobDescription(String jobDiscriptionText) {
	
	txtJobDes.sendKeys(jobDiscriptionText);
		
	}
public void enterRelevantExperience(String relevantExperincetext) {
	
//	 double parseDouble = Double.parseDouble(relevantExperincetext);
//	 DecimalFormat df = new DecimalFormat("0");
//       String formatNumber = df.format(parseDouble);
       txtRelevantExperience.sendKeys(relevantExperincetext);
	
	}
public void enterRemark(String remarkText) {
//	 double parseDouble = Double.parseDouble(remarkText);
//	 DecimalFormat df = new DecimalFormat("0");
//       String formatNumber = df.format(parseDouble);
       txtRemark.sendKeys(remarkText);
	
	}
	

	public void clickonJobGradeDropDown() {
		
		jobGradeDropdown.click();
	}

			

	public void SelectJobGrade() {
		
		selectJopGrade.click();
			
			
		}
public void clickonJobCategoryDropDown() {
		
	jobCatagoryDropdown.click();
			
			
		}
	public void SelectJobCategory() {
		
		selectCatagory.click();
			
			
		}
public void SelectRadioButton() {
		
		radioButton.click();
			
			
		}

public void clickonEducationalLevelDropDown() {
	
	educationLevelDropdown.click();
			
			
		}
	public void SelectEducationLevel() {
		
		selecteducationLevel.click();
			
			
		}
	public void clickonQualificationDropDown() {
		
		qualificationDropdown.click();
				
				
			}
		public void SelectQualification() {
			
			selectQualification.click();
				
				
			}
		public void enterNoMinExp(String noMinExpext) {
//			 double parseDouble = Double.parseDouble(noMinExpext);
//			 DecimalFormat df = new DecimalFormat("0");
//		        String formatNumber = df.format(parseDouble);
		        txtNoMinExp.sendKeys(noMinExpext);
			
		}
	public void AddButton() {
			
			Add.click();
				
				
			}
	public void SubmitButton() {
		
		submitButton.click();
			
			
		}
public void clickOnSearchDropDownButton() {
		
		SearchDropDown.click();
			
			
		}
public void clickOnSelectSearchBy() {
		
	SearchByJobCode.click();
			
			
		}
public void enterJobcode(String jobCodeText) {
	
	JobCodeTextFild.sendKeys(jobCodeText);
		
	}
public void selectJobCode() {
	
	SelectSearchResult.click();
		
	}
public void clickOnSaveSearchResult() {
	
	saveTheSeachResult.click();
		
		
	}
	
	public boolean verifyTheSesarchItemExist() {
		boolean searchStatus;
		
		try {
			searchStatus = jobRegistrationisDisplay.isDisplayed();
		}catch(Throwable e) {
			searchStatus = false;
		}
		
		return searchStatus;
	}

public boolean verifySubmition() {
	boolean submitStatus;
	
	try {
		submitStatus = Message.isDisplayed();
	}catch(Throwable e) {
		submitStatus = false;
	}
	
	return submitStatus;
}
}

	
	
	
	
	


