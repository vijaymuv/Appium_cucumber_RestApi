package objectsitbusinessbook;

import Utilities.UtilityFiles;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import java.time.Duration;


public class AmZon extends UtilityFiles {
    public static ChromeOptions options;
    public static WebDriver driver;
    @Test
    void run() throws InterruptedException {
    options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydr1-21&ref=pd_sl_4b3e4wrxds_b&adgrpid=60639568242&hvpone=&hvptwo=&hvadid=617721280315&hvpos=&hvnetw=g&hvrand=8630075487200603758&hvqmt=b&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007809&hvtargid=kwd-311187680635&hydadcr=5841_2362028");
        driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
        driver.findElement(By.id("ap_email")).sendKeys("9943924671");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("vijayvjy");
        driver.findElement(By.id("signInSubmit")).click();
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("almonds 500gm");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@class='a-truncate-cut'][.='Tong Garden Imported - Salted Cocktail Nuts, 400 Gm']")).click();
                driver.findElement(By.xpath("//input[@id='buy-now-button']")).click();
           //driver.findElement(By.xpath("//span[.='Other UPI Apps']")).click();
               // driver.findElement(By.xpath("//*[@id=\"pp-1vmYy4-129\"]/div/div/div/div/div[2]/div[1]/div/span[1]")).click();
                driver.findElement(By.xpath("//*[@id=\"orderSummaryPrimaryActionBtn\"]/span/input")).click();
                Thread.sleep(8000);
                driver.findElement(By.xpath("//input[@name='placeYourOrder1']//ancestor::span[@id='bottomSubmitOrderButtonId']")).click();
Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='placeYourOrder1']//ancestor::span[@id='bottomSubmitOrderButtonId']")).click();
                driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();

    }
@Test(priority = 2)
   void cancelOrder(){
    driver.findElement(By.xpath("//span[.='Go to your orders']")).click();
    driver.findElement(By.xpath("//*[@id=\"View-or-edit-order_2\"]")).click();
    driver.findElement(By.xpath("//a[normalize-space()='Cancel items']")).click();

    Select s= new Select(driver.findElement(By.xpath("//select[@name='cancel.reason']")));
    s.selectByVisibleText("Order Created by Mistake");
    driver.findElement(By.xpath("//input[@name='cq.submit']")).click();
    System.out.println(driver.findElement(By.xpath("//h4[.='This order has been cancelled.']")).getText());

}

    }