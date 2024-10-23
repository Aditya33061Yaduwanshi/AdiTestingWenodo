package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Notes extends UtilityComponent{
	
	public Notes(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
		JavascriptExecutor js = (JavascriptExecutor) driver;  
		
	public void notesPageFields(WebDriver driver) throws InterruptedException {
		waitForElementToAppear(500);		
	    performClickOnWebelement("//div[@class='btn btn-light']");
		
	    waitForElementToAppear(1000);
	    driver.findElement(By.xpath("(//textarea[@placeholder='Type here..'])[1]")).sendKeys("Employee profile(mandatory fields) file has been completed");
	    	    
	    performClickOnWebelement("(//button[@ng-click='HRM_INS_UPD_EMPLOYEE_NOTES()'])[1]");
	    waitForElementToAppear(500);

	    performClickOnWebelement("(//button[normalize-space()='Save & Continue'])[1]");
	 
		}

}
