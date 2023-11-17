package Practise_KeyWordDriven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Actions_keyword {
    public static WebDriver driver;
   public static  void  openBrowser(){
        ChromeOptions options = new ChromeOptions();
      // options.addArguments("--incognito");
    //options.addArguments("--headless");
      // options.addArguments("start-maximized");
        options.addArguments("--remote-allow-origins=*");
       // options.addArguments("--disable-notifications");


        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
    }
    public static void getUrls(){

       driver.get("https://www.ascendtek.com/");
    }
    public static  void clickContactUs(){
driver.findElement(By.xpath("//ul[@id='menu-main']//descendant::a[.='Contact Us']")).click();

    }

    public static  void enterFirstName(){
        driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("vijay");
    }

    public static  void enterLastName(){
        driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("m");

    }

public static  void enterEmail(){driver.findElement(By.xpath("//input[@placeholder='Email Address']")).sendKeys("vijay@gmail.com    ");

    }
    public static  void enterPhoneNo(){
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("9943926578");
    }

    public static  void enterMessage(){
        driver.findElement(By.xpath("//textarea[@placeholder='Message']")).sendKeys("some message");
    }

    public static  void clickSendMessage(){
        driver.findElement(By.xpath("//button[@name='et_builder_submit_button']")).click();
    }
}
