package objectsitbusinessbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;
public class Amazon_EndToEnd_Testing {
    public static ChromeOptions options;
    public static WebDriver driver;
    @BeforeTest
    void browserOpen(){
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.in/ap/signin?openid.pape.max_auth_age=900&openid.return_to=https%3A%2F%2Fwww.amazon.in%2Fgp%2Fyourstore%2Fhome%3Fpath%3D%252Fgp%252Fyourstore%252Fhome%26useRedirectOnSuccess%3D1%26signIn%3D1%26action%3Dsign-out%26ref_%3Dnav_AccountFlyout_signout&openid.assoc_handle=inflex&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0");
//        driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
        driver.findElement(By.id("ap_email")).sendKeys("9943924671");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("vijayvjy");
        driver.findElement(By.id("signInSubmit")).click();
    }
    @Test(enabled = false)
    void endToEndTesting() throws InterruptedException {
        //enter product
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("pendrive 128gb");
        // click search btn
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//child::span[.='Amazon Basics 128GB Ultra Fast USB 3.1 Flash Drive 1 Pack']")).click();
        String currentPage = driver.getWindowHandle();
        Set<String> AllIds = driver.getWindowHandles();
        for (String ids:
                AllIds) {
            if ((ids.equals(currentPage))){

            }else {
                driver.switchTo().window(ids);
                // user adds quantity 2
                Select a = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
                a.selectByValue("2");
                // user clicks on buynow
                driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
                // user selects payment method as cod
                driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")).click();
                Thread.sleep(10000);
                //user clicks on plase order button
                driver.findElement(By.xpath("//input[@name='placeYourOrder1']//ancestor::span[@id='bottomSubmitOrderButtonId']")).click();
                Thread.sleep(2000);
                //driver.findElement(By.xpath("//input[@name='placeYourOrder1']//ancestor::span[@id='bottomSubmitOrderButtonId']")).click();
            }
        }

    }
    @Test(priority = 1)
    void endToEndTesting1() throws InterruptedException {
        //enter product
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("jbl endurance runbt");
        // click search btn
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']//child::span[.='JBL Endurance RunBT, Sports in Ear Wireless Bluetooth Earphones with Mic, Sweatproof, Flexsoft eartips, Magnetic Earbuds, Fliphook & TwistLock Technology, Voice Assistant Support (Black)']")).click();
        String currentPage = driver.getWindowHandle();
        Set<String> AllIds = driver.getWindowHandles();
        for (String ids:
                AllIds) {
            if ((ids.equals(currentPage))){

            }else {
                driver.switchTo().window(ids);
                // user adds quantity 2
                Select a = new Select(driver.findElement(By.xpath("//select[@id='quantity']")));
                a.selectByValue("2");
                // user clicks on buynow
                driver.findElement(By.xpath("//input[@ id='buy-now-button']")).click();
                // user selects payment method as cod
                driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")).click();
                Thread.sleep(10000);
                //user clicks on plase order button
               // driver.findElement(By.xpath("//input[@name='placeYourOrder1']//ancestor::span[@id='bottomSubmitOrderButtonId']")).click();
                Thread.sleep(2000);
                //driver.findElement(By.xpath("//input[@name='placeYourOrder1']//ancestor::span[@id='bottomSubmitOrderButtonId']")).click();
            }
        }
    }
    @Test(enabled = false)
    void cancelOrder(){
        //user clicks on Go to your orders
        driver.findElement(By.xpath("//span[.='Go to your orders']")).click();
        //user clicks on View-or-edit-order
        driver.findElement(By.xpath("//*[@id=\"View-or-edit-order_2\"]")).click();
        // user Cancels the item
        driver.findElement(By.xpath("//a[normalize-space()='Cancel items']")).click();
         //user select the reason for cancellation of item
        Select s= new Select(driver.findElement(By.xpath("//select[@name='cancel.reason']")));
        s.selectByVisibleText("Order Created by Mistake");
        driver.findElement(By.xpath("//input[@name='cq.submit']")).click();
        System.out.println(driver.findElement(By.xpath("//h4[.='This order has been cancelled.']")).getText());
    }
    @AfterTest
    void closeBrowser(){
        driver.close();
    }
}
