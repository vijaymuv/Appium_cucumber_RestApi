package stepdefinition;

import Utilities.UtilityFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pagesOfItBusinessBook.ObjectOfAllClasses;

public class StepLogin extends UtilityFiles {

    public static WebDriver  driver = UtilityFiles.browserLaunch("chrome");
    public ObjectOfAllClasses obj = new ObjectOfAllClasses(driver);
    @Given("user is on loginpage")
    public void user_is_on_loginpage() {
        getUrl("https://www.itbusinessbook.com/");
    }

    @When("user enters email or phone number and password")
    public void user_enters_email_or_phone_number_and_password() throws InterruptedException {
        sendKeysElement(obj.getLogin().getLogin(),"vijayametv@gmail.com");
        sendKeysElement(obj.getLogin().getPassword(),"Vijay@2608");
        Thread.sleep(3000);
    }

    @When("user click on loginbutton")
    public void user_click_on_loginbutton() throws InterruptedException {
        clickBtn(obj.getLogin().getSignIn());
        Thread.sleep(3000);
    }
    @Then("user is navigates to homepage")
    public void user_is_navigates_to_homepage() {
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        clickBtn(obj.getProfile().getProfileButton());
        clickBtn(obj.getLogout().getLogout());
        clickBtn(obj.getLogout().getOkButton());
    }

}
