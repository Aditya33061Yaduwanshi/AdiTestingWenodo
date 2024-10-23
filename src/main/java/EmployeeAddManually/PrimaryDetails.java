package EmployeeAddManually;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class PrimaryDetails extends UtilityComponent {
	
	//for(int i=5;i<16;i++) {
    //int i=19;	
	public PrimaryDetails(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);	
	}
	JavascriptExecutor js = (JavascriptExecutor) driver;


		public void mandatoryFields(XSSFRow row, XSSFSheet sheet, XSSFCell cell, int colNum, int rows, int r) throws InterruptedException {
			waitForElementToAppear(500);
			driver.findElement(By.cssSelector("input[placeholder='Select Date / Type here.. ']")).click();
			waitForElementToAppear(1000);
		//	String DateOfBirth=takeDataFromExcel(6, row);
			colNum = getColumnName(row, "Date of birth");
			String DateOfBirth=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(By.cssSelector("input[placeholder='Select Date / Type here.. ']")).sendKeys(DateOfBirth);
//			waitForElementToAppear(500);
			
		//	String Firstname=takeDataFromExcel( 0, row);
			colNum = getColumnName(row, "First Name");
			String Firstname=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(By.name("FIRST_NAME")).sendKeys(Firstname);
		//	String Middlename=takeDataFromExcel(1, row);
			colNum = getColumnName(row, "Middle Name");
			String Middlename=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(By.name("MIDDLE_NAME")).sendKeys(Middlename);		
		// Lastname=takeDataFromExcel(2, row);
			colNum = getColumnName(row, "Last Name");
			String Lastname=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(By.name("LAST_NAME")).sendKeys(Lastname);

			// Nationality
			driver.findElement(
					//By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[3]/div[4]/ul/li"))
					By.xpath("/html/body/div[1]/div[2]/div[2]/ng-view/div[1]/div[2]/form/div[3]/div[4]/ul/li/a/span"))
					.click();
			waitForElementToAppear(1000);
		//	String Nationality=takeDataFromExcel(3, row);
			colNum = getColumnName(row, "Nationality");
			String Nationality=iterationAAstring(row, sheet, cell, colNum, rows, r);
			for(int n=1;n<=236;n++) {
				WebElement NaIterate=driver.findElement(By.xpath("(//li[@class='ng-scope'])["+n+"]"));
			String NationalityIterate=	driver.findElement(By.xpath("(//li[@class='ng-scope'])["+n+"]")).getText();
			
			if(NationalityIterate.equalsIgnoreCase(Nationality)) {
				NaIterate.click();
				break;
				}
			} 
					
			// Gender
			driver.findElement(
					//By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[3]/div[6]/ul/li/a"))
					By.xpath("//ul[@ng-class=\"{'error':primaryForm.submitted && primaryForm.GENDER_ID.$error.required}\"]//span[@id='select_label']"))
					.click();
			waitForElementToAppear(1000);
		//	String Gender=takeDataFromExcel(5, row);
			colNum = getColumnName(row, "Gender");
			String Gender=iterationAAstring(row, sheet, cell, colNum, rows, r);
		
			if(Gender.equalsIgnoreCase("male")) {
			driver.findElement(By.xpath("//span[normalize-space()='Male']")).click();
			}
			else if(Gender.equalsIgnoreCase("Female")) {
			driver.findElement(By.xpath("//span[normalize-space()='Female']")).click();
			}
			else if(Gender.equalsIgnoreCase("Do not wish to specify")) {
			driver.findElement(By.xpath("//span[normalize-space()='Do not wish to specify']")).click();	
			}
			
			XSSFCell cell10=row.getCell(10);
		//	String PrimaryPhone=cell10.getStringCellValue();
			colNum = getColumnName(row, "Primary Phone");
			String PrimaryPhone=iterationAAstring(row, sheet, cell, colNum, rows, r);
			//String PrimaryPhone=takeDataFromExcel(10, row);
			driver.findElement(By.xpath("//*[@id=\"primaryphone\"]")).sendKeys(PrimaryPhone+"");	
			
		//	String Email=takeDataFromExcel(12, row);
			colNum = getColumnName(row, "Email");
			String Email=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(By.xpath("//*[@id=\"EMAIL\"]")).sendKeys(Email);	
		//	String AddressLine1=takeDataFromExcel(16, row);
			colNum = getColumnName(row, "Address Line 1");
			String AddressLine1=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(
					//By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[6]/div[1]/input"))
					By.xpath("(//input[@name='ADDRESS_LINE1'])[1]"))
					.sendKeys(AddressLine1);
		//	String AddressLine2=takeDataFromExcel(17, row);
			colNum = getColumnName(row, "Address Line 2");
			String AddressLine2=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(
					//By.xpath("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/form/div[6]/div[2]/input"))
					By.xpath("(//input[@name='ADDRESS_LINE2'])[1]"))
					.sendKeys(AddressLine2);
			
			// Country
			//performClickOnWebelement("//ul[@ng-class=\"{'error':primaryForm.submitted && primaryForm.COUNTRY_ID.$error.required}\"]//span[@id='select_label']");
			performClickOnWebelement("/html/body/div[1]/div[2]/div[2]/ng-view/div[1]/div[2]/form/div[6]/div[3]/ul/li/a/span");

			waitForElementToAppear(1000);
		//	String Country=takeDataFromExcel(18, row);
			colNum = getColumnName(row, "Country");
			String Country=iterationAAstring(row, sheet, cell, colNum, rows, r);
				for(int n=240;n<=475;n++) {
				WebElement CoIterate=driver.findElement(By.xpath("(//li[@class='ng-scope'])["+n+"]"));
			String CountryIterate=	driver.findElement(By.xpath("(//li[@class='ng-scope'])["+n+"]")).getText();
			
			if(CountryIterate.equalsIgnoreCase(Country)) {
				CoIterate.click();
				break;
				}
			} 			
		//	String State=takeDataFromExcel(19, row);
			colNum = getColumnName(row, "State");
			String State=iterationAAstring(row, sheet, cell, colNum, rows, r);
			waitForElementToAppear(1000);
			driver.findElement(By.xpath("//input[@name='COUNTY']")).sendKeys(State);			
		//	String City=takeDataFromExcel(20, row);
			colNum = getColumnName(row, "City");
			String City=iterationAAstring(row, sheet, cell, colNum, rows, r);
			driver.findElement(By.name("CITY")).sendKeys(City);
		
//			    ALL COUNTRY CODES
			// starts from sp.
			if(Country.trim().toLowerCase().equalsIgnoreCase("India")) {
				
			}
			else {
			performClickOnWebelement("(//div[@title='India (भारत): +91'])[2]");			    
		    for(int n=2;n<=245;n++) {				    	
	    	    String LowerCountry=Country.trim().toLowerCase();
		        WebElement CountrySP= driver.findElement(By.xpath("(//span[@class='iti__country-name'])["+n+"]"));
		        String CountrySPname= driver.findElement(By.xpath("(//span[@class='iti__country-name'])["+n+"]")).getText();
			    String LowerCountrySPname=CountrySPname.trim().toLowerCase();

			if(LowerCountrySPname.contains(LowerCountry)) {
		    performClickOnWebelement("(//span[@class='iti__country-name'])["+n+"]");			   
				break;
				}
		    }
			// from 247 to 490 phone no.
		   waitForElementToAppear(1000);
		   performClickOnWebelement("(//div[@title='India (भारत): +91'])[2]");
		   waitForElementToAppear(1000);					
		    for(int n=247;n<=490;n++) {				    	
	  	    String LowerCountry=Country.trim().toLowerCase();
		        WebElement CountrySP= driver.findElement(By.xpath("(//span[@class='iti__country-name'])["+n+"]"));
		        String CountrySPname= driver.findElement(By.xpath("(//span[@class='iti__country-name'])["+n+"]")).getText();
			    String LowerCountrySPname=CountrySPname.trim().toLowerCase();

			if(LowerCountrySPname.contains(LowerCountry)) {
			    performClickOnWebelement("(//span[@class='iti__country-name'])["+n+"]");
				break;
				}
		    }
		   
			// from 492 to	735 primary phone but after 1sec time.
		    waitForElementToAppear(1000);
		    performClickOnWebelement("(//div[@title='India (भारत): +91'])");
		    waitForElementToAppear(1500);
		    for(int n=492;n<=735;n++) {				    	
		    String LowerCountry=Country.trim().toLowerCase();
		        WebElement CountrySP= driver.findElement(By.xpath("(//span[@class='iti__country-name'])["+n+"]"));
		        String CountrySPname= driver.findElement(By.xpath("(//span[@class='iti__country-name'])["+n+"]")).getText();
			    String LowerCountrySPname=CountrySPname.trim().toLowerCase();
			if(LowerCountrySPname.contains(LowerCountry)) {
			    performClickOnWebelement("(//span[@class='iti__country-name'])["+n+"]");				    
				break;
				}
		    }
		 }
	}			
				public void nonmandatoryPrimaryFields(WebDriver driver, XSSFRow row, XSSFSheet sheet, XSSFCell cell, int colNum, int rows, int r) throws InterruptedException {
				//Upload Profile Picture
			 driver.findElement(By.xpath("//input[@class=\"item-img filepreviewprofile\"]")).sendKeys("C:\\\\Users\\\\Wenodo\\\\Downloads\\\\user image.jpg");
			 waitForElementToAppear(1000);
  			 performClickOnWebelement("(//button[normalize-space()='Save Photo'])");
		         
  			 	//  NON MANDATORY FIELDS OF Primary details field		   	   
				waitForElementToAppear(1500);
			//	String Knownas=takeDataFromExcel(4, row);
				colNum = getColumnName(row, "Known As");
				String Knownas=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("(//input[@name='KNOWN_AS'])")).sendKeys(Knownas);
			//	String NInumber=takeDataFromExcel(7, row);
				colNum = getColumnName(row, "NI Number");
				String NInumber=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("(//input[@name='NI_NUMBER'])[1]")).sendKeys(NInumber);
			//	String TaxID=takeDataFromExcel(8, row);
				colNum = getColumnName(row, "Tax ID");
				String TaxID=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("(//input[@name='TAX_ID'])")).sendKeys(TaxID);
			//	String ShareCode=takeDataFromExcel(9, row);
				colNum = getColumnName(row, "Share Code");
				String ShareCode=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='SHARE_CODE']")).sendKeys(ShareCode);
				waitForElementToAppear(500);
				
			//	XSSFCell cell11=row.getCell(11);
			//	String SecondaryPhone=cell11.getStringCellValue();
				colNum = getColumnName(row, "Secondary Phone");
				String SecondaryPhone=iterationAAstring(row, sheet, cell, colNum, rows, r);
					//String SecondaryPhone=takeDataFromExcel(9, row);
				driver.findElement(By.xpath("//input[@id='secondaryphone']")).sendKeys(SecondaryPhone);
			//	String ContactName=takeDataFromExcel(13, row);
				colNum = getColumnName(row, "Contact Name");
				String ContactName=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='EMERGENCY_CONTACT_NAME']")).sendKeys(ContactName);
			//	String Relation=takeDataFromExcel(14, row);
				colNum = getColumnName(row, "Relation");
				String Relation=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='EMERGENCY_CONTACT_RELATION']")).sendKeys(Relation);
			//	XSSFCell cell15=row.getCell(15);
			//	long PhoneNo=(long) cell15.getNumericCellValue();
				colNum = getColumnName(row, "Phone Number");
				//long PhoneNo=iterationAAlong(row, sheet, cell, colNum, rows, r); depend upon excel file 
				String PhoneNo =iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='EMERGENCY_PHONE_NUMBER']")).sendKeys(PhoneNo+"");
			//	XSSFCell cell21=row.getCell(21);
			//	long PostCode=(long) cell21.getNumericCellValue();
				colNum = getColumnName(row, "Post Code");
				long PostCode=iterationAAlong(row, sheet, cell, colNum, rows, r); 
				driver.findElement(By.xpath("//input[@name='POSTAL_CODE']")).sendKeys(PostCode+"");
				waitForElementToAppear(500);

			//	String AHName=takeDataFromExcel(22, row);
				colNum = getColumnName(row, "Account Holder Name");
				String AHName=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='ACCOUNT_HOLDER_NAME']")).sendKeys(AHName);
			//	XSSFCell cell23=row.getCell(23);
			//	long AccountNumber=(long) cell23.getNumericCellValue();
				colNum = getColumnName(row, "Account Number");
				long AccountNumber=iterationAAlong(row, sheet, cell, colNum, rows, r); 
				driver.findElement(By.xpath("//input[@name='ACCOUNT_NUMBER']")).sendKeys(AccountNumber+"");
			//	XSSFCell cell24=row.getCell(24);
			//	String SortCode=cell24.getStringCellValue();
				colNum = getColumnName(row, "Sort Code");
				//long SortCode=iterationAAlong(row, sheet, cell, colNum, rows, r);  sort code is Alphanumeric
				String SortCode=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='SORT_CODE']")).sendKeys(SortCode);
			//	String BankName=takeDataFromExcel(25, row);
				colNum = getColumnName(row, "Bank Name");
				String BankName=iterationAAstring(row, sheet, cell, colNum, rows, r);
				driver.findElement(By.xpath("//input[@name='BANK_NAME']")).sendKeys(BankName);
				waitForElementToAppear(500);

			   performClickOnWebelement("//a[@aria-expanded='true']//span[@id='select_label']");
			   waitForElementToAppear(500);
			   performClickOnWebelement("(//span[normalize-space()='Plan-3'])[1]");
			   waitForElementToAppear(500);
			   driver.findElement(By.xpath("(//input[@name='STUDENT_LOAN_TYPE'])[1]")).sendKeys("4343434343");
		   
			   //save
			   //performClickOnWebelement("//*[@id=\"pageWrapper\"]/div[2]/div[2]/ng-view/div[1]/div/div[2]/div/button[2]");
			   performClickOnWebelement("(//button[normalize-space()='Save & Continue'])[1]");	
			}	
	
}
