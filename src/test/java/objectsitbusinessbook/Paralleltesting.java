package objectsitbusinessbook;

import Utilities.UtilityFiles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesOfItBusinessBook.LoginPage;
import pagesOfItBusinessBook.Logout;
import pagesOfItBusinessBook.ProfilePage;
import pagesOfItBusinessBook.SignUp;

import java.io.IOException;

public class Paralleltesting extends UtilityFiles {

    public static WebDriver driver;
    public LoginPage login;
    public SignUp signup;
    public Logout log;
    public ProfilePage profile;

    @Test(dataProvider = "logindetails")
    public void dataProviderApache1(String username,String password) throws InterruptedException {
        driver = UtilityFiles.browserLaunch("chrome");
        signup = new SignUp(driver);
        login = new LoginPage(driver);
        profile=new ProfilePage(driver);
        log = new Logout(driver);
        getUrl("https://www.itbusinessbook.com/");
        System.out.println("username"+username);
        sendKeysElement(login.getLogin(),username);
        sendKeysElement(login.getPassword(),password);

        Thread.sleep(3000);
        clickBtn(login.getSignIn());
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
       // clickBtn(profile.getProfileButton());
      //  clickBtn(log.getLogout());
       // clickBtn(log.getOkButton());
    }

    @Test(dataProvider = "logindetails")
    public void dataProviderApache2(String username,String password) throws InterruptedException {
        driver = UtilityFiles.browserLaunch("chrome");
        signup = new SignUp(driver);
        login = new LoginPage(driver);
        profile=new ProfilePage(driver);
        log = new Logout(driver);
        getUrl("https://www.itbusinessbook.com/");
        System.out.println("username"+username);
        sendKeysElement(login.getLogin(),username);
        sendKeysElement(login.getPassword(),password);

        Thread.sleep(3000);
        clickBtn(login.getSignIn());
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
     //   clickBtn(profile.getProfileButton());
      //  clickBtn(log.getLogout());
       // clickBtn(log.getOkButton());
    }
    @DataProvider(name = "logindetails")
    public String[][] data() throws IOException {

        String [] [] logindata={

                {"vickymurugan@gmail.com","Vicky@12345"},
                {"vijaymurugan@gmail.com","Vicky@12345"}

        };
        return logindata;
    }

    @AfterTest
    void CloseBrowser(){
        //driver.close();

    }

}
