package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.gargoylesoftware.htmlunit.javascript.host.file.File;

public class Excel_Reader {
	
	
	public static Object[][] getData(String path,String sheetname) throws IOException
	{
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetname);
		
		
		int row=sheet.getLastRowNum();
		System.out.println("no of row are"+row);
		
		int col=sheet.getRow(row).getLastCellNum();
		System.out.println("no of columns are"+col);
		
		Object[][] data=new Object[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++)
			{
			
	        data[i][j]=sheet.getRow(i+1).getCell(j).toString();
	        System.out.println(data[i][j]);
	        
			}
			
		}
		
		return data;
		
		
	}

}
