package stepdefinition;

import Utilities.UtilityFiles;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import pagesOfItBusinessBook.ObjectOfAllClasses;

public class StepLoginInValidate extends UtilityFiles {
    public static WebDriver driver = UtilityFiles.browserLaunch("chrome");
    ;
    public ObjectOfAllClasses obj = new ObjectOfAllClasses(driver);

    @Given("user enters url into website login page should be present")
    public void userEntersUrlIntoWebsiteLoginPageShouldBePresent() {
        getUrl("https://www.itbusinessbook.com/");
    }
    @When("user enters email as vijayametv@gmail.com")
    public void userEntersEmailAsVijayametvGmailCom() {
        sendKeysElement(obj.getLogin().getLogin(),"vijayametv@gmail.com");

    }
    @When("user enters password as Vijay@{int}")
    public void userEntersPasswordAsVijay(Integer int1) throws InterruptedException {
        sendKeysElement(obj.getLogin().getPassword(),"Vijay@2608");
        System.out.println(int1);
        Thread.sleep(3000);
    }
    @Then("login should be success")
    public void loginShouldBeSuccess() throws InterruptedException {
        clickBtn(obj.getLogin().getSignIn());
        Thread.sleep(3000);
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        Assert.assertEquals(actualTile,expectedTitle);
        clickBtn(obj.getProfile().getProfileButton());
        clickBtn(obj.getLogout().getLogout());
        clickBtn(obj.getLogout().getOkButton());
    }
    @When("user enters email as vijay@gmail.com")
    public void userEntersEmailAsVijayGmailCom() {
        sendKeysElement(obj.getLogin().getLogin(),"vijay@gmail.com");
    }
    @When("user enters password vijay into field")
    public void userEntersPasswordVijayIntoField() throws InterruptedException {
        sendKeysElement(obj.getLogin().getPassword(),"vijay");
        Thread.sleep(3000);
    }
    @Then("login should be fail")
    public void loginShouldBeFail() throws InterruptedException {
        clickBtn(obj.getLogin().getSignIn());
        Thread.sleep(3000);
        String expectedTitle ="Log In or Sign Up | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        clickBtn(obj.getProfile().getProfileButton());
        Assert.assertEquals(actualTile,expectedTitle);
    }
    @When("user enters email as {string}")
    public void userEntersEmailAs(String email) {
       sendKeysElement(obj.getLogin().getLogin(),email);
    }
    @When("user enters password as {string}")
    public void userEntersPasswordAs(String pass) throws InterruptedException {
        sendKeysElement(obj.getLogin().getPassword(),pass);
        Thread.sleep(3000);
    }

}
