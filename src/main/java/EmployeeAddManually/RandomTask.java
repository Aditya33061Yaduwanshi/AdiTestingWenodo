package EmployeeAddManually;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class RandomTask {

public static void main(String[] args) throws InterruptedException {
	
for(int i=1;i<=10;i++) {
	System.setProperty("webdriver.chrome.driver",
	"C:\\Users\\Wenodo\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
//	driver.get("https://testing.wenodo.com/Login");
//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
//	driver.close();
	
		}	
	}
}