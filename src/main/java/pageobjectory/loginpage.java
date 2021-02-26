package pageobjectory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginpage {
	WebDriver driver;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	
	public loginpage(WebDriver driver){
	     this.driver = driver;
	     PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Log In']")
	private WebElement LogIn;
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement EmailAddress;
	
	@FindBy(xpath="//input[@id='pass']")
	private WebElement Password;
	
	@FindBy(xpath="//span[contains(text(),'Login')]")
	private WebElement LoginButton;
	
	public void getLogIn(){
		LogIn.click();
	}
	
	public void SetUserName(String username){
		EmailAddress.sendKeys(username);
	}
	
	public void SetPassword(String password){
		Password.sendKeys(password);
	}
	
	public void getLoginButton(){
		LoginButton.click();
	}

	public void javascriptclick(WebElement element){
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
	}
	
	
	public void loginToPage() throws IOException, InterruptedException{
		fileInput = new FileInputStream(filepath);
        prop = new Properties();
		prop.load(fileInput);
		Thread.sleep(1000);
		javascriptclick(LogIn);
		Thread.sleep(1000);
		SetUserName(prop.getProperty("UserName"));
		Thread.sleep(1000);
		SetPassword(prop.getProperty("Password"));
		Thread.sleep(1000);
		getLoginButton();
		Thread.sleep(1000);
	}



}
