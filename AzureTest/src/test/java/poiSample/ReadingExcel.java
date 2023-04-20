package poiSample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream("G:\\TestData2023\\data3.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		//Counting Rows
		int rownum=sheet.getLastRowNum(); // returns number of row
		int colcount=sheet.getRow(0).getLastCellNum(); // returns numbet of cells present in a row
		System.out.println(rownum);
		System.out.println(colcount);
		for(int r=0;r<rownum;r++)
		{
			XSSFRow row=sheet.getRow(r);
			for(int c=0;c<colcount;c++)
			{
				//XSSFcell cell=row.getCell(c);
				//value=cell.toString();
				String value=row.getCell(c).toString();
				System.out.print(value+" ");
			}
			System.out.println(" ");
		}

	}

}
