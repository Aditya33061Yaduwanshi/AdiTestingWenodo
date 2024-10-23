package EmployeeAddManually;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Document extends UtilityComponent {
	public Document(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	
	}	
		JavascriptExecutor js = (JavascriptExecutor) driver; 
	
	public void saveDocumentPage(WebDriver driver) throws InterruptedException {
	   //Uploads
	   waitForElementToAppear(500);
       driver.findElement(By.xpath("//input[@id='HRM_CONTRACTS']")).sendKeys("C:\\\\Users\\\\Wenodo\\\\Downloads\\\\user image.jpg");
       waitForElementToAppear(1000);
    
	   driver.findElement(By.xpath("//input[@id='HRM_RTW_DOCUMENTS']")).sendKeys("C:\\\\Users\\\\Wenodo\\\\Downloads\\\\user image.jpg");
	   waitForElementToAppear(1000);

	   driver.findElement(By.xpath("//input[@id='HRM_ID_PROOF_LICENCE']")).sendKeys("C:\\\\Users\\\\Wenodo\\\\Downloads\\\\user image.jpg");
	   waitForElementToAppear(1000);
	  // WebElement ele57 =driver.findElement(By.xpath("(//button[normalize-space()='Save Photo'])"));
	  // js.executeScript("arguments[0].click()", ele57);		    
    
	   // SAVE
	   waitForElementToAppear(1000);
	   //performClickOnWebelement("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div[10]/button[3]");
	   performClickOnWebelement("//button[normalize-space()='Save & Continue']");

	}
}
