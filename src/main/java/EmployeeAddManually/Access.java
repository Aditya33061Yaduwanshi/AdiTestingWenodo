package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Access extends UtilityComponent {
	
	public Access(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
	}	
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 

	public void accessPageMandatoryFields(WebDriver driver) throws InterruptedException {
	    performClickOnWebelement("//*[@id=\"select_label\"]");
	    //6-employee,5-AssistantManager, same for 4,3,2 also.
	    performClickOnWebelement("//*[@id=\"divNewNotifications\"]/li[6]");
		  
	    //save
	    //performClickOnWebelement("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div/button[2]");
	    performClickOnWebelement("//button[normalize-space()='Save & Continue']");
	   
	}

}
