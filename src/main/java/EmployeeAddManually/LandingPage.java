package EmployeeAddManually;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends UtilityComponent{
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	
	JavascriptExecutor js = (JavascriptExecutor) driver;  

	public void launchTheApplication(WebDriver driver) {
		
		driver.get("https://testing.wenodo.com/Login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
	    String pageTitle =driver.getTitle();
		System.out.println(" The Title of the page is "+ pageTitle);
	//	WebElement logo=driver.findElement(By.xpath(""));
	//	System.out.println("Display status of logo "+logo.isDisplayed());
		//or boolean logoStatus=driver.findElement(By.xpath("")).isDisplayed();
		// sysou("Display status: "+logoStatus);
	
	}
	
	public void loginApplication(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[3]/div/login/div[2]/input"))
		.sendKeys("robert@anderson.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Demo@123");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		waitForElementToAppear(3000);
	}
	
	public void redirectingToEmployeeAddManually(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"24\"]/div[2]/a/span")).click();
		waitForElementToAppear(3000);
		driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div[7]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div[7]/ul/li[1]/a")).click();
		
	}
	
	

}
