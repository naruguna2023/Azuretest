package POM;

import org.openqa.selenium.WebDriver;

public class NopTestCases {

	public static void verifySignin(WebDriver driver) {
		NopLogin.username_Siginin(driver).clear();
		NopLogin.username_Siginin(driver).sendKeys("admin@yourstore.com");
		NopLogin.password_Siginin(driver).clear();
		NopLogin.password_Siginin(driver).sendKeys("admin");
		NopLogin.button_Siginin(driver).click();
		

	}

}
