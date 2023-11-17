package stepdefinition;

import Utilities.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import pagesOfItBusinessBook.ObjectOfAllClasses;


public class ParallelDemo extends BaseClass {

    static Logger log= Logger.getLogger(ParallelDemo.class);
  public  ObjectOfAllClasses obj;
    @Given("User is on first Page")
    public void user_is_on_first_page() {
        PropertyConfigurator.configure("log4j.properties");
brlaunch("chrome");
        driver.get("https://www.itbusinessbook.com/");
        log.info("it business book url launched");
        obj = new ObjectOfAllClasses(driver);
        driver.manage().deleteAllCookies();
    }
    @When("User Navigate to LogIn Page")
    public void user_navigate_to_log_in_page() {
        obj.getLogin().getLogin().sendKeys("vickymurugan@gmail.com");
        obj.getLogin().getPassword().sendKeys("Vicky@12345");
        log.info("user enters email and password");
    }
    @When("User enters UserName and Password")
    public void user_enters_user_name_and_password() throws InterruptedException {
        Thread.sleep(2000);
        obj.getLogin().getSignIn().click();
        log.info("user sucessfully gets home page");
    }
    @Then("Message displayed Login Successfully")
    public void message_displayed_login_successfully() throws InterruptedException {
        Thread.sleep(2000);
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        obj.getProfile().getProfileButton().click();
        obj.getLogout().getLogout().click();
        Thread.sleep(2000);
        obj.getLogout().getOkButton().click();
        driver.close();
        driver.quit();
        log.info("user sucessfully logout from page");
    }
    @Given("User is on register page")
    public void user_is_on_register_page() {
        brlaunch("chrome");
        driver.get("https://www.itbusinessbook.com/");
        obj = new ObjectOfAllClasses(driver);
    }
    @When("user enters firstname, email & password")
    public void user_enters_firstname_email_password() throws InterruptedException {
        obj.getLogin().getLogin().sendKeys("vijayametv@gmail.com");
        obj.getLogin().getPassword().sendKeys("Vijay@2608");
        Thread.sleep(2000);
        obj.getLogin().getSignIn().click();
    }
    @Then("Message displayed registered Successfully")
    public void message_displayed_registered_successfully() throws InterruptedException {
        Thread.sleep(2000);
        String expectedTitle ="News Feed | ITBusinessBook";
        String actualTile= driver.getTitle();
        System.out.println("actualTile:"+actualTile);
        obj.getProfile().getProfileButton().click();
        obj.getLogout().getLogout().click();
        Thread.sleep(2000);
        obj.getLogout().getOkButton().click();
        driver.close();
        driver.quit();
    }
}
