package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Assets extends UtilityComponent {
	public Assets(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
		}	
	
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Actions act=new Actions(driver);
	
	public void assetsPageMandatoryFields() throws InterruptedException {
		waitForElementToAppear(1000);
	    performClickOnWebelement("//*[@id=\"select_label\"]");
	    waitForElementToAppear(750);
	    performClickOnWebelement("//*[@id=\"divNewNotifications\"]/li[2]");
	    
	    waitForElementToAppear(750);
		act.sendKeys(Keys.TAB).build().perform();
		waitForElementToAppear(750);
		act.sendKeys(Keys.ENTER).build().perform();
		
		waitForElementToAppear(750);
		act.sendKeys(Keys.TAB).build().perform();
		waitForElementToAppear(750);
		//act.sendKeys(Keys.ENTER).build().perform();
	       //return date
		driver.findElement(By.xpath("//input[@name='RETURN_DATE0']")).sendKeys("Jan 5,2026");//
		waitForElementToAppear(500);
	    
	    driver.findElement(By.name("NOTES0")).sendKeys("Laptop and Adapter are provided");
	  

	}
	 
	public void nonMandatoryFieldsAssetsPage(WebDriver driver) throws InterruptedException {		    
		// NON MANDATORY FIELDS
	    //upload file
		waitForElementToAppear(750);
	    driver.findElement(By.xpath("(//input[@id='Asset0'])")).sendKeys("C:\\\\Users\\\\Wenodo\\\\Downloads\\\\user image.jpg");
	    waitForElementToAppear(1000);
	    
	    //save
	    waitForElementToAppear(750);
	    //performClickOnWebelement("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div[2]/button[3]");
	    performClickOnWebelement("//button[normalize-space()='Save & Continue']");
	}
}
