
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

public class JobUpdate extends Base {
	
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
		
		if(!DataUtil.isRunnable(excelReader, "JobUpdateTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}
		
		driver = openBrowser(hMap.get("Browser"));
        HomePage1 homePage = new HomePage1(driver);
        homePage.selectHRMSlinkTextLink();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.clickOrganizationInformationDropMenu();
        dashboard.selectPayGradeOption();
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.enterUserName(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
	    loginPage.goToPayGradePage();
	    UpdateJobGrade payGradeUpdate=new  UpdateJobGrade(driver);

    	 payGradeUpdate.clickonGradeDropDownButton();
    	 payGradeUpdate.SelectGrade();
    	 payGradeUpdate.clickonEditAction();
    	 payGradeUpdate.enterUpdateDiscription(hMap.get("UpdateDescription"));
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
         	payGradeUpdate.enterUpdateMaximumSalary(hMap.get("Update Maximum Salary"));
        	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
        	payGradeUpdate.enterUpdatedSalary(hMap.get("UpdateSalary"));
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	payGradeUpdate.clickonAddUpdate();
        	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        	payGradeUpdate.clickonSave();
       
        	System.out.println("successfuly job Updated");
        	String expectedResult = hMap.get("ExpectedResult");
    		
    		boolean expectedConvertedResult = false;
    		
    		if(expectedResult.equalsIgnoreCase("Failure")) {
    			
    			expectedConvertedResult = false;
    			
    		}else if(expectedResult.equalsIgnoreCase("Success")){
    			
    			expectedConvertedResult = true;
    		}
    		
    		Assert.assertEquals(payGradeUpdate.verifyUpdated(),expectedConvertedResult);

	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			obj = DataUtil.getTestData(excelReader, "JobUpdateTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}