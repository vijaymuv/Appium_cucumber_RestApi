package Appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Calcy {
   public static calcultorWebElementPage cal;
    @Test
    public void add() throws IOException, InterruptedException {
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
        Thread.sleep(4000);

        //addition opertaion
        cal.getThree().click();
        cal.getFour().click();
        cal.getPlus().click();
        cal.getTwo().click();
        cal.getEqual().click();
        Thread.sleep(3000);
        String actual=cal.getResultPreview().getText();
        String expectedResult="36";
        System.out.println("Actual result: "+actual);
        Assert.assertEquals(expectedResult,actual);
        System.out.println("addition performed");
        cal.getClear().click();
        //division operation

        cal.getFive().click();
        cal.getZero().click();
        cal.getDiv().click();
        cal.getTwo().click();
        cal.getEqual().click();
        String Actualresult = cal.getResultPreview().getText();
        String expectedRslt="25";
        System.out.println("Actual result: "+Actualresult);
        Assert.assertEquals(expectedRslt,Actualresult);
        System.out.println("division performed");
    }


}
