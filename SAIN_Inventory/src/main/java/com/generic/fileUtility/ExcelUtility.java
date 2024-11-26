package com.generic.fileUtility;
/**
 * 
 * Contains methods to interact with excel document
 * @author Rajani
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/**
	 * Fetches the data from the particular sheet, row and column
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @return String
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetName, int rowNo, int cellNo) throws Throwable {

		FileInputStream fisE = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNo);
		String value = row.getCell(cellNo).getStringCellValue();
		wb.close();

		return value;
	}

	/**
	 * Fetches total row count of the specified row
	 * 
	 * @param sheetName
	 * @return int
	 * @throws Throwable
	 * @throws IOException
	 */
	public int getRowCount(String sheetName) throws Throwable, IOException {

		FileInputStream fisE = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		int count = wb.getSheet(sheetName).getLastRowNum();
		return count;
	}

	/**
	 * Writes the data to specified cell of the row of the sheet
	 * 
	 * @param sheetName
	 * @param rowNo
	 * @param cellNo
	 * @param data
	 * @throws Throwable
	 * @throws IOException
	 */
	public void setDataToExcel(String sheetName, int rowNo, int cellNo, String data) throws Throwable, IOException {

		FileInputStream fisE = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fisE);
		wb.getSheet(sheetName).getRow(rowNo).createCell(cellNo, CellType.STRING).setCellValue(data);

		FileOutputStream fosE = new FileOutputStream("");
		wb.write(fosE);
		wb.close();
	}
}
