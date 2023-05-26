package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class excel {

	@Test
	public void getExcel() throws IOException {

		// no excel version - data is stored in object
		// Object[][] data = { { "hello", "text", "1" }, { "bye", "message", "124" }, {
		// "solo", "call", "656" } }; // multidimensional object

		// every excel row is an array
		FileInputStream fis = new FileInputStream("E://learning//Selenium WebDriver course//demodata2.xlsx");

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);

		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int columnCount = row.getLastCellNum();

		Object data[][] = new Object[rowCount - 1][columnCount];

		for (int i = 0; i < rowCount - 1; i++) {

			// capturing rows excluding header (starting from 1 index)
			row = sheet.getRow(i + 1);
			for (int j = 0; j < columnCount; j++) {
				data[i][j] = row.getCell(j);
			}

		}

	}

}
