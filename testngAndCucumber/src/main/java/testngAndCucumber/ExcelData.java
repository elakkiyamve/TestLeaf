package testngAndCucumber;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {

	/*
	 * steps to read from excel
	 * open the workbook using filname and path
	 * go to specific sheet(bt sheet name or index)
	 * go to the specific row(by index)
	 * go to the specific cell(by index)
	 * 
	 * read the content
	 * 
	 */
	
	public static String[][] readData(String method) throws IOException {
			
		XSSFWorkbook wBook = new XSSFWorkbook("data/"+method+".xlsx");
		XSSFSheet sheet = wBook.getSheetAt(0);
		int rowCount = sheet.getLastRowNum();
		short columnCount = sheet.getRow(0).getLastCellNum();
		
		String[][] reData = new String [rowCount][columnCount];
			for (int i = 1; i <=rowCount ; i++) {
			XSSFRow row = sheet.getRow(i); 
			for (int j = 0; j <columnCount ; j++) {
			XSSFCell cell = row.getCell(j);
			System.out.println(cell.getStringCellValue());
			reData[i-1][j] = cell.getStringCellValue();
			
		}
		}wBook.close();
		return reData;
	}
}
