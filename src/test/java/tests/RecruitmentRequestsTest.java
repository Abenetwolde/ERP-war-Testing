

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
import pageobjects.TalentRegisterPage;
import pageobjects.UpdateJobGrade;
import pageobjects.LoginPage1;
import pageobjects.OrganizationStruacture;
import pageobjects.RecruitmentRequestPage;
import util.DataUtil;
import util.MyXLSReader;

public class RecruitmentRequestsTest extends Base {
	
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
	public void testRegister(HashMap<String,String> hMap) throws IOException, InterruptedException {
		
		if(!DataUtil.isRunnable(excelReader, "RecruitmentRequestsTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}
		
		driver = openBrowser(hMap.get("Browser"));
        HomePage1 homePage = new HomePage1(driver);
        homePage.selectHRMSlinkTextLink();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.clickRecruitmentTextDropMenu();
        dashboard.RecruitmentRequestPage();
        LoginPage1 loginPage = new LoginPage1(driver);
        loginPage.enterUserName(hMap.get("Username"));
		loginPage.enterPassword(hMap.get("Password"));
	    loginPage.gotoRecruitmentRequestPage();
	    RecruitmentRequestPage recruitmentRequestPage=new  RecruitmentRequestPage(driver);

	    recruitmentRequestPage.clickOnRecruitmentRequestsButton();
	    Thread.sleep(2000);
	    recruitmentRequestPage.clickOnTenatNameDropDownIcon();
	    Thread.sleep(2000);
	    recruitmentRequestPage.clickOnSelectTenatName();
	    Thread.sleep(2000);
	    recruitmentRequestPage.enterRequester_Id(hMap.get("Requester_Id"));
	    Thread.sleep(2000);
	    recruitmentRequestPage.clickonTable();
	    Thread.sleep(2000);
	    recruitmentRequestPage.clickonJobTitleDropDownIconButton();
	    Thread.sleep(2000);
	    recruitmentRequestPage.selectOnJobTitle();
	    Thread.sleep(2000);
	    recruitmentRequestPage.enterNumberofEmployeesRequested(hMap.get("Number of employees"));
	    Thread.sleep(2000);
	    recruitmentRequestPage.enterComment(hMap.get("Comment"));
        Thread.sleep(2000);
        recruitmentRequestPage.clickonSaveButton();
        	System.out.println("recruitment Request Successfully sent");
        	String expectedResult = hMap.get("ExpectedResult");
    		
    		boolean expectedConvertedResult = false;
    		
    		if(expectedResult.equalsIgnoreCase("Failure")) {
    			
    			expectedConvertedResult = false;
    			
    		}else if(expectedResult.equalsIgnoreCase("Success")){
    			
    			expectedConvertedResult = true;
    		}
    		
    		Assert.assertEquals(recruitmentRequestPage.verifyRecruitmentRequestSend(),expectedConvertedResult);

	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			obj = DataUtil.getTestData(excelReader, "RecruitmentRequestsTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}