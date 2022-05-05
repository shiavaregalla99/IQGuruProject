package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utils.ExcelUtility;

public class LoginTest {

	
	@Test(dataProvider="testDataFromExcel")
	public void dataDrivenTest(String UserName,String Password,String ErrorMessage) {
		System.setProperty("webdriver.chrome.driver", "D:\\IQGuru\\Softwares\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys(UserName);
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys(Password);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		String Actualerrormessage=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
	    Assert.assertEquals(Actualerrormessage, ErrorMessage,"both error message are not equal");
	    driver.close();
	}
	
	
	@DataProvider(name="testDataFromExcel")
	public Object[][] getDataFromExcel(){
	return ExcelUtility.getData("C:\\Users\\Shiva Regalla\\OneDrive\\Desktop\\Book1.xlsx", "Sheet3");
}
}