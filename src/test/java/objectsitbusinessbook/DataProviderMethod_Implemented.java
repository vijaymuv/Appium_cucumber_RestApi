package objectsitbusinessbook;

import Utilities.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pagesOfItBusinessBook.LoginPage;
import pagesOfItBusinessBook.Logout;
import pagesOfItBusinessBook.ProfilePage;
import pagesOfItBusinessBook.SignUp;
import java.io.IOException;
import java.time.Duration;

public class DataProviderMethod_Implemented extends BaseClass {

    public WebDriver driver=brlaunch("edge");
        public LoginPage login;
        public SignUp signup;
        public Logout log;
        public ProfilePage profile;
        @BeforeTest
        public void setUp( ) throws IOException {
           BaseClass bs =new BaseClass();
            signup = new SignUp(driver);
            login = new LoginPage(driver);
            profile=new ProfilePage(driver);
            log = new Logout(driver);
//           getUrl("https://www.itbusinessbook.com/");
            driver.get("https://www.itbusinessbook.com/");
        }
    @Test(dataProvider = "logindetails")
    public void dataProviderApache1(String username,String password) throws InterruptedException {
        System.out.println("username"+username);
        System.out.println("password: "+password);
//        sendKeysElement(login.getLogin(),username);
//        sendKeysElement(login.getPassword(),password);
        login.getLogin().sendKeys(username);
        login.getPassword().sendKeys(password);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Thread.sleep(2000);
        login.getSignIn().click();
        Thread.sleep(2000);
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        Assert.assertEquals(expectedTitle,actualTile);
        try {
            profile.getProfileButton().click();
            log.getLogout().click();
            log.getOkButton().click();

        } catch(Exception e){

        }
    }
    @DataProvider(name = "logindetails")
    public String[][] data() throws IOException {

        String [] [] logindata={

            {"vickymurugan@gmail.com","Vicky@12345"}
//            {"vijayame@gmail.com","vy@2608"}

            };
        return logindata;
    }

//    @AfterTest
//    void CloseBrowser(){
//
//        //driver.close();
//
//    }

    }

