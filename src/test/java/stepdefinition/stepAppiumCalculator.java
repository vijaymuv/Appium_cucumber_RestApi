package stepdefinition;

import Appium.calcultorWebElementPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
public class stepAppiumCalculator {
public static calcultorWebElementPage cal ;
    @Given("user opens the calculator application")
    public void userOpensTheCalculatorApplication() throws IOException, InterruptedException {
        FileInputStream fis = new FileInputStream("C:\\Users\\Friday\\IdeaProjects\\ProjectsPractise\\AppiumProperties.properties");
        Properties p = new Properties();
        p.load(fis);

        System.out.println(p.getProperty("platformName"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,p.getProperty("platformName"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,p.getProperty("version"));
        capabilities.setCapability(MobileCapabilityType.UDID,p.getProperty("udid"));
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,p.getProperty("devicename"));
        capabilities.setCapability("appPackage",p.getProperty("Apppackage"));
        capabilities.setCapability("appActivity",p.getProperty("appactivity"));
        URL url = new URL(p.getProperty("urls"));
        AppiumDriver dr= new AppiumDriver(url,capabilities);
        cal = new calcultorWebElementPage(dr);
        Thread.sleep(2000);
    }
    @When("user clicks three and four number")
    public void userClicksThreeAndFourNumber() {
        cal.getThree().click();
        cal.getFour().click();


    }
    @When("user clicks plus button")
    public void userClicksPlusButton() {
        cal.getPlus().click();
    }
    @When("user clicks two number")
    public void userClicksTwoNumber() {
        cal.getTwo().click();

    }
    @Then("user validate the results")
    public void userValidateTheResults() throws InterruptedException {
        cal.getEqual().click();
        Thread.sleep(2000);
        String actual=cal.getResultPreview().getText();
        String expectedResult="36";
        System.out.println("Actual result: "+actual);
        Assert.assertEquals(expectedResult,actual);
        System.out.println("addition performed");
        cal.getClear().click();
    }

    @When("user clicks five and zero number")
    public void userClicksFiveAndZeroNumber() throws InterruptedException {
        Thread.sleep(3000);
        cal.getFive().click();
        cal.getZero().click();

    }
    @When("user clicks divisor button")
    public void userClicksDivisorButton() {
        cal.getDiv().click();
    }

    @Then("user validate the results of division")
    public void userValidateTheResultsOfDivision() {
        cal.getEqual().click();
        String Actualresult = cal.getResultPreview().getText();
        String expectedRslt="25";
        System.out.println("Actual result: "+Actualresult);
        Assert.assertEquals(expectedRslt,Actualresult);
    }

}
