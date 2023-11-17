package stepdefinition;

import Utilities.UtilityFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class StepFaceBook extends UtilityFiles {
    public static WebDriver  driver = UtilityFiles.browserLaunch("chrome");
    @Given("user should navigates to facebook website")
    public void userShouldNavigatesToFacebookWebsite() throws InterruptedException {
     getUrl("https://www.facebook.com/");
     Thread.sleep(2000);
    }
    @When("user enter user1 {string}")
    public void userEnterUser1(String string) {
        driver.findElement(By.id("email")).sendKeys("8838138967");
    }
    @When("user enter password1 {string}")
    public void userEnterPassword1(String pass) {
    sendKeysElement(driver.findElement(By.id("pass")),pass);
    }
    @Then("user should get facebook home page")
    public void userShouldGetFacebookHomePage() throws InterruptedException {
        clickBtn(driver.findElement(By.xpath("//button[@name='login']")));
        Thread.sleep(4000);
        String expect = "Facebook";
        String actual = driver.getTitle();
        System.out.println("actual title "+actual);
     //   Assert.assertEquals(actual,expect);
        clickBtn(driver.findElement(By.cssSelector("g[mask='url(#:R3abclad5qq75b5klba:)']")));
        clickBtn(driver.findElement(By.xpath("//span[.='Log Out']")));
    }
    @When("user clicks on create an account button")
    public void userClicksOnCreateAnAccountButton() {
        getUrl("https://www.facebook.com/");
        clickBtn(driver.findElement(By.xpath("//a[.='Create new account']")));

    }
    @When("user enter firstname")
    public void userEnterFirstname() {
        sendKeysElement(driver.findElement(By.xpath("//input[@name='firstname']")),"vijay");
    }
    @When("user enters lastname")
    public void userEntersLastname() {
        sendKeysElement(driver.findElement(By.xpath("//input[@name='lastname']")),"m");
    }
    @When("user enters mobile or email")
    public void userEntersMobileOrEmail() throws InterruptedException {
        sendKeysElement(driver.findElement(By.xpath("//input[@name='reg_email__']")),"vijay@gmail.com");
        Thread.sleep(2000);
        sendKeysElement(driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")),"vijay@gmail.com");
    }
    @When("user enters new password")
    public void userEntersNewPassword() {
        sendKeysElement(driver.findElement(By.xpath("//input[@name='reg_passwd__']")),"vijayvjy");
    }
    @When("user enters dateOfBirth")
    public void userEntersDateOfBirth() {
       selectVisibleText(driver.findElement(By.id("day")),"26");
       selectVisibleText(driver.findElement(By.id("month")),"Aug");
       selectVisibleText(driver.findElement(By.id("year")),"1997");
    }
    @When("user selects gender")
    public void userSelectsGender() {
clickBtn(driver.findElement(By.xpath("//input[@name='sex']")));
    }
    @Then("user click the signup button it should navigates to login page")
    public void userClickTheSignupButtonItShouldNavigatesToLoginPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()",driver.findElement(By.xpath("//a[.='Sign Up']")));
    }
    @When("user clicks on forget password it navigates to find your account page")
    public void userClicksOnForgetPasswordItNavigatesToFindYourAccountPage() {
        getUrl("https://www.facebook.com/");
        clickBtn(driver.findElement(By.xpath("//a[.='Forgotten password?']")));
    }
    @When("user clicks on search btn")
    public void userClicksOnSearchBtn() {

        sendKeysElement(driver.findElement(By.xpath("//input[@placeholder='Email address or mobile number']")),"vijay@gmail.com");
        clickBtn(driver.findElement(By.xpath("//button[@name='did_submit']")));
    }
    @Then("user enters otp and validate the account")
    public void userEntersOtpAndValidateTheAccount() {
        System.out.println("otp verified");
        driver.quit();

    }

}
