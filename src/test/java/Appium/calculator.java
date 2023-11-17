package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class calculator {
    static AppiumDriver dr;
    @Test
    public static void  ho() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"13.0");
        capabilities.setCapability(MobileCapabilityType.UDID,"RZ8R90WDAFF");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"F62");
        capabilities.setCapability("appPackage","com.sec.android.app.popupcalculator");
        capabilities.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        dr= new AppiumDriver(url,capabilities);

        Thread.sleep(4000);

        WebElement one = dr.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_01"));
        WebElement three = dr.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_03"));
        WebElement plus = dr.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_add"));
        WebElement eql = dr.findElement(By.id("com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal"));
        one.click();
        plus.click();
        three.click();
        eql.click();
    }
}
