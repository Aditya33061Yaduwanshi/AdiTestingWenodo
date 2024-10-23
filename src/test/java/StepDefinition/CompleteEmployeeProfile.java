package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CompleteEmployeeProfile {
	
	WebDriver driver=null;
	//JavascriptExecutor js = (JavascriptExecutor) driver;

	
	@Given("User will login the application")
	public void user_will_login_the_application() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Wenodo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get("https://testing.wenodo.com/Login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[3]/div/login/div[2]/input"))
				.sendKeys("robert@anderson.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Demo@123");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();
		Thread.sleep(3000);
	}

	@When("User will redirecting to EmployeeAddManually page")
	public void user_will_redirecting_to_employee_add_manually_page() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"24\"]/div[2]/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"cssmenu\"]/ul/li[2]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div[7]/button")).click();
		driver.findElement(By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div[7]/ul/li[1]/a")).click();
		
		}

	@Then("User starts filling all MandatoryFields in Primary Details section : {string},{string},{string}")
	public void user_starts_filling_all_mandatory_fields_in_primary_details_section(String Firstname, String Lastname, String Email) throws InterruptedException {
	   	driver.findElement(By.cssSelector("input[placeholder='Select Date / Type here.. ']")).click();
		driver.findElement(By.xpath("//th[normalize-space()='September 2024']")).click();
		driver.findElement(By.xpath("//th[normalize-space()='2024']")).click();
		
		driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='prev'][normalize-space()='«']")).click();	
		driver.findElement(By.xpath("//div[@class='datepicker-years']//th[@class='prev'][normalize-space()='«']")).click();
		
		driver.findElement(By.xpath("(//span[@class='year'][normalize-space()='2000'])[1]")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='Jan']")).click();
		driver.findElement(By.xpath("//td[@class='highlighted day'][normalize-space()='1']")).click();
		
		
		
		driver.findElement(By.name("FIRST_NAME")).sendKeys(Firstname);
		driver.findElement(By.name("MIDDLE_NAME")).sendKeys("Yaduwanshi");
		driver.findElement(By.name("LAST_NAME")).sendKeys(Lastname);

		// Nationality
		driver.findElement(
			By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[3]/div[4]/ul/li")).click();
		Thread.sleep(750);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		WebElement ele2 = driver.findElement(
			By.xpath("//*[@id=\"divNewNotifications\"]/li[101]"));
		js.executeScript("arguments[0].click()", ele2);

		// Gender
		driver.findElement(
			By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[3]/div[6]/ul/li/a")).click();
		Thread.sleep(750);
		driver.findElement(By.xpath("//span[normalize-space()='Male']")).click();
		
		
		driver.findElement(By.xpath("//*[@id=\"primaryphone\"]")).sendKeys("7415533061");
		driver.findElement(By.xpath("//*[@id=\"EMAIL\"]")).sendKeys(Email);
		driver.findElement(
			By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[6]/div[1]/input")).sendKeys("Address 1");
		driver.findElement(
			By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[6]/div[2]/input")).sendKeys("Address 2");

		
		// Country
		WebElement ele3 = driver.findElement(
			By.xpath("//ul[@ng-class=\"{'error':primaryForm.submitted && primaryForm.COUNTRY_ID.$error.required}\"]//span[@id='select_label']"));
		js.executeScript("arguments[0].click()", ele3);

		Thread.sleep(1000);
		WebElement ele4 = driver.findElement(
			By.xpath("//div[@class='row']//ul[@class='nav nav-pills']//li[101]"));
		js.executeScript("arguments[0].click()", ele4);

			
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='COUNTY']")).sendKeys("Madhya Pradesh");

		
		driver.findElement(By.name("CITY")).sendKeys("Bhopal");
		WebElement ele = driver.findElement(
			By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div/button[2]"));
		js.executeScript("arguments[0].click()", ele);

		}

	@Then("Navigate to EmployeeInfo Page and starts filling its Mandatory Fields : {string}")
	public void navigate_to_employee_info_page_and_starts_filling_its_mandatory_fields(String Additionalemail) throws InterruptedException {
		   	Thread.sleep(750);
		//hiring date
		Actions act = new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(750);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(750);
		act.sendKeys(Keys.ENTER).build().perform();
		
		driver.findElement(By.xpath("//input[@name='ADDITIONAL_CONTACT_EMAIL']")).sendKeys(Additionalemail);
		
		//driver.findElement(By.xpath("(//span[@id='select_label'])[1]")).click();
		WebElement ele13 = driver.findElement(
			By.xpath("(//span[@id='select_label'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click()", ele13);
		//driver.findElement(By.xpath("")).click();
		WebElement ele18 = driver.findElement(
			By.xpath("(//span[contains(text(),'A - This is my first job since 6 April and I have ')])[1]"));
		js.executeScript("arguments[0].click()", ele18);

		
//		driver.findElement(By.xpath("(//span[@id='select_label'])[2]")).click();		
//		driver.findElement(By.xpath("(//span[@id='select_label'])[3]")).click();
		WebElement ele5 = driver.findElement(
			By.xpath("(//label[normalize-space()='Verified'])[1]"));
		js.executeScript("arguments[0].click()", ele5);
			
				
		WebElement ele6 = driver.findElement(
			By.xpath("(//span[@id='select_label'])[4]"));
		js.executeScript("arguments[0].click()", ele6);
		WebElement ele7 = driver.findElement(
			By.xpath("(//li[contains(@ng-repeat,'_schedule in INCLUDE_IN_SCHEDULE_DROPDOWN')])[1]"));
		js.executeScript("arguments[0].click()", ele7);
	
		WebElement ele8 = driver.findElement(
			By.xpath("(//span[@id='select_label'])[5]"));
		js.executeScript("arguments[0].click()", ele8);
		//driver.findElement(By.xpath()).click();
		WebElement ele17 = driver.findElement(
			By.xpath("//span[normalize-space()='Manager']"));
		js.executeScript("arguments[0].click()", ele17);
			
		WebElement ele9 = driver.findElement(
			By.xpath("(//span[@id='select_label'])[6]"));
		js.executeScript("arguments[0].click()", ele9);
		//driver.findElement(By.xpath("(//li[@class='ng-scope'])[12]")).click();
		WebElement ele14 = driver.findElement(
			By.xpath("(//li[@class='ng-scope'])[12]"));
		js.executeScript("arguments[0].click()", ele14);
		
		//StartDate
		
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		
		
		WebElement ele10 = driver.findElement(
			By.xpath("(//span[@id='select_label'])[7]"));
		js.executeScript("arguments[0].click()", ele10);
		//driver.findElement(By.xpath("(//li[@class='ng-scope'])[14]")).click();
		WebElement ele15 = driver.findElement(
			By.xpath("(//li[@class='ng-scope'])[14]"));
		js.executeScript("arguments[0].click()", ele15);
		
		WebElement ele11 = driver.findElement(
			By.xpath("(//span[@id='select_label'])[8]"));
		js.executeScript("arguments[0].click()", ele11);
		Thread.sleep(1500);
		//driver.findElement(By.xpath("(//li[@class='ng-scope'])[19]")).click();
		WebElement ele16 = driver.findElement(
			By.xpath("//div[@class='row ng-scope']//div[4]//ul[1]//li[1]//ul[1]//li[5]"));
		js.executeScript("arguments[0].click()", ele16);  //3-developer,4-sales,5-tester.

	
		//save
		WebElement ele12 = driver.findElement(
			By.xpath("//button[normalize-space()='Save & Continue']"));
		js.executeScript("arguments[0].click()", ele12);

		}

	@Then("User fill all mandatory details of Wages section")
	public void user_fill_all_mandatory_details_of_wages_section() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ele20 = driver.findElement(
				By.xpath("(//span[@id='select_label'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click()", ele20);
		//driver.findElement(By.xpath("//li[@class='ng-scope'])[4]")).click();
		Thread.sleep(750);
		    WebElement ele19 = driver.findElement(
			By.xpath("//li[@class='ng-scope'][3]"));
		    // 1-Salaried 2-Hourly rate,3-Shift rate,4-Daily rate.
	    js.executeScript("arguments[0].click()", ele19);
	    
	    
		//driver.findElement(By.xpath("(//span[@id='select_label'])[2]")).click();
		WebElement ele22 = driver.findElement(
				By.xpath("(//span[@id='select_label'])[2]"));
		    js.executeScript("arguments[0].click()", ele22);
		WebElement ele21 = driver.findElement(
				By.xpath("//span[normalize-space()='Aditya Yaduwanshi']"));
		    js.executeScript("arguments[0].click()", ele21);

		    
		driver.findElement(By.xpath("//input[@name='HOURLY_RATE0']")).sendKeys("50");
		WebElement ele23 = driver.findElement(
				By.xpath("(//span[@id='select_label'])[2]"));
			js.executeScript("arguments[0].click()", ele23);

			
	    driver.findElement(By.xpath("(//span[@id='select_label'])[4]")).click();
				// /html/body/div[1]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[2]/div[1]/ul/li/ul/li[5] and 4,3,2 also indexing
	    driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[2]/div[1]/ul/li/ul/li[5]")).click();

	    driver.findElement(By.xpath("//button[normalize-space()='Save & Continue']")).click();
						
	
		}

	@Then("Redirect to Absence page and starts filling all mandatory fields")
	public void redirect_to_absence_page_and_starts_filling_all_mandatory_fields() throws InterruptedException {
		Thread.sleep(2000);
		WebElement ele24 = driver.findElement(
				By.xpath("//a[@ng-class=\"{'disabled':EDIT_MODE}\"]//span[@id='select_label']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click()", ele24);
		//    driver.findElement(By.xpath("(//li[@class='ng-scope'])[1]")).click();   
		    WebElement ele25 = driver.findElement(
				By.xpath("(//li[@class='ng-scope'])[1]"));
		    js.executeScript("arguments[0].click()", ele25);

		driver.findElement(By.className("dateinput")).click();
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ENTER).build().perform();
	
				
		WebElement ele28= driver.findElement(
				By.xpath("//button[normalize-space()='Save & Continue']"));
	    js.executeScript("arguments[0].click()", ele28);	}

	@Then("Navigate to Access and Document section to fill its mandatory fields")
	public void navigate_to_access_and_document_section_to_fill_its_mandatory_fields() throws InterruptedException {
		Thread.sleep(1000);  //not required
		WebElement ele26 = driver.findElement(
				By.xpath("//*[@id=\"select_label\"]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click()", ele26);
	    WebElement ele27 = driver.findElement(
				By.xpath("//*[@id=\"divNewNotifications\"]/li[6]"));
	    //6-employee,5-AssistantManager, same for 4,3,2 also.
	    js.executeScript("arguments[0].click()", ele27);
	    WebElement ele29 = driver.findElement(
				By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div/button[2]"));
	    js.executeScript("arguments[0].click()", ele29);
	   
	    //DOCUMENT
	    Thread.sleep(750);
	     WebElement ele30= driver.findElement(
			By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div[10]/button[3]"));
	     js.executeScript("arguments[0].click()", ele30);
	}

	@Then("user fill Assets and Qualification page mandatory fields section")
	public void user_fill_assets_and_qualification_page_mandatory_fields_section() throws InterruptedException {
		  Thread.sleep(1000);
		    WebElement ele31= driver.findElement(
					By.xpath("//*[@id=\"select_label\"]"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click()", ele31);
		    Thread.sleep(750);
		    WebElement ele32= driver.findElement(
					By.xpath("//*[@id=\"divNewNotifications\"]/li[2]"));//2-laptop,3-mobile
		    js.executeScript("arguments[0].click()", ele32);
	  
		    Thread.sleep(750);
//		    WebElement ele33= driver.findElement(
//					By.cssSelector("input[placeholder='Type here..'][name='ISSUE_DATE0']"));
//		    js.executeScript("arguments[0].click()", ele33);
		    Actions act=new Actions(driver);
			act.sendKeys(Keys.TAB).build().perform();
		    Thread.sleep(750);
			act.sendKeys(Keys.ENTER).build().perform();
			
		    
		    Thread.sleep(750);
//		    WebElement ele34= driver.findElement(
//					By.xpath("(//input[@name='RETURN_DATE0'])[1]"));
//		    js.executeScript("arguments[0].click()", ele34);
			act.sendKeys(Keys.TAB).build().perform();
		    Thread.sleep(750);
			act.sendKeys(Keys.ENTER).build().perform();
			
		    
		    driver.findElement(By.name("NOTES0")).sendKeys("Laptop and Adapter are provided");
		  
		    Thread.sleep(750);				
		    WebElement ele35= driver.findElement(
					By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div[2]/button[3]"));
		    js.executeScript("arguments[0].click()", ele35);
		    
		    //QUALIFICATION
		    Thread.sleep(750);				
		    WebElement ele36= driver.findElement(
					By.xpath("(//span[@id='select_label'])[1]"));
		    js.executeScript("arguments[0].click()", ele36);
			 Thread.sleep(500);				
		    WebElement ele37= driver.findElement(
					By.xpath("//li[@class='ng-scope']"));
		    js.executeScript("arguments[0].click()", ele37);
	
			 Thread.sleep(750);				
		    WebElement ele38= driver.findElement(
					By.xpath("(//input[@placeholder='Type here..'])[1]"));
		   // js.executeScript("arguments[0].value='Institution001243'", ele38);
		    //send keys using action class.
		    									//Actions act=new Actions(driver);
		    act.sendKeys(ele38, "Institution").build().perform();
		   
//		    WebElement ele39= driver.findElement(
//					By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[2]/div[3]/input"));
//		    js.executeScript("arguments[0].click()", ele39);    
		    Thread.sleep(750);
		 //   act.sendKeys(Keys.TAB).build().perform();
		    act.sendKeys(Keys.TAB).build().perform();
		    Thread.sleep(750);
			act.sendKeys(Keys.ENTER).build().perform();
			
//		    WebElement ele40= driver.findElement(
//					By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[2]/div[5]/input"));
//		    js.executeScript("arguments[0].click()", ele40);	
			  Thread.sleep(750);
			    act.sendKeys(Keys.TAB).build().perform();
			    act.sendKeys(Keys.TAB).build().perform();
			    act.sendKeys(Keys.TAB).build().perform();
			    Thread.sleep(750);
				act.sendKeys(Keys.ENTER).build().perform();
				
			WebElement ele40= driver.findElement(
					  By.xpath("//button[normalize-space()='Save & Continue']"));
		    js.executeScript("arguments[0].click()", ele40);
	
	
	
	}

	@Then("finally leads to Notes section and fill all details then employee profile created")
	public void finally_leads_to_notes_section_and_fill_all_details_then_employee_profile_created() throws InterruptedException {
		Thread.sleep(500);				
		WebElement ele41= driver.findElement(
			By.xpath("//div[@class='btn btn-light']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", ele41);	
		    
	    Thread.sleep(500);
   		WebElement ele42= driver.findElement(
   			By.xpath("(//textarea[@placeholder='Type here..'])[1]"));
	    js.executeScript("arguments[0].value='Employee profile(mandatory fields) file has been completed'", ele42);

		WebElement ele43= driver.findElement(				  By.xpath("(//button[@ng-click='HRM_INS_UPD_EMPLOYEE_NOTES()'])[1]"));
		    js.executeScript("arguments[0].click()", ele43);	
	    Thread.sleep(500);

	    WebElement ele44= driver.findElement(
			  By.xpath("(//button[normalize-space()='Save & Continue'])[1]"));
		js.executeScript("arguments[0].click()", ele44);	
	}

}
//@Then("User starts filling all MandatoryFields in Primary Details section")
//public void user_starts_filling_all_mandatory_fields_in_primary_details_section() throws InterruptedException {
//@Then("Navigate to EmployeeInfo Page and starts filling its Mandatory Fields")
//public void navigate_to_employee_info_page_and_starts_filling_its_mandatory_fields() throws InterruptedException {
