package objectsitbusinessbook;

import Utilities.UtilityFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pagesOfItBusinessBook.*;
import static objectsitbusinessbook.emailOtp.getEmailData;
public class ForgetPassword_IT extends UtilityFiles {

    public static WebDriver driver = UtilityFiles.browserLaunch("chrome");
    ForgetPasswordPage forget = new ForgetPasswordPage(driver);
    LoginPage login = new LoginPage(driver);
    Logout log = new Logout(driver);
    ProfilePage profile = new ProfilePage(driver);
    public static String actualOtp;
    public static String message;

    @BeforeTest
    void getUrls() {
        getUrl("https://www.itbusinessbook.com/");

    }
    @DataProvider(name = "data")
    public Object[][] datasforit() {
        String S[][] = {{"yajiv@1secmail.com"},
                {"vijayv@1secmail.com"}};
        return S;
    }
    @Test(dataProvider = "data")
    void validateForgetPassword(String email) throws InterruptedException {
        login.getForgetPasswordBtn().click();

        forget.getEmail().sendKeys(email);
        Thread.sleep(2000);
        //Actions a = new Actions(driver);
        //a.click(driver.findElement(By.cssSelector("button[id='rlogin']"))).perform();
        driver.findElement(By.cssSelector("button[id='rlogin']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[id='rlogin']")).click();
        Thread.sleep(4000);
        String css = "span[style='background: #c4c2c2;']";                  //Link of that Button
        actualOtp = getEmailData(email, css, 2);
        System.out.println("Actual : " + actualOtp);
        message = "We received a request to change your password\n" +
                "  Hi,\n" +
                "  Your New Password for Signing Up with ItBusinessBook is:" + actualOtp +
                "\n" +
                " Thanks for your time,\n" +
                " The ItBusinessBook Team";
        System.out.println(message);
       // driver.get("https://www.itbusinessbook.com/");

        sendKeysElement(login.getLogin(),email);
        sendKeysElement(login.getPassword(),actualOtp);
        Thread.sleep(2000);
        clickBtn(login.getSignIn());
        Thread.sleep(2000);
        String actual = driver.getTitle();
        String expected = "News Feed | ITBusinessBook";
        Thread.sleep(2000);
         clickBtn(profile.getProfileButton());
         clickBtn(log.getLogout());
        clickBtn(log.getOkButton());
    }

    @AfterTest
    void closeBrowser() throws InterruptedException {
        driver.close();
    }



   }
