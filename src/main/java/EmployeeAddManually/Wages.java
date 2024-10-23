package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Wages extends UtilityComponent{
	
	public Wages(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	
	}	
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 

	public void wagesMandatoryFields(WebDriver driver) throws InterruptedException {
		Thread.sleep(2000);
		//Pay type
	    performClickOnWebelement("(//span[@id='select_label'])[1]");
	    waitForElementToAppear(750);
	    // 1-Salaried 2-Hourly rate,3-Shift rate,4-Daily rate.
	    performClickOnWebelement("//li[@class='ng-scope'][3]");
    
    
	    //pay schedule
	    performClickOnWebelement("(//span[@id='select_label'])[2]");
	    performClickOnWebelement("//span[normalize-space()='Aditya Yaduwanshi']");

	    //Hourly rate  
		driver.findElement(By.xpath("//input[@name='HOURLY_RATE0']")).sendKeys("50");
		
		// NI Category	
		//driver.findElement(By.xpath("(//span[@id='select_label'])[4]")).click();
		driver.findElement(By.xpath("//ul[@ng-class=\"{'error':WagesForm.submitted && WagesForm.NI_CATEGORY_ID.$error.required}\"]//span[@id='select_label']")).click();
		//driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[2]/div[1]/ul/li/ul/li[5]")).click();
		driver.findElement(By.xpath("(//li[@class='ng-scope'])[19]")).click();
		
		}
	
	public void nonMandatoryFieldWages(WebDriver driver) throws InterruptedException {
		waitForElementToAppear(1000);
		driver.findElement(By.xpath("(//input[@name='TRONC_RATE0'])")).sendKeys("123");
		driver.findElement(By.xpath("(//input[@ng-model='WagesSearch.PENSIONS'])")).sendKeys("30");
		driver.findElement(By.xpath("(//input[@ng-model='WagesSearch.EMPLOYER_NI_PRCNT'])")).sendKeys("40");
		driver.findElement(By.xpath("(//input[@ng-model='WagesSearch.HOLIDAY_ACCRUEL_PRCNT'])")).sendKeys("50");
			
		// save	
		waitForElementToAppear(1300);
		driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();	
		
	}

}
