package objectsitbusinessbook;

import Utilities.UtilityFiles;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pagesOfItBusinessBook.LoginPage;
import pagesOfItBusinessBook.Logout;
import pagesOfItBusinessBook.ProfilePage;
import pagesOfItBusinessBook.SignUp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@Listeners(IreporterHtml.class)
public class DataProvider_ApachePoi extends UtilityFiles {
    public static WebDriver driver;
    public LoginPage login;
    public SignUp signup;
    public Logout log;
    public ProfilePage profile;
    static Logger logs= Logger.getLogger(DataProvider_ApachePoi.class);
    @BeforeTest
public void setUp( ) throws IOException {
        PropertyConfigurator.configure("log4j.properties");
        driver = UtilityFiles.browserLaunch("chrome");
        signup = new SignUp(driver);
        login = new LoginPage(driver);
        profile=new ProfilePage(driver);
        log = new Logout(driver);
        logs.info("user launch the websites");
        getUrl("https://www.itbusinessbook.com/");

    }
    @Test(dataProvider = "userlogindetails")
    public void dataProviderApache1(String username,String password) throws InterruptedException {
        logs.info("user enters email and password");
      sendKeysElement(login.getLogin(),username);
      sendKeysElement(login.getPassword(),password);
        Thread.sleep(3000);
        clickBtn(login.getSignIn());
        Thread.sleep(3000);
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
       clickBtn(profile.getProfileButton());
       clickBtn(log.getLogout());
       clickBtn(log.getOkButton());
       logs.info("user logout the account");
    }
    @DataProvider(name = "userlogindetails")
    public String[][] data() throws IOException {

        String[][] data = new String[0][];
        try {
            File file = new File("C:\\Users\\Friday\\Downloads\\datasapi.xlsx");
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook work = new XSSFWorkbook(fis);
            XSSFSheet s = work.getSheet("Sheet2");
          //  int noofRows = s.getPhysicalNumberOfRows();
            int lastRowNum = s.getLastRowNum();
            System.out.println("noforwoes"+lastRowNum);
            int noOfColumn = s.getRow(1).getLastCellNum();
            data = new String[lastRowNum][noOfColumn];
            for (int i = 1; i <=lastRowNum; i++) {
                for (int j = 0; j < noOfColumn; j++) {
                    DataFormatter df = new DataFormatter();
                    data[i-1][j] = df.formatCellValue(s.getRow(i).getCell(j));
                }
            }
        } catch (Exception e){

        }
        return data;

    }
    @AfterTest
    void CloseBrowser(){
        driver.close();

    }
}
