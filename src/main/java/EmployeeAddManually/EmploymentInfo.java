package EmployeeAddManually;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class EmploymentInfo extends UtilityComponent {		
	public EmploymentInfo(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	
	}		
		JavascriptExecutor js = (JavascriptExecutor) driver; 

	public void employmentInfoMandatoryFields(WebDriver driver,XSSFRow row, XSSFSheet sheet, XSSFCell cell, int colNum, int rows, int r) throws InterruptedException {		
		Actions act = new Actions(driver);
		hiringDate();
		driver.findElement(By.xpath("//input[@name='HIRING_DATE']")).sendKeys("Jan 1,2001");//
		waitForElementToAppear(500);
		
		//termination date
		act.sendKeys(Keys.TAB).build().perform();
		waitForElementToAppear(750);
		driver.findElement(By.xpath("//input[@name='TERMINATION_DATE']")).sendKeys("Jan 5,2026");//
		waitForElementToAppear(1000);
		
	//	String AdditionalEmail=takeDataFromExcel(26, row);
		colNum = getColumnName(row, "Additional Contact Email");
		String AdditionalEmail=iterationAAstring(row, sheet, cell, colNum, rows, r);
		driver.findElement(By.xpath("//input[@name='ADDITIONAL_CONTACT_EMAIL']")).sendKeys(AdditionalEmail);
			
		//starter declaration
		performClickOnWebelement("(//span[@id='select_label'])[1]");
		performClickOnWebelement("(//span[contains(text(),'A - This is my first job since 6 April and I have ')])[1]");
		waitForElementToAppear(2000);
		
		performClickOnWebelement("(//label[normalize-space()='Verified'])[1]");
		
		//Schedule		
		performClickOnWebelement("(//span[@id='select_label'])[4]");
		performClickOnWebelement("(//li[contains(@ng-repeat,'_schedule in INCLUDE_IN_SCHEDULE_DROPDOWN')])[1]");
		
		//WorkPatternAllocation
		performClickOnWebelement("(//span[@id='select_label'])[5]");
		performClickOnWebelement("//span[normalize-space()='Manager']");
		
		//site name
		performClickOnWebelement("//div[@class='row ng-scope']//div[1]//ul[1]//li[1]//a[1]//span[1]");
		//performClickOnWebelement("(//li[@class='ng-scope'])[14]");
		performClickOnWebelement("(//li[@ng-repeat='_branch in BRANCH_DROPDOWN'])[2]");

		//StartDate		
		startDate();
		
		//Department
		performClickOnWebelement("(//span[@id='select_label'])[7]");
		//performClickOnWebelement("(//span[normalize-space()='IT'])[1]");
		performClickOnWebelement("(//span[normalize-space()='It'])[1]");

		//position
		performClickOnWebelement("(//span[@id='select_label'])[8]");
		waitForElementToAppear(1500);
		performClickOnWebelement("//div[@class='row ng-scope']//div[4]//ul[1]//li[1]//ul[1]//li[5]");
		
	}
		public void nonMandatoryEmploymentFields(WebDriver driver) throws InterruptedException {
		//reporting manager primary
		waitForElementToAppear(1300);
		performClickOnWebelement("(//span[@id='select_label'])[2]");
		//performClickOnWebelement("(//li[@class='ng-scope'])[6]");
		performClickOnWebelement("(//li[@ng-repeat='_primary in SECONDARY_REPORTING_MANAGER_DROPDOWN | filter:{EMPLOYEE_NAME : EmploymentInfo.DISPLAY_PRI_TEXT_SEARCH}'])[3]");
		waitForElementToAppear(750);

		//reporting manager secondary
		performClickOnWebelement("(//span[@id='select_label'])[3]");
		//performClickOnWebelement("(//li[@class='ng-scope'])[8]");
		performClickOnWebelement("(//li[@ng-repeat='_secondary in SECONDARY_REPORTING_MANAGER_DROPDOWN | filter:{EMPLOYEE_NAME : EmploymentInfo.DISPLAY_SEC_TEXT_SEARCH}'])[3]");

		driver.findElement(By.xpath("(//input[@name='TEAMHUB_PIN'])")).sendKeys("Adi123");
		driver.findElement(By.xpath("(//input[@name='CLOCKIN_CLOCKOUT_PIN'])")).sendKeys("Adi123");
		driver.findElement(By.xpath("(//input[@name='SOURCE'])")).sendKeys("Wenodo");
		driver.findElement(By.xpath("(//textarea[@name='ADD_NOTES_FOR_THIS_EMPLOYEE'])")).sendKeys("Welcome to Wenodo");

		//section dropdown left	
		waitForElementToAppear(750);
		performClickOnWebelement("//a[@aria-expanded='false']//span[@id='select_label']");
		performClickOnWebelement("(//li[@class='ng-scope'])[22]");
		
		//save
		waitForElementToAppear(1000);
		performClickOnWebelement("//button[normalize-space()='Save & Continue']");

	}


}
