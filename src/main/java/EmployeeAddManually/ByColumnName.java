package EmployeeAddManually;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ByColumnName {
	public static void main(String[] args) throws IOException {

		ExtentHtmlReporter htmlReporter=new ExtentHtmlReporter("3rd.html");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(htmlReporter);		
		ExtentTest EmployeeAddManually = extent.createTest("EmployeeAddManually Module");
				
		String excelfilename="Employees2";
		String excelFilePath="C:\\Users\\Wenodo\\Downloads\\"+excelfilename+".xlsx";
		FileInputStream inputstream=new FileInputStream(excelFilePath);			
		XSSFWorkbook workbook=new XSSFWorkbook(inputstream);				
		XSSFSheet sheet= workbook.getSheet("Sheet1");
		int rows=sheet.getLastRowNum();
		//int cols=sheet.getRow(1).getLastCellNum();
		//for(int r=1;r<=1;r++) {//1
		//	XSSFRow row=sheet.getRow(r);
				
						XSSFRow row=sheet.getRow(0);
						XSSFCell cell =null;		
						int colNum=-1;
						for(int r=1;r<=rows;r++) {	
		System.setProperty("webdriver.chrome.driver",
		"C:\\Users\\Wenodo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();	
		JavascriptExecutor js = (JavascriptExecutor) driver;	
		
		LandingPage landing =new LandingPage(driver);
		PrimaryDetails pm=new PrimaryDetails(driver);
		EmploymentInfo ei =new EmploymentInfo(driver);
		Wages w=new Wages(driver);
		Absences ab=new Absences(driver);
		Access ac=new Access(driver);   
		Document doc=new Document(driver);
		Assets as=new Assets(driver);
		Qualification q=new Qualification(driver);
		Notes n=new Notes(driver);	
		int rowNumber=r+1;
		try {
		
//		EmployeeAddManually.log(Status.INFO, "Test Data for(Employee Add Manually) excel sheet name "+excelfilename+" row number "+rowNumber+" has started." );
//		extent.flush();
		
		landing.launchTheApplication(driver);
//		EmployeeAddManually.log(Status.PASS, "Successfully Launch The Application" );
		landing.loginApplication(driver);
//		EmployeeAddManually.log(Status.PASS, "Successfully Login done" );
		landing.redirectingToEmployeeAddManually(driver);
//		EmployeeAddManually.log(Status.PASS, "redirectingToEmployeeAddManually successfully done" );
//		extent.flush();
		
		pm.mandatoryFields(row, sheet, cell,colNum,rows,r);	
		pm.nonmandatoryPrimaryFields(driver,row, sheet, cell,colNum,rows,r);
//		EmployeeAddManually.log(Status.PASS, "primaryDetails section fields successfully filled" );
//		extent.flush();
		
		
		ei.employmentInfoMandatoryFields(driver,row, sheet, cell,colNum,rows,r);
		ei.nonMandatoryEmploymentFields(driver);
//		EmployeeAddManually.log(Status.PASS, "Employment section Details successfully filled" );
//		extent.flush();
		
		w.wagesMandatoryFields(driver);		
		w.nonMandatoryFieldWages(driver);
//		EmployeeAddManually.log(Status.PASS, "Wages section Details successfully filled" );
//		extent.flush();
		
		ab.AbsencePageMandatoryField(driver);	
		ab.nonMandatoryFieldsAbsencesPage(driver);
//		EmployeeAddManually.log(Status.PASS, "Absence section Details successfully filled" );
//		extent.flush();
		
		ac.accessPageMandatoryFields(driver);	
		doc.saveDocumentPage(driver);
//		EmployeeAddManually.log(Status.PASS, "Access & Document section Details successfully filled" );
//		extent.flush();
		//aditest1.pass("enter user email");
		//extent.flush(); //Adi pay Attention
		
		as.assetsPageMandatoryFields();
		as.nonMandatoryFieldsAssetsPage(driver);
//		EmployeeAddManually.log(Status.PASS, "Assets section Details successfully filled" );
//		extent.flush();
		
		q.qualificationMandatoryFields(driver);	 
		q.nonMandatoryFieldsQualificationPage(driver);
		n.notesPageFields(driver);
//		EmployeeAddManually.log(Status.PASS, "Notes section Details successfully filled" );
//		extent.flush();
		
		
        int rowNum = r; 
        int colNumAdi = 30;
        Row row2 = sheet.getRow(rowNum);
        XSSFCell cell2 = (XSSFCell) row2.createCell(colNumAdi);
        cell2.setCellValue("Employee Created");
        FileOutputStream fos = new FileOutputStream(excelFilePath);
            workbook.write(fos);

				
		//workbook.close();
		//inputstream.close();
		driver.close();
		EmployeeAddManually.log(Status.PASS, "test case completed for(Employee Add Manually) excel sheet name "+excelfilename+"row number"+rowNumber+".");
//		EmployeeAddManually.info(" ");
		extent.flush();
		}
		
	
		catch (Exception e) {
		System.out.println("catch adi");
		
	        int rowNum = r; 
	        int colNumAdi = 30;
	        Row row2 = sheet.getRow(rowNum);
	        XSSFCell cell2 = (XSSFCell) row2.createCell(colNumAdi);
	        cell2.setCellValue("Employee Not Created");
	        FileOutputStream fos = new FileOutputStream(excelFilePath);
	            workbook.write(fos);
	            
		e.printStackTrace();
		
//		workbook.close(); this will
//		fos.close();		corrupt the file.
		//driver.close();
		EmployeeAddManually.log(Status.FAIL, "test case failed for(Employee Add Manually) excel sheet name "+excelfilename+"row number"+rowNumber+"." );
//		EmployeeAddManually.info(" ");
		extent.flush();
		}
		System.out.println("Completed till row number "+rowNumber);
		}
		workbook.close();
		inputstream.close();
	}	
			
	
}
