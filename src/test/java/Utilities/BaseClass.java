package Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseClass {
public WebDriver driver;
public static ThreadLocal<WebDriver> tdriver= new ThreadLocal<>();
    public AppiumDriver dr;
    public WebDriver brlaunch(String name) {
        if (name.equalsIgnoreCase("chrome")) {
            //System.setProperty("webdriver.chrome.driver", "C:\\A_files\\drivers\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver(options);
            tdriver.set(driver);
        }
         else if (name.equalsIgnoreCase("edge")) {
            //System.setProperty("webdriver.edge.driver","C:\\A_files\\drivers\\msedgedriver.exe");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            tdriver.set(driver);

        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        return getDriver();
    }

    public static synchronized  WebDriver getDriver(){
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

    }
