package Practise_KeyWordDriven;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
public class ExcelFiles {
    File file;
    FileInputStream fis;
    XSSFWorkbook work;
    XSSFSheet sheet;
    public static int lastRow;
    public static String locatorsColumnValues;
    public static String locatorName;
    public static String locatorValue;
    public static String keywordValues;
    public static String testDataValues;

    public void read_Excel_locator_actions_testData(String location, int row, int locatorClm, int actionKeywordClm, int testDataClm) throws IOException {
        file = new File(location);
        fis = new FileInputStream(file);
        work = new XSSFWorkbook(fis);
        sheet = work.getSheet("Sheet4");
        lastRow = sheet.getLastRowNum();
        locatorsColumnValues = sheet.getRow(row).getCell(locatorClm).toString().trim();

        if (!locatorsColumnValues.contains("NA")) {

            locatorName = locatorsColumnValues.split("==")[0].toString().trim();
            locatorValue = locatorsColumnValues.split("==")[1].toString().trim();

        } else {
            locatorName = "NA";
            locatorValue = "NA";
        }
        keywordValues = sheet.getRow(row).getCell(actionKeywordClm).toString().trim();
        testDataValues = sheet.getRow(row).getCell(testDataClm).toString().trim();

        System.out.println(keywordValues+" "+testDataValues);
    }

}
