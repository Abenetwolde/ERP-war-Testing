
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
import pageobjects.CandidateRegistrationPage;
import pageobjects.Dashboard;
import pageobjects.HomePage1;
import pageobjects. RegistrationPage;

import pageobjects.LoginPage1;
import pageobjects.OrganizationStruacture;
import util.DataUtil;
import util.MyXLSReader;

public class CandidateRegistrationTest extends Base {
	
	WebDriver driver;
	MyXLSReader excelReader;
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {	
			driver.quit();
		}
		
	}
	
	@Test(dataProvider="dataSupplier")
	public void testRegister(HashMap<String,String> hMap) throws IOException, InterruptedException {
		
		if(!DataUtil.isRunnable(excelReader, "candidateRegistrationTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}
		driver = openBrowser(hMap.get("Browser"));
        HomePage1 homePage = new HomePage1(driver);
        homePage.selectHRMSlinkTextLink();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.clickRecruitmentTextDropMenu();
        dashboard.gotoCandidateRegistration();
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.enterUserName(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
	    loginPage.gotoCandidateRegistrationPage();
	    CandidateRegistrationPage candidateRegistrationPage=new CandidateRegistrationPage(driver);
//        if(organizationStruacturePage.verifyLoginStatusOfUser()) {
	    candidateRegistrationPage.clickonPluseButtonButton();
	    Thread.sleep(2000);
	    candidateRegistrationPage.clickonVacancyNoButton();
	    Thread.sleep(2000);
	    candidateRegistrationPage.selectVacancyNo();
	    Thread.sleep(2000);
	    candidateRegistrationPage.clickonJobTitleDropDown();
	    Thread.sleep(2000);
	    candidateRegistrationPage.selectJobTitle();
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterFirstName(hMap.get("First"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterMiddleName(hMap.get("Middle "));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterLastName(hMap.get("Last"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.clickonNationalityDropDown();
	    Thread.sleep(2000);
	    candidateRegistrationPage.selectNationality();
	    Thread.sleep(2000);
	    
	    candidateRegistrationPage.clickonDateofBirthTextField();
	    Thread.sleep(2000);
	    candidateRegistrationPage.selectdate();
	    Thread.sleep(2000);
	    candidateRegistrationPage.clickonMaritalStatus();
	    Thread.sleep(2000);
	    candidateRegistrationPage.selectMaritalStatus();
	    Thread.sleep(2000);
	    candidateRegistrationPage.clickOnAddAdressButton();
	    Thread.sleep(2000);
	    candidateRegistrationPage.selectAddress();
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterHomePhone(hMap.get("HomePhoneNo"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterOfficeNumber(hMap.get("Office"));;
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterRelevantSkills(hMap.get("RelevantSkills"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterOtherInformation(hMap.get("OtherInformation"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterHomePhoneNo(hMap.get("Mobile"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterPOBox(hMap.get("POBox"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterEmail(hMap.get("Email"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.enterHobbies(hMap.get("Hobbies"));
	    Thread.sleep(2000);
	    candidateRegistrationPage.clickonSave();
	    Thread.sleep(2000);
	
        Thread.sleep(2000);
        	System.out.println("successfuly job Added");
        	String expectedResult = hMap.get("ExpectedResult");
    		
    		boolean expectedConvertedResult = false;
    		
    		if(expectedResult.equalsIgnoreCase("Failure")) {
    			
    			expectedConvertedResult = false;
    			
    		}else if(expectedResult.equalsIgnoreCase("Success")){
    			
    			expectedConvertedResult = true;
    		}
    		
    		Assert.assertEquals(candidateRegistrationPage.verifySubmition(),expectedConvertedResult);
        	   
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
			obj = DataUtil.getTestData(excelReader, "candidateRegistrationTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}
