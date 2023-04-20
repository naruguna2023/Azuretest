package seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NopCommerce {
	static WebDriver driver;
  @Test(priority=1)
  public void setup()   {
	 // String nodeURL = "http://172.168.100.102:4444/wd/hub";  // The URL will be  
	                                                                                                 //  ip address of hub machine + hub port +/wd/hub
	                                                                                                // "http://192.168.1:4444/ed/hub"
	                                                                                                // here hub and node are same machines
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	// driver=new RemoteWebDriver(new URL(nodeURL), ch);
	  
  }
  @Test(priority=2)
  void login()
  {
	  driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	  driver.findElement(By.id("Email")).clear();
	     driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
	     driver.findElement(By.id(("Password"))).clear();
	     driver.findElement(By.id(("Password"))).sendKeys("admin");
	     driver.findElement(By.xpath("//button[text()='Log in']")).click();
	     
	     // capture title of the home page
	     String act_title=driver.getTitle(); 
	     System.out.println(act_title);
	     String exp_title="Dashboard / nopCommerce administration";
	     if(act_title.equals(exp_title))
	     {
	    	 System.out.println("Test passed");
	     }
	     else
	     {
	    	 System.out.println("Test failed");
	     }
	     driver.quit();
  }
  
}
