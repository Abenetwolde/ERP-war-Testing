
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
import util.DataUtil;
import util.MyXLSReader;

public class TalentRigister extends Base {
	
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
		
		if(!DataUtil.isRunnable(excelReader, "RegisterTenatTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
			throw new SkipException("Skipping the test as the runmode is set to N");
			
		}
		
		driver = openBrowser(hMap.get("Browser"));
        HomePage1 homePage = new HomePage1(driver);
        homePage.selectHRMSlinkTextLink();
        Dashboard dashboard= new Dashboard(driver);
        dashboard.clickOrganizationInformationDropMenu();
        dashboard.goToRegisterTenat();
//        LoginPage1 loginPage = new LoginPage1(driver);
//        loginPage.enterUserName(hMap.get("Username"));
//		loginPage.enterPassword(hMap.get("Password"));
//	    loginPage.goToTalentRegisterPage();
	    TalentRegisterPage tenatRegister=new  TalentRegisterPage(driver);


	    tenatRegister.clickonPluseButtonButton();
	    Thread.sleep(2000);
	    tenatRegister.enterTenetName(hMap.get("TenantName"));
	    Thread.sleep(2000);
	    tenatRegister.enterAbrivateName(hMap.get("Abrivated Name"));
	    Thread.sleep(2000);
	    tenatRegister.clickonEstablishedOnTextField();
	    Thread.sleep(2000);
	    tenatRegister.SelectDate();
	    Thread.sleep(2000);
	    tenatRegister.enterMission(hMap.get("Mission"));
	    Thread.sleep(2000);
	    tenatRegister.clickonFileInputButton(hMap.get("FileUrl"));
	    Thread.sleep(2000);
	    tenatRegister.clickonUploadButton();
	  
// tenatRegister.enterFileUrl(hMap.get("FileUrl"));
	
	    tenatRegister.enterVision(hMap.get("Vision"));
	    Thread.sleep(2000);
//      	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
        tenatRegister.clickonSave();
        Thread.sleep(2000);
        	System.out.println("Tenant Saved Successfully");
        	String expectedResult = hMap.get("ExpectedResult");
    		
    		boolean expectedConvertedResult = false;
    		
    		if(expectedResult.equalsIgnoreCase("Failure")) {
    			
    			expectedConvertedResult = false;
    			
    		}else if(expectedResult.equalsIgnoreCase("Success")){
    			
    			expectedConvertedResult = true;
    		}
    		
    		Assert.assertEquals(tenatRegister.verifyIfItIsRegisterd(),expectedConvertedResult);

	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			obj = DataUtil.getTestData(excelReader, "RegisterTenatTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}