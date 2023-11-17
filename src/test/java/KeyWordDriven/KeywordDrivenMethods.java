package KeyWordDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class KeywordDrivenMethods {
   public static WebDriver driver;
    public static void openBrowser(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
   public static void getUrl(){
       driver.get(ExcelUtility.testDataValues);
    }
    public static void enterEmail(){
        driver.findElement(EngineExcecution.locatorElement).sendKeys(ExcelUtility.testDataValues);
    }
    public static void enterPassword(){
            driver.findElement(EngineExcecution.locatorElement).sendKeys(ExcelUtility.testDataValues);
    }
    public static void clickLogin(){
        driver.findElement(EngineExcecution.locatorElement).click();
    }
    public static void clickSignUp(){
        driver.findElement(EngineExcecution.locatorElement).click();
    }
    public static void enterFirstname(){
        driver.findElement(EngineExcecution.locatorElement).sendKeys(ExcelUtility.testDataValues);
    }
    public static void enterLastname(){
        driver.findElement(EngineExcecution.locatorElement).sendKeys(ExcelUtility.testDataValues);
    }
}
