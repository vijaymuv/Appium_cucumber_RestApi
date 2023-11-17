package objectsitbusinessbook;

import Utilities.UtilityFiles;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesOfItBusinessBook.*;

public class SearchhFunction_IT extends UtilityFiles {

    public static WebDriver driver = UtilityFiles.browserLaunch("chrome");
    LoginPage login = new LoginPage(driver);
    HomePage home = new HomePage(driver);

    @BeforeTest
    void getUrls() throws InterruptedException {
        getUrl("https://www.itbusinessbook.com/");
        sendKeysElement(login.getLogin(),"Vijayametv@gmail.com");
        sendKeysElement(login.getPassword(),"Vijay@2608");
        Thread.sleep(2000);
        clickBtn(login.getSignIn());
    }
    @Test(dataProvider = "searchData")
    void searchFunc(String data) throws InterruptedException {
        home.getFindAll().clear();
        sendKeysElement(home.getFindAll(),data);
        clickBtn(home.getFdSearchBtn());
        Thread.sleep(2000);

    }
    @DataProvider(name="searchData")
    public String[][] datas(){
        String searchData[][]={{"ola"},{"zomato"
        }};
        return searchData;
    }

    @AfterTest
    void closeBrowser() throws InterruptedException {
        driver.close();
    }
}
