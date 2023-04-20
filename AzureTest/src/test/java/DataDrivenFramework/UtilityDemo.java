package DataDrivenFramework;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class UtilityDemo {

	static String  Userdirectory=null;
public static String getPropvalue(String key)
{
	String value=null;
	try {
	Userdirectory =System.getProperty("user.dir");;
	Properties prop=new Properties();
	FileInputStream fis=new FileInputStream(Userdirectory + "//in.properties");
			prop.load(fis);
			value=prop.getProperty(key);
	}
	catch (Exception e)
	{
		System.out.println(e);
	}
	return value;
	
}
public static String getExcelData(String sheetname, int row ,int col)
{
String celldata=null;
try
{
	Userdirectory=System.getProperty("user.dir");
	FileInputStream fis=new FileInputStream(Userdirectory + "//TestData.xlsx");
	Workbook wb = WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	DataFormatter formatter=new DataFormatter();
	Cell cellformat=sh.getRow(row).getCell(col);
	celldata = formatter.formatCellValue(cellformat);
	System.out.println(celldata);
}
catch (Exception e)
{
	e.printStackTrace();
}
return celldata;
	
}

public static boolean doSendKeys(WebElement ele, String value)
{
	boolean f;
	try
	{
		ele.sendKeys(value);
		f=true;
	}
	catch (Exception e)
	{
		System.out.println(e);
		f=false;
	}
	
	return f;
	
}


public static boolean doCountry(WebElement ele , String value)
{
boolean f=true;
try
{
	Select s = new Select(ele);
	List<WebElement> ls=s.getOptions();
	for(WebElement s1: ls)
	{
		String s2=s1.getText();
		if(s2.equalsIgnoreCase(value))
		{
			s1.click();
			f=true;
			break;
		}
	}
	
}
catch (Exception e)
{
	System.out.println(e);
	f=false;
}
return f;

}
}

