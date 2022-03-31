package util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

public class Helper {

	public String readFromExcel(String fpath, String sheetname, int rownum, int colnum) {
		String cellvalue = null;
		try {
			Workbook workbook = null;
			FileInputStream fis = new FileInputStream(new File(fpath));
			DataFormatter df = new DataFormatter();
			String extenstion = FilenameUtils.getExtension(fpath);

			if (extenstion.equalsIgnoreCase("xls"))
				workbook = new HSSFWorkbook(fis);
			else if (extenstion.equalsIgnoreCase("xlsx"))
				workbook = new XSSFWorkbook(fis);
			else
				Assert.fail("FAIL | Valid excel extensions are xls or xlsx");

			Sheet sheet = workbook.getSheet(sheetname);
			Row row = sheet.getRow(rownum - 1);
			cellvalue = df.formatCellValue(row.getCell(colnum - 1));
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("FAIL | Excception thrown while reading from excel. Refer to log for details");
		}
		return cellvalue;
	}

}
