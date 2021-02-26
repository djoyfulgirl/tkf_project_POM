package pageobjectory;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homepagescroll {
	WebDriver driver;
	String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
	File file;
	FileInputStream fileInput;
	Properties prop;
	
	public  homepagescroll(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void Scroll(){

	     WebElement element =  driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[15]"));
	        
	        JavascriptExecutor js1;
					try {
						js1 = (JavascriptExecutor) driver;
						 	
						//This will scroll the page till the element is found		
						js1.executeScript("arguments[0].scrollIntoView();", element);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
	     
	     
					}
	}


}


	