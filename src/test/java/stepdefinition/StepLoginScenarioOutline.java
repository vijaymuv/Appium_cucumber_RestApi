package stepdefinition;

import Utilities.UtilityFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pagesOfItBusinessBook.ObjectOfAllClasses;

public class StepLoginScenarioOutline  extends UtilityFiles {
    public static WebDriver driver = UtilityFiles.browserLaunch("chrome"); ;
    public ObjectOfAllClasses obj = new ObjectOfAllClasses(driver);

    @Given("user should enter url and get login page")
    public void userShouldEnterUrlAndGetLoginPage() {
        getUrl("https://www.itbusinessbook.com/");
    }
    @When("user enter {string} and {string} into txtfield")
    public void userEnterAndIntoTxtfield(String email, String pass) throws InterruptedException {
        sendKeysElement(obj.getLogin().getLogin(),email);
        sendKeysElement(obj.getLogin().getPassword(),pass);
        Thread.sleep(3000);
    }
    @When("user click on login element")
    public void userClickOnLoginElement() throws InterruptedException {
        clickBtn(obj.getLogin().getSignIn());
        Thread.sleep(3000);
    }
    @Then("user is navigates to homepage of it")
    public void userIsNavigatesToHomepageOfIt() {
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        clickBtn(obj.getProfile().getProfileButton());
        clickBtn(obj.getLogout().getLogout());
        clickBtn(obj.getLogout().getOkButton());
    }
}
