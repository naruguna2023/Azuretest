package poiSample;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleInterestCalculater {

	public static void main(String[] args) throws NumberFormatException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.easycalculation.com/simple-interest.php");
		driver.manage().window().maximize();
		String path="C:\\Users\\gunai\\OneDrive\\Desktop\\Software Testing\\SeleniumFramework\\poidata.xlsx";
			XLUtils.setExcelFile(path,"Sheet1");
			System.out.println(path);
		int rowcount=XLUtils.getRowCount(path, "Sheet1");  // Number of code present in excel sheet
		System.out.println(rowcount);
		
		

		for(int i=1;i<=rowcount;i++)
		{
			int princ=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 0)); 
			System.out.println(princ);
			int rateofinterest=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 1));  // type casting 
			System.out.println(rateofinterest);
			int time=Integer.parseInt(XLUtils.getCellData(path, "Sheet1", i, 2)); // type casting
			Double exp_si=Double.parseDouble(XLUtils.getCellData(path, "Sheet1",i,3));
			Double finalamt=Double.parseDouble(XLUtils.getCellData(path, "Sheet1",i,4));
			//double exp_si=Double.parseDouble(XLUtils.getCellData(path,"Sheet1",i,3));
			//double finalamt=Double.parseDouble(XLUtils.getCellData(path,"Sheet1",i,4));
			System.out.println(time);
			System.out.println(exp_si);
			System.out.println(finalamt);
			
			driver.findElement(By.name("res1")).sendKeys(String.valueOf(princ));
			driver.findElement(By.name("res2")).sendKeys(String.valueOf(rateofinterest));
			driver.findElement(By.name("res3")).sendKeys(String.valueOf(time));
			
			Select timedrp=new Select(driver.findElement(By.name("time")));
			timedrp.selectByVisibleText("Years");
			Thread.sleep(3000);
			String  act_si=driver.findElement(By.name("res4")).getAttribute("value");
			System.out.println(act_si);
			
				if(exp_si==Double.parseDouble(act_si) && finalamt==(princ+Double.parseDouble(act_si)))
      {
				System.out.println("Test Passed");
				XLUtils.selCellData(path,"Sheet",i,5,"passed");
}
else

{
System.err.println("Test failed");
XLUtils.selCellData(path,"Sheet",i,5,"failed");
}
			
				driver.findElement(By.xpath("//*[@id='dispCalcConts']/input[2]")).click(); //reset button
				
				Thread.sleep(3000);
		}

	}
}
