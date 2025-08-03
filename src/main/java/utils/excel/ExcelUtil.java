package utils.excel;

import org.apache.poi.ss.usermodel.*;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtil {

	public static Object[][] readSheet(String filePath, String sheetName) {
		try (FileInputStream fis = new FileInputStream(filePath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getPhysicalNumberOfRows();
			int colCount = sheet.getRow(0).getLastCellNum();

			Object[][] data = new Object[rowCount - 1][colCount];

			for (int i = 1; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				for (int j = 0; j < colCount; j++) {
					data[i - 1][j] = getCellValue(row.getCell(j));
				}
			}
			return data;
		} catch (IOException e) {
			throw new RuntimeException("Failed to read Excel file", e);
		}
	}

	private static Object getCellValue(Cell cell) {
		if (cell == null)
			return "";
		return switch (cell.getCellType()) {
		case STRING -> cell.getStringCellValue();
		case NUMERIC -> (int) cell.getNumericCellValue();
		case BOOLEAN -> cell.getBooleanCellValue();
		default -> "";
		};
	}

}
