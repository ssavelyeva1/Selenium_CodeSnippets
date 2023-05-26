import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {

	public ArrayList<String> getData(String testCaseName) throws IOException {
		ArrayList<String> a = new ArrayList<String>();

		// fileInputStream argument - object has an access to the excel file
		FileInputStream fis = new FileInputStream("E://learning//Selenium WebDriver course//demodata.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		// getting the number of sheets presented in the file
		int sheets = workbook.getNumberOfSheets();

		// looping through file sheets and getting the one named 'testdata'
		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				// identifying 'Testcases' column by scanning the whole first row
				Iterator<Row> rows = sheet.iterator(); // sheet is a collection of rows
				Row firstrow = rows.next();
				Iterator<Cell> cell = firstrow.cellIterator(); // row is a collection of cells

				int k = 0;
				int column = 0; // column index
				while (cell.hasNext()) {
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						column = k;
					}
					k++;
				}
				// System.out.println(column);

				// scanning testcases column row by row to identify purchase test case
				while (rows.hasNext()) {
					Row row = rows.next();
					if (row.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {
						// pulling all the purchase row cells value and saving it to the array
						Iterator<Cell> cv = row.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next(); // cell value
							// checking the cell value type and adding it to the array
							if (c.getCellType() == CellType.STRING) {
								a.add(c.getStringCellValue());
							} else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		}

		return a;
	}

	public static void main(String[] args) throws IOException {

	}

}
