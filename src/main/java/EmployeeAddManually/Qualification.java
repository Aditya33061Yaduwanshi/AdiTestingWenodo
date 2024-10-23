package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class Qualification extends UtilityComponent {

	public Qualification(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	
	}		
	JavascriptExecutor js = (JavascriptExecutor) driver; 
	Actions act=new Actions(driver);
	
	public void qualificationMandatoryFields(WebDriver driver) throws InterruptedException {	
		waitForElementToAppear(1200);
	    performClickOnWebelement("(//span[@id='select_label'])[1]");
		waitForElementToAppear(1200);
		performClickOnWebelement("//li[@class='ng-scope']");

	    waitForElementToAppear(750);
	    WebElement ele38= driver.findElement(
			By.xpath("(//input[@placeholder='Type here..'])[1]"));
	    // js.executeScript("arguments[0].value='Institution001243'", ele38);
	    //send keys using action class.
	    act.sendKeys(ele38, "Institution").build().perform();
	   
	    validUpToDate();
	    //	act.sendKeys(Keys.ENTER).build().perform();
	    //valid upto date
	    driver.findElement(By.xpath("(//input[@name='VALID_UPTO_DATE0'])")).sendKeys("Jan 5,2026");//
	    waitForElementToAppear(500);

	}
	
	public void nonMandatoryFieldsQualificationPage(WebDriver driver) throws InterruptedException {
		// upload file
		 waitForElementToAppear(750);
		 driver.findElement(By.xpath("(//input[@id='certificate0'])")).sendKeys("C:\\\\Users\\\\Wenodo\\\\Downloads\\\\user image.jpg");
		 waitForElementToAppear(1000);
		
		 //save
	    performClickOnWebelement("//button[normalize-space()='Save & Continue']");
	}
}
