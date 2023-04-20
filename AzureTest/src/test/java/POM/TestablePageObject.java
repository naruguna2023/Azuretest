package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestablePageObject {
	static WebDriver driver;
  @Test
  public void f() {
	  WebDriverManager.chromedriver().setup();
	  driver=new ChromeDriver();
	  driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
	  driver.manage().window().maximize();
	  NopTestCases.verifySignin(driver);
	  
	 
	  
  }
}
