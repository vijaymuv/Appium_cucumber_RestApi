package KeyWordDriven;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {
   public static String keywordValues;
    public static String testDataValues;
    File file;
    FileInputStream fis;
    XSSFWorkbook work;
    XSSFSheet sheet;
    XSSFCell cell;
    public static String stringCellValue;
    public static String locators;
    public static String locatorName;
    public static String locatorvalue;
  public static int lastRowNum;
  public  void readExcel(String location) throws IOException {
File file = new File(location);
        fis= new FileInputStream(file);
        work = new XSSFWorkbook(fis);
        sheet = work.getSheet("Sheet3");
        lastRowNum = sheet.getLastRowNum();
  }
   public void getvaluesExcel(int row, int locator,int keywordaction,int testdata){
       locators = sheet.getRow(row).getCell(locator).toString().trim();
       //  cell = sheet.getRow(row).getCell(locator);
       // stringCellValue  = cell.getStringCellValue();

       if (!locators.contains("NA")){

           locatorName = locators.split("==")[0].toString().trim();
           locatorvalue = locators.split("==")[1].toString().trim();

       }else {
           locatorName="NA";
           locatorvalue="NA";
       }
       keywordValues = sheet.getRow(row).getCell(keywordaction).toString().trim();
       testDataValues = sheet.getRow(row).getCell(testdata).toString().trim();
       System.out.println(locatorName +" "+locatorvalue +" "+keywordValues +" "+testDataValues);
   }
}
