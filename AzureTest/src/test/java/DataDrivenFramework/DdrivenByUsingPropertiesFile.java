package DataDrivenFramework;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Writer;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DdrivenByUsingPropertiesFile {
  @Test
  public void dataDrivenProp()  throws IOException, InterruptedException  {
	  WebDriverManager.chromedriver().setup();
		 WebDriver driver=new ChromeDriver();
	     driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	     driver.manage().window().maximize();  
	     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	     
	 try {    //Create Property class	     
	     Properties prop = new Properties();
	     //Load properties available in input file
	     FileInputStream fis=new FileInputStream("C:\\Users\\gunai\\OneDrive\\Desktop\\Software Testing\\SeleniumFramework\\IP.properties");
	    prop.load(fis);
	     //Get property using unique key
	     driver.findElement(By.id(prop.getProperty("username"))).clear();
	     driver.findElement(By.id(prop.getProperty("username"))).sendKeys(prop.getProperty("uidinput"));
	     driver.findElement(By.id(prop.getProperty("password"))).clear();
	     driver.findElement(By.id(prop.getProperty("password"))).sendKeys(prop.getProperty("pwinput"));
	     Thread.sleep(2000);
	     driver.findElement(By.xpath("//button[text()='Log in']")).click();
	     
	     //Set property to file
	     prop.setProperty("Result", driver.getTitle());
	     
	     //Load Property File
	     FileOutputStream fstore=new FileOutputStream("C:\\Users\\gunai\\OneDrive\\Desktop\\Software Testing\\SeleniumFramework\\OP.properties");
	     prop.store(fstore, null);
	 }
	    
  
	 catch (Exception e)
	 {
		 System.out.println(e.getMessage());
	 }
	     
  }
}
