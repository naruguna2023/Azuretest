package DataDrivenFramework;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class bddsample extends UtilityDemo  {
	static String Userdirectory= null;
	
  @Test
  public void f() throws Exception {
	try {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
		 //driver.get("https://accounts.lambdatest.com/login");
		driver.get("https://www.lambdatest.com/?utm_source=urldirect");
		 Thread.sleep(2000);
		 //driver.findElement(By.linkText("Login")).click();
		driver.findElement(By.linkText("Sign Up")).click();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 
	/*	 //Read File
		 Userdirectory = System.getProperty("user.dir");
		 FileInputStream fi=new FileInputStream(Userdirectory + "//Lamda.xlsx");
		 //FileInputStream fi=new FileInputStream("C:\\Users\\gunai\\OneDrive\\Desktop\\Software Testing\\SeleniumFramework\\Lamda.xlsx");
		 System.out.println(fi);
		 
		 //Get workbook from above path
		 Workbook wb=Workbook.getWorkbook(fi);
		 System.out.println(wb);
		 //Get sheet from above path
		 Sheet sht=wb.getSheet("register");
		 System.out.println(sht);
		 //Get Number of row available in sheet
		 int rcount=sht.getRows();
		 for(int i=1;i<rcount; i++)
		 {
			 //Target object type
			 String objtype=sht.getCell(2, i).getContents();
			 System.out.println(objtype);
			 
			 //Target propid from first column in same row
			 String propid=sht.getCell(1, i).getContents();
			 
			 //Target input from iput column
			 String input=sht.getCell(3, i).getContents();*/
		 
		 //Read File
		  FileInputStream fi=new FileInputStream("G:\\TestData2023\\Lamdatest.xls");
		  
		  //Get Workbook from above path
		  Workbook wb=Workbook.getWorkbook(fi);
		  
		  //Get sheet from above path
		  Sheet sht=wb.getSheet("Sheet2");
		  		  		  
		  //Get Number of rows available in sheet
		  int rcount=sht.getRows();
		  
		  for (int i = 1; i < rcount; i++) 
		  {
			  
			  //Target object type
			  String objtype=sht.getCell(2, i).getContents();
			  System.out.println(objtype);
			  
			  //Target propid from first column in same row
			  String propid=sht.getCell(1, i).getContents();
			  //Target input from input column
			  String input=sht.getCell(3, i).getContents();
			 switch (objtype) 
			  {
			  
			case "Link":
				driver.findElement(By.linkText(propid)).click();
				break;
				
			case "text":
				Thread.sleep(1000);
				driver.findElement(By.id(propid)).sendKeys(input);
				break;

			case "Dropdown":
				new Select(driver.findElement(By.id(propid))).selectByVisibleText(input);
				break;
			
			case "Button":
				Thread.sleep(1000);
				driver.findElement(By.xpath(propid)).click();
				break;

			case "Radio":
				driver.findElement(By.id(propid)).click();
				break;

			case "Checkbox":
				driver.findElement(By.id(propid)).click();

			default:
				break;
			 /*switch (objtype)		
			 
			 {
			 case "link":
			 driver.findElement(By.linkText(propid)).click();
			 break;
			 						 
			 case "text":
				 Thread.sleep(1000);
			 driver.findElement(By.id(propid)).sendKeys(input);
			 break;
			 
			 case "dropdown":
			 new Select(driver.findElement(By.id(propid))).selectByVisibleText(input);
			 break;
			 
			 case "button":
				 Thread.sleep(1000);
			 driver.findElement(By.xpath(propid)).click();
			 break;
			 
			 case "radio":
			 driver.findElement(By.id(propid)).click();
			 break;
			 
			 case "checkbox":
			 driver.findElement(By.id(propid)).click();
			 break;
			 
			 default:
				 break;*/
			  }				  
			
		  }		  		  
		  
	} catch (Exception e) {
		System.out.println(e);
	}
	  
 }
 

}
