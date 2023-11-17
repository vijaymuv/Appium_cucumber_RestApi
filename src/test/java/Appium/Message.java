package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Message {
    static AndroidDriver dr;
    @Test
  public void  message() throws MalformedURLException, InterruptedException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13");
        capabilities.setCapability(MobileCapabilityType.UDID,"RZ8R90WDAFF");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"F62");
        capabilities.setCapability("appPackage","com.sec.android.app.camera");
        capabilities.setCapability("appActivity","com.sec.android.app.camera.Camera");
        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        dr= new AndroidDriver(url,capabilities);
             //dr.findElement(By.id("com.google.android.apps.messaging:id/conversation_list_spam_popup_positive_button")).sendKeys();

    }
}
