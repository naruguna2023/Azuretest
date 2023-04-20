package poiSample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FixedDepositeCalculater {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		String path="C:\\Users\\gunai\\OneDrive\\Desktop\\Software Testing\\SeleniumFramework\\caldata.xlsx";
		XLUtils.setExcelFile(path, "Sheet1");				
		int rowcount=XLUtils.getRowCount(path, "Sheet1"); // Number of code present in excel sheet
		
		
		for(int i=1;i<=rowcount;i++)
		{
			int princ=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 0)); 
			int rateofinterest=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 1));  // type casting 
			int per=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 2)); // type casting
			String fre=XLUtils.getCellData(path, "Sheet1",i,3);
			
			Double exp_mvalue=Double.parseDouble(XLUtils.getCellData(path,"Sheet1",i,4));
			driver.findElement(By.id("principal")).sendKeys(String.valueOf(princ));
			driver.findElement(By.id("interest")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.id("tenure")).sendKeys(String.valueOf(per));
			//Thread.sleep(3000);
			Select perioddrp=new Select(driver.findElement(By.id("tenurePeriod")));
			perioddrp.selectByVisibleText("month(s)");
			//Thread.sleep(3000);
			
			
			
			Select frequency=new Select(driver.findElement(By.name("frequency")));
			frequency.selectByVisibleText(fre);
			//Thread.sleep(3000);
			driver.findElement(By.name("res4")).getAttribute("value");
			String  act_mvalue=driver.findElement(By.name("res4")).getAttribute("value");
			
				if(exp_mvalue==Double.parseDouble(act_mvalue) )
      {
				System.out.println("Test Passed");
				
}
else

{
System.out.println("Test failed");

}
				Thread.sleep(2000);
				driver.findElement(By.xpath("//*[@id=\"fdMatVal\"]/div[2]/a[2]/img")).click();  ////a//img[@class='PL5']
				//reset button
	
	}
	
	}
}
