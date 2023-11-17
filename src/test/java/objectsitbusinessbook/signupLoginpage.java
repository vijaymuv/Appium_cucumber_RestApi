package objectsitbusinessbook;

import Utilities.UtilityFiles;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pagesOfItBusinessBook.LoginPage;
import pagesOfItBusinessBook.SignUp;

import java.io.IOException;
import java.time.Duration;


public class signupLoginpage extends UtilityFiles {
    public static WebDriver driver;
public LoginPage login;
public SignUp signup;

@Test
public void starts1() throws IOException {
driver=UtilityFiles.browserLaunch("chrome");
    signup = new SignUp(driver);
    login = new LoginPage(driver);

    try {
        getUrl(particularCell("Sheet1", 0, 1));
        clickBtn(signup.getSignUpBtn());
        sendKeysElement(signup.getFirstname(), particularCell("Sheet1", 1, 1));
        sendKeysElement(signup.getLastname(), particularCell("Sheet1", 2, 1));
        sendKeysElement(signup.getEmail(), particularCell("Sheet1", 3, 1));
        sendKeysElement(signup.getPass(), particularCell("Sheet1", 4, 1));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));

        wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
        clickBtn(signup.getCheckBox());
        clickBtn(signup.getRegisterBtn());
        sendKeysElement(login.getLogin(),particularCell("Sheet1", 3, 1));
sendKeysElement(login.getPassword(),particularCell("Sheet1", 4, 1));
clickBtn(login.getSignIn());
    } catch (IOException e) {
        System.out.println("error occoured");
    }
}
    }
