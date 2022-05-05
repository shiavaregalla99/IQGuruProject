package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
private static Workbook book;
private static Sheet sheet;
	
	private static void openExcel(String filepath) {
		try {
			FileInputStream fis= new FileInputStream(filepath);
		     book= new XSSFWorkbook(fis);//to read the data in xlsx format we are using 
		   // Workbook book1= new HSSFWorkbook(fis);//to read the data in xls format we are using 
		
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	
	}
		private static void loadSheet(String sheetName) {
	     sheet=book.getSheet(sheetName);
	}
		
		private static int rowCount() {
			return sheet.getPhysicalNumberOfRows();
		}
		private static int columnCount(int rowIndex) {
			return sheet.getRow(rowIndex).getLastCellNum();
		}
		
		private static String cellData(int rowInex,int colIndex) {
			return sheet.getRow(rowInex).getCell(colIndex).toString();
		}
		
		//return the 2d object array of the data
		
		public static Object[][] getData(String filepath,String sheetName){
			openExcel(filepath);
			loadSheet(sheetName);
			  int rows=rowCount();
			  int cols=columnCount(0);
			  Object[][] data= new Object[rows-1][cols];
			  for(int i=1;i<rows;i++) {
				  for(int j=0;j<cols;j++) { 
					  data[i-1][j]=cellData(i,j);
				  }
			  }
		
		 return data;
		
		
		}
}
