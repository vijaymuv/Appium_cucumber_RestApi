package api.utilities;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class DataDriven {

   @DataProvider(name = "data")
    public String[][] getAllData() throws IOException {
            File file = new File("C:\\Users\\Friday\\Downloads\\datasapi.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook work = new XSSFWorkbook(fis);
            XSSFSheet s = work.getSheet("Sheet4");
            // int noofRows = s.getPhysicalNumberOfRows();
            int lastRowNum = s.getLastRowNum();
            System.out.println("noforwoes"+lastRowNum);

            int noOfColumn = s.getRow(1).getLastCellNum();
               String data [][]=new String[lastRowNum][noOfColumn];
            for (int i = 1; i <=lastRowNum; i++) {
                for (int j = 0; j < noOfColumn; j++) {
                    DataFormatter df = new DataFormatter();
                    data[i-1][j]= df.formatCellValue(s.getRow(i).getCell(j));

                }
            }
       return data;
    }


    @DataProvider(name="userdata")
    public String[] username() throws IOException {
        File file = new File("C:\\Users\\Friday\\Downloads\\datasapi.xlsx");
        FileInputStream fis = new FileInputStream(file);
        XSSFWorkbook work = new XSSFWorkbook(fis);
        XSSFSheet s = work.getSheet("Sheet4");
        int lastRowNum = s.getLastRowNum();
        String Userdata[]=new String[lastRowNum];

        for (int i = 1; i <=lastRowNum ; i++) {
            DataFormatter df = new DataFormatter();
            Userdata[i-1]= df.formatCellValue(s.getRow(i).getCell(1));
            System.out.println(Userdata[i-1]);
        }

        return Userdata;
    }




}
