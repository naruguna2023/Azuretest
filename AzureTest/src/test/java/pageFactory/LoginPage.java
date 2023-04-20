package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
LoginPage(WebDriver rdriver)	
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver , this);
}
@FindBy(id="Email")
WebElement username;

@FindBy(id="Password")
WebElement Password;

@FindBy(xpath="//button[text()='Log in']")
WebElement btnsignin;
public void setUserName(String uname)
{
	username.sendKeys(uname);
}
public void setPassworde(String pwd)
{
	Password.sendKeys(pwd);
}
public void clickSubmit()
{
	btnsignin.click();
}

}
