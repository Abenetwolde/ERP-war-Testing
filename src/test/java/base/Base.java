package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	WebDriver driver;
	
	public Properties prop;
	
	public WebDriver openBrowser(String browserName) throws IOException {
		
		prop = new Properties();
		File file = new File("src\\test\\resources\\data.properties");
		FileInputStream fis = new FileInputStream(file);
		prop.load(fis);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options= new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			
		}else if(browserName.equalsIgnoreCase("firefox")) {
			FirefoxOptions options= new FirefoxOptions ();
			options.setAcceptInsecureCerts(true);
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver(options);
			
		}else if(browserName.equalsIgnoreCase("edge")) {
			EdgeOptions options= new EdgeOptions ();
			options.setAcceptInsecureCerts(true);
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(options);
			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		return driver;
		
	}


}
