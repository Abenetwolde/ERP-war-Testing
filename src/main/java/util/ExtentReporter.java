package util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getExtentReport() {
		
		String extentReportPath = System.getProperty("user.dir")+"\\reports\\extentreport.html"; 
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath);
		sparkReporter.config().setReportName("ERP-war Automation Results");	
		sparkReporter.config().setDocumentTitle("ERP-war Test Results");
	
		ExtentReports extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter);
		extentReport.setSystemInfo("Selenium Version","4.4.0");
		extentReport.setSystemInfo("Operating System","Windows 10");
		extentReport.setSystemInfo("Executed By","Abnet wolde");
		
		return extentReport;
	
	}

}
