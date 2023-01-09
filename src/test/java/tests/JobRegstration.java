
package tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.io.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.lang.Thread;
import base.Base;
import pageobjects.AccountPage;
import pageobjects.Dashboard;
import pageobjects.HomePage1;
import pageobjects. RegistrationPage;

import pageobjects.LoginPage1;
import pageobjects.OrganizationStruacture;
import util.DataUtil;
import util.MyXLSReader;

public class JobRegstration extends Base {
	
	WebDriver driver;
	MyXLSReader excelReader;
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {	
			driver.quit();
		}
		
	}
	
	@Test(dataProvider="dataSupplier")
	public void testRegister(HashMap<String,String> hMap) throws IOException {
		
		if(!DataUtil.isRunnable(excelReader, "JobRegisterTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}
		
		driver = openBrowser(hMap.get("Browser"));
        HomePage1 homePage = new HomePage1(driver);
        homePage.selectHRMSlinkTextLink();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.clickOrganizationInformationDropMenu();
        dashboard.selectLoginOption();
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.enterUserName(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
	     loginPage.goToRegister();
    	 RegistrationPage jobRegisterPage=new  RegistrationPage(driver);
//        if(organizationStruacturePage.verifyLoginStatusOfUser()) {
        	jobRegisterPage.clickOnAddJobButton();
        	jobRegisterPage.enterJobCode(hMap.get("Job Code"));;
        	jobRegisterPage.clickonAddDepartmentButton();
         	jobRegisterPage.clickonDropDownButton();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        	jobRegisterPage.SelectDepartment();
         	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
    
        	jobRegisterPage.enterJobTitle(hMap.get("Job Title"));
        	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        	jobRegisterPage.enterNoEmpNeeded(hMap.get("No of Emp Needed"));
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        	jobRegisterPage.enterJobDescription(hMap.get("Job Description"));
        	jobRegisterPage.enterRelevantExperience(hMap.get("Relevant Experience"));
        	jobRegisterPage.enterRemark(hMap.get("Alternative Experience"));
        	jobRegisterPage.clickonJobGradeDropDown();
        	jobRegisterPage.SelectJobGrade();
        	jobRegisterPage.clickonJobCategoryDropDown();
        	jobRegisterPage.SelectJobCategory();
        	jobRegisterPage.SelectRadioButton();
        	jobRegisterPage.clickonEducationalLevelDropDown();
        	jobRegisterPage.SelectEducationLevel();
        	jobRegisterPage.clickonQualificationDropDown();
        	jobRegisterPage.SelectQualification();
        	jobRegisterPage.enterNoMinExp(hMap.get("MinExperience"));
        	jobRegisterPage.AddButton();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        	jobRegisterPage.SubmitButton();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        	System.out.println("successfuly job Added");
        	String expectedResult = hMap.get("ExpectedResult");
    		
    		boolean expectedConvertedResult = false;
    		
    		if(expectedResult.equalsIgnoreCase("Failure")) {
    			
    			expectedConvertedResult = false;
    			
    		}else if(expectedResult.equalsIgnoreCase("Success")){
    			
    			expectedConvertedResult = true;
    		}
    		
    		Assert.assertEquals(jobRegisterPage.verifySubmition(),expectedConvertedResult);
        	   
//        }else {
//        	
//  
//        	System.out.println("please login login");
//        }
//

//		String expectedResult = hMap.get("ExpectedResult");
//		
//		boolean expectedConvertedResult = false;
//		
//		if(expectedResult.equalsIgnoreCase("Failure")) {
//			
//			expectedConvertedResult = false;
//			
//		}else if(expectedResult.equalsIgnoreCase("Success")){
//			
//			expectedConvertedResult = true;
//		}
//		
//		Assert.assertEquals(organizationStruacturePage.verifyLoginStatusOfUser(),expectedConvertedResult);
	
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			obj = DataUtil.getTestData(excelReader, "JobRegisterTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}
