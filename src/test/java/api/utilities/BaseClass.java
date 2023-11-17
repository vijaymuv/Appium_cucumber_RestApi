package api.utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
public class BaseClass {
    public WebDriver drs;

    public static ThreadLocal<WebDriver> tdriver = new ThreadLocal<WebDriver>();
    public AppiumDriver dr;
    public WebDriver brlaunch() {

            //System.setProperty("webdriver.edge.driver","C:\\A_files\\drivers\\msedgedriver.exe");
        WebDriverManager.edgedriver().setup();
        drs = new EdgeDriver();
        drs.manage().deleteAllCookies();
        drs.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        drs.manage().window().maximize();
            tdriver.set(drs);
           return getDriver1();
    }
    public static synchronized  WebDriver getDriver1(){
        return tdriver.get();
    }
    public URL setUpProperties(String platformName, double version, String udid, String devicename, String Apppackage, String appactivity, String url ) throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,platformName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,version);
        capabilities.setCapability(MobileCapabilityType.UDID,udid);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,devicename);
        capabilities.setCapability("appPackage",Apppackage);
        capabilities.setCapability("appActivity",appactivity);

        URL url1 = new URL(url);
        dr= new AppiumDriver(url1,capabilities);
       return url1;
}
    public String getScreenshot() {
        File src = ((TakesScreenshot) getDriver1()).getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
        File destination = new File(path);
        try {
            FileUtils.copyFile(src, destination);
        } catch (IOException e) {
            System.out.println("Capture Failed " + e.getMessage());
        }
        return path;
    }

    }
