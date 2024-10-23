package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Absences extends UtilityComponent{

	public Absences(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);		
		}
	
	JavascriptExecutor js = (JavascriptExecutor) driver; 

	public void AbsencePageMandatoryField(WebDriver driver) throws InterruptedException {							
		waitForElementToAppear(2000);
	    performClickOnWebelement("//a[@ng-class=\"{'disabled':EDIT_MODE}\"]//span[@id='select_label']");
	    performClickOnWebelement("(//li[@class='ng-scope'])[1]");
		//Effective date
		driver.findElement(By.className("dateinput")).click();
		waitForElementToAppear(1000);
		Actions act=new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
		}
	
	public void nonMandatoryFieldsAbsencesPage(WebDriver driver) throws InterruptedException {
		waitForElementToAppear(1000);
		driver.findElement(By.xpath("(//input[@name='ACCRUED_0'])")).sendKeys("4");
		driver.findElement(By.xpath("(//input[@name='ADJUSTMENT_0'])")).sendKeys("2");
		driver.findElement(By.xpath("(//input[@name='TAKEN_0'])")).sendKeys("2");
		
		driver.findElement(By.xpath("(//input[@name='AVAILABLE_TILL_DATE_0'])")).sendKeys("5");
		driver.findElement(By.xpath("(//input[@name='BOOKED_0'])")).sendKeys("2");
		driver.findElement(By.xpath("(//input[@name='REMAINING_ANNUAL_BALANCE_0'])")).sendKeys("3");
		waitForElementToAppear(500);
		driver.findElement(By.xpath("(//input[@name='TOTAL_DAYS_WORKED_0'])")).sendKeys("30");
		driver.findElement(By.xpath("(//input[@name='AVG_HOURS_WORKED_0'])")).sendKeys("9");
		driver.findElement(By.xpath("(//input[@name='AVG_PAY_0'])")).sendKeys("250");
		
		// save		
		waitForElementToAppear(1000);
		performClickOnWebelement("//button[normalize-space()='Save & Continue']");
		
	}
}
