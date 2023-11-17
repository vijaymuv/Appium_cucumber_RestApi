package objectsitbusinessbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.Set;

public class Amazon_wishlist {
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
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.in/?&ext_vrnc=hi&tag=googinhydr1-21&ref=pd_sl_4b3e4wrxds_b&adgrpid=60639568242&hvpone=&hvptwo=&hvadid=617721280315&hvpos=&hvnetw=g&hvrand=8630075487200603758&hvqmt=b&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1007809&hvtargid=kwd-311187680635&hydadcr=5841_2362028");
        driver.findElement(By.xpath("//div[@class='nav-line-1-container']")).click();
        driver.findElement(By.id("ap_email")).sendKeys("9943924671");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("vijayvjy");
        driver.findElement(By.id("signInSubmit")).click();
    }
    @Test
    void run() {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone 14");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
        //click product
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[1]/div/span[1]/div[1]/div[1]/div/div/div[1]/div[2]/div[1]/div/div[2]/a/span/span[2]")).click();
        //click wishlist
        driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-submit']")).click();

        //click view cart
        driver.findElement(By.xpath("//a[.='View Your List']")).click();

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("motorola edge 40");
        driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

        driver.findElement(By.xpath("//span[.='Motorola Edge+ (Thunder Grey, 256 GB) (12 GB RAM)']")).click();
        String currentPage = driver.getWindowHandle();
        Set<String> AllIds = driver.getWindowHandles();
        for (String ids:
                AllIds) {
            if ((ids.equals(currentPage))){

            }else {
                driver.switchTo().window(ids);
                driver.findElement(By.xpath("//input[@id='add-to-wishlist-button-submit']")).click();
                //click view cart
                driver.findElement(By.xpath("//a[.='View Your List']")).click();
                System.out.println("moto added to wishlist");
            }
        }
    }
    @AfterTest
    void closeBrowser(){
        driver.quit();
    }
}
