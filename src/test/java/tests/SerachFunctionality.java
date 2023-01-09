
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
import pageobjects.UpdateJobGrade;
import pageobjects.LoginPage1;
import pageobjects.OrganizationStruacture;
import util.DataUtil;
import util.MyXLSReader;

public class SerachFunctionality extends Base {
	
	WebDriver driver;
	MyXLSReader excelReader;
	
//	@AfterMethod
//	public void tearDown() {
//		
//		if(driver!=null) {	
//			driver.quit();
//		}
//		
//	}
//	
	@Test(dataProvider="dataSupplier")
	public void testRegister(HashMap<String,String> hMap) throws IOException {
		
		if(!DataUtil.isRunnable(excelReader, "JobSearchTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
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
	    UpdateJobGrade payGradeUpdate=new  UpdateJobGrade(driver);

	    RegistrationPage jobRegisterPage=new  RegistrationPage(driver);
//      if(organizationStruacturePage.verifyLoginStatusOfUser()) {
      	jobRegisterPage.clickOnSearchDropDownButton();
      	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
       	jobRegisterPage.clickOnSelectSearchBy();
      	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
      	jobRegisterPage.enterJobcode(hMap.get("Job code"));
      	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
      	jobRegisterPage.selectJobCode();
      	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
       	jobRegisterPage.clickOnSaveSearchResult();
      	driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS) ;
     
       
        	System.out.println("successfuly Serached");
        	String expectedResult = hMap.get("ExpectedResult");
    		
    		boolean expectedConvertedResult = false;
    		
    		if(expectedResult.equalsIgnoreCase("Failure")) {
    			
    			expectedConvertedResult = false;
    			
    		}else if(expectedResult.equalsIgnoreCase("Success")){
    			
    			expectedConvertedResult = true;
    		}
    		
    		Assert.assertEquals(jobRegisterPage.verifyTheSesarchItemExist(),expectedConvertedResult);

	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			obj = DataUtil.getTestData(excelReader, "JobSearchTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}