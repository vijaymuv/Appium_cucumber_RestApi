package Appium;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;

public class VirtualDeviceGoogle {
    static AppiumDriver dr;
    @Test
    public static void pixcelDailer() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.0");
        capabilities.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Google pixcel ");
        capabilities.setCapability("appPackage", "com.google.android.dialer");
        capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        dr = new AppiumDriver(url, capabilities);
        Thread.sleep(5000);

        WebElement dot = dr.findElement(By.id("com.google.android.dialer:id/dialpad_fab"));
        dot.click();
        Thread.sleep(5000);
        WebElement one = dr.findElement(By.id("com.google.android.dialer:id/one"));
        WebElement two = dr.findElement(By.id(
                "com.google.android.dialer:id/two"));
        WebElement three = dr.findElement(By.id("com.google.android.dialer:id/three"));
        WebElement four = dr.findElement(By.id(
                "com.google.android.dialer:id/four"));
        WebElement five = dr.findElement(By.id(
                "com.google.android.dialer:id/five"));
        WebElement six = dr.findElement(By.id(
                "com.google.android.dialer:id/six"));
        WebElement seven = dr.findElement(By.id(
                "com.google.android.dialer:id/seven"));
        WebElement nine = dr.findElement(By.id(
                "com.google.android.dialer:id/nine"));
        WebElement eight = dr.findElement(By.id(
                "com.google.android.dialer:id/eight"));
        WebElement zero = dr.findElement(By.id("com.google.android.dialer:id/zero"));
        WebElement call = dr.findElement(By.id(
                "com.google.android.dialer:id/dialpad_voice_call_button"));

        Thread.sleep(3000);
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
        call.click();

    }
}