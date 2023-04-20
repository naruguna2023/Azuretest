package log4jSample;

import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Log4jdemo2 {

	WebDriver driver;
	static Logger logger;
	@Test(priority=1)
	public void setup()
	{
		logger=Logger.getLogger("Log4jdemo2");  // provide test are name / class name as a parameter
		PropertyConfigurator.configure("log4j.properties");
		logger.info("Setup method is Started");
		logger.info("Setup method is progress");
		System.out.println("This is setup method");
			
	}
	
	@Test(priority=2)
	public void login()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		logger.info("Launching Browser");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		logger.info("Launching the nopcommerce home page");
	     driver.findElement(By.id("Email")).clear();
	     driver.findElement(By.id("Email")).sendKeys("admin@youstore.com");
	     logger.info("username entered");
	     driver.findElement(By.id("Password")).clear();
	     driver.findElement(By.id("Password")).sendKeys("admin");
	     logger.info("password Entered");
	     driver.findElement(By.xpath("//button[text()='Log in']")).click();
	     logger.info("login button clicked");
		
	}
	@Test(priority=3)
	public void logout()
	{
		System.out.println("This is logout test");
	     logger.info("logout is completed");
	}
	
	
	

}
