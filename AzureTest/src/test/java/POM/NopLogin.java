package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NopLogin {

	WebDriver driver;
	public static WebElement element;
	
	public static WebElement username_Siginin(WebDriver driver)
	{
		element=driver.findElement(By.id("Email"));
		return element;
	}
	public static WebElement password_Siginin(WebDriver driver)
	{
		element=driver.findElement(By.id("Password"));
		return element;
	}
	public static WebElement button_Siginin(WebDriver driver)
	{
		element=driver.findElement(By.xpath("//button[text()='Log in']"));
		return element;
	}

}
