package pageobjectory;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class tkfsearch {

		protected  WebDriver driver;
		String filepath = System.getProperty("user.dir")+ "\\config\\file.properties";
		File file;
		FileInputStream fileInput;
		Properties prop;
		
		public tkfsearch(WebDriver driver){
		     this.driver = driver;
		     PageFactory.initElements(driver, this);
		}


		@FindBy(id="search")
		private WebElement SearchBox;

		@FindBy(xpath="//*[@id='search_mini_form']/div/button/span/span")
		private WebElement SearchButton;    


		public void SearchFor(String SearchTerm)   // do i need to declare the searchterm on the file property?)
		{
		    SearchBox.sendKeys(SearchTerm);
		}   
	
		public void SearchButton()  
		{
			SearchButton.click();
		}
	
		public String  verifytitle(){
			return  driver.getTitle();
		}

		public void handleiframe(){
			   List<WebElement> iframeCount = driver.findElements(By.tagName("iframe")); 
			    int str = iframeCount.size();
			    System.out.println("Count of Iframe :" + str);
			    
			    for(int i=0;i<str;i++)
			    {
			    	driver.switchTo().frame(i);
			    	WebElement autoOptions= driver.findElement(By.xpath("//input[@id='tags']"));
				    autoOptions.sendKeys("jav");
			    	
			    }
		}
		
		
	
}
