package com.framework.mobile.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.framework.mobile.global.LoadProperties;

public class TestDataProvider {

	private static File testData = new File(LoadProperties.TEST_DATA_PATH);

	@DataProvider(name = "Product Purchase")
	public static Object[][] getTestData() throws IOException {
		return ReadExcelSheetData(LoadProperties.WORKSHEET_NAME);
	}

	/**
	 * Method to store data of specified worksheet in an object array. Workbook path
	 * is as specified in the test.properties file.
	 * 
	 * @param sheetName worksheet name from which data is to be read
	 * @return
	 * @throws IOException
	 */
	public static Object[][] ReadExcelSheetData(String sheetName) throws IOException {
		String testDataPath = testData.getAbsolutePath();
		Workbook workbook = WorkbookFactory.create(new FileInputStream(testDataPath));
		Sheet worksheet = workbook.getSheet(sheetName);
		Row Row = worksheet.getRow(0);

		int RowNum = worksheet.getPhysicalNumberOfRows();
		int ColNum = Row.getLastCellNum();

		Object Data[][] = new Object[RowNum - 1][ColNum];

		for (int i = 0; i < RowNum - 1; i++) {
			Row row = worksheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) {
				if (row == null)
					Data[i][j] = "";
				else {
					Cell cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = "";
					else {
						String value = cell.getStringCellValue();
						Data[i][j] = value;
					}
				}
			}
		}

		return Data;
	}

}
