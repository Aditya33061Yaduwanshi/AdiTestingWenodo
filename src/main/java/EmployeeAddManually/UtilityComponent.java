package EmployeeAddManually;

import java.time.Duration;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class UtilityComponent {
	
	WebDriver driver;	
	public UtilityComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		//int i=93;
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		
		
	public void performClickOnWebelement(String xpathlocator) {
		//System.out.println("inside");
		 JavascriptExecutor js = (JavascriptExecutor) driver; 
	     WebElement ele451 =driver.findElement(By.xpath(xpathlocator));
		 js.executeScript("arguments[0].click()", ele451);
		 //System.out.println("outside");
		}
	
	public String takeDataFromExcel(int cellnumber,XSSFRow row ) {
		XSSFCell cell0=row.getCell(cellnumber);
		String vname=cell0.getStringCellValue();
//		if (vname.isEmpty()) {
//			vname=" ";  no need .YES
//		}
		
			/*			//Adi After S41-->  
						vname.toString();	  else {vname="";}	*/
		return vname;
	}
	
	public void waitForElementToAppear(int ms) throws InterruptedException {
		Thread.sleep(ms);
	}
	
	
	public void hiringDate() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(1500);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(750);		
	}
	public void startDate() throws InterruptedException {
		Actions act = new Actions(driver);
		Thread.sleep(1000);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
	}
	public void validUpToDate() throws InterruptedException {
		 Actions act = new Actions(driver);
		Thread.sleep(750);
	    //   act.sendKeys(Keys.TAB).build().perform();
	    act.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(750);
		act.sendKeys(Keys.ENTER).build().perform();//date when achieved ,present or future date.
	    Thread.sleep(750);
	    act.sendKeys(Keys.TAB).build().perform();
	    act.sendKeys(Keys.TAB).build().perform();
	    act.sendKeys(Keys.TAB).build().perform();
	    Thread.sleep(750);		
	}
	
	// ExcelByColumnName
	
	public static int getColumnName(XSSFRow row,String Adicolumn) {
		int colNum=-1;
		for(int i=0;i<row.getLastCellNum();i++) {
			if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(Adicolumn)) {
				colNum=i;
			}
		}
		System.out.println(colNum);
		return colNum;
		
	}
	public static String iterationAAstring(XSSFRow row,XSSFSheet sheet,XSSFCell cell,int colNum,int rows,int r) {
		//for(int r=1;r<rows;r++) {///////////////////////////////////////////////////////////

			row=sheet.getRow(r);
			cell=row.getCell(colNum);
			
			String variable=cell.getStringCellValue();
			//System.out.println(variable);
			return variable;	
			}
	//}
	
	public static long iterationAAlong(XSSFRow row,XSSFSheet sheet,XSSFCell cell,int colNum,int rows,int r) {
		//for(int r=1;r<rows;r++) {///////////////////////////////////////////////////////////

			row=sheet.getRow(r);
			cell=row.getCell(colNum);
			
			long variable=(long) cell.getNumericCellValue();
			//System.out.println(variable);	//(variable+"");
			return variable;
			}
	//}
}