
package tests;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import pageobjects.AccountPage;
import pageobjects.Dashboard;
import pageobjects.HomePage1;

import pageobjects.LoginPage1;
import pageobjects.OrganizationStruacture;
import util.DataUtil;
import util.MyXLSReader;

public class Login1 extends Base {
	
	WebDriver driver;
	MyXLSReader excelReader;
	
	@AfterMethod
	public void tearDown() {
		
		if(driver!=null) {	
			driver.quit();
		}
		
	}
	
	@Test(dataProvider="dataSupplier")
	public void testLogin(HashMap<String,String> hMap) throws IOException {
		
		if(!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hMap.get("Runmode").equals("N")) {
			
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
		loginPage.clickOnLoginButton();
        OrganizationStruacture organizationStruacturePage=new OrganizationStruacture(driver);

		String expectedResult = hMap.get("ExpectedResult");
		
		boolean expectedConvertedResult = false;
		
		if(expectedResult.equalsIgnoreCase("Failure")) {
			
			expectedConvertedResult = false;
			
		}else if(expectedResult.equalsIgnoreCase("Success")){
			
			expectedConvertedResult = true;
		}
		
		Assert.assertEquals(organizationStruacturePage.verifyLoginStatusOfUser(),expectedConvertedResult);
	
	}
	
	@DataProvider
	public Object[][] dataSupplier() {
		
		Object[][] obj = null;
		
		try {
			
			excelReader = new MyXLSReader("src\\test\\resources\\TutorialsNinja.xlsx");
			obj = DataUtil.getTestData(excelReader, "LoginTest", "Data");
		
		}catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		return obj;
		
	}

}
