package TestCaseExecution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass.browsersetup;
import pageobjectory.loginpage;

public class logintest {
	WebDriver driver;
	loginpage loginpage;
	browsersetup BS;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;

	@BeforeMethod
	public void openbrowser() throws InterruptedException, IOException {
		fileInput = new FileInputStream(filepath);
        prop = new Properties();
		prop.load(fileInput);
	    driver = browsersetup.StartBrowser(prop.getProperty("browserName"),prop.getProperty("url"));

	}
	
	@Test
	public void TestCase_One() throws InterruptedException, IOException{
		loginpage = new loginpage(driver);	
		loginpage.loginToPage();
		Thread.sleep(2000);
	}
	
	
	@AfterMethod
	public void closeBrowser(){
		driver.close();
	}
}