package Appium;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class DialNumber {
    static AppiumDriver dr;
    @Test
    public void loginInsta() throws InterruptedException, MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","13");
        capabilities.setCapability("udid","RZ8R90WDAFF");
        capabilities.setCapability("deviceName","Galaxy F62");
        capabilities.setCapability("appPackage","com.samsung.android.dialer");
        capabilities.setCapability("appActivity","com.samsung.android.dialer.DialtactsActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        dr= new AppiumDriver(url,capabilities);

        Thread.sleep(3000);

        WebElement one = dr.findElement(By.id("com.samsung.android.dialer:id/one"));
        WebElement two = dr.findElement(By.id("com.samsung.android.dialer:id/two"));
        WebElement three = dr.findElement(By.id("com.samsung.android.dialer:id/three"));
        WebElement four = dr.findElement(By.id("com.samsung.android.dialer:id/four"));

        WebElement five = dr.findElement(By.id("com.samsung.android.dialer:id/five"));
        WebElement six = dr.findElement(By.id("com.samsung.android.dialer:id/six"));
        WebElement seven = dr.findElement(By.id("com.samsung.android.dialer:id/seven"));
        WebElement eight = dr.findElement(By.id("com.samsung.android.dialer:id/eight"));
        WebElement nine = dr.findElement(By.id("com.samsung.android.dialer:id/nine"));
        WebElement zero = dr.findElement(By.id("com.samsung.android.dialer:id/zero"));
        WebElement callbutton = dr.findElement(By.id("com.samsung.android.dialer:id/callButtonContainer"));
        nine.click();
        nine.click();
        four.click();
        three.click();
        nine.click();
        two.click();
        four.click();
        six.click();
        seven.click();
        one.click();
        callbutton.click();
        dr.close();

    }
}
