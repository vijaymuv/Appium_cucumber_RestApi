package runnerClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Webtables {
    public WebDriver driver;
    int total ;

    @BeforeClass
       public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.get("https://letcode.in/table");
    }
 @Test(priority = 1)
   public void shoppingList(){

      List<WebElement> body = driver.findElements(By.xpath("//table[@id=\"shopping\"]/thead/tr/th"));
      List<WebElement> datas = driver.findElements(By.xpath("//table[@id=\"shopping\"]/tbody/tr/td[2]"));
      int size = body.size();
      System.out.println("body size"+size);

          for (WebElement price:datas) {
              String sumAll = price.getText();
              int sum = Integer.parseInt(sumAll);
              total =total+sum;

          }
      System.out.println("total "+total);
      }

//@Test(priority = 2)
public void attendance(){

    List<WebElement> allDatas = driver.findElements(By.xpath("//*[@id=\"simpletable\"]/tbody/tr/td"));
    for (WebElement allData: allDatas) {
        String data = allData.getText();
        if (data.equalsIgnoreCase("Raj")){
            WebElement rajpresent = driver.findElement(By.xpath("//td[normalize-space()='Raj']//following::td[2]//input"));
            rajpresent.click();
            System.out.println("Raj present");
        }
    }
}
@Test(priority =1)
void sortingTables() throws InterruptedException {
    driver.findElement(By.xpath("//div[.='Fat (g)']//parent::div[@role='button']")).click();
    List<WebElement> Calories = driver.findElements(By.xpath("//table[@class='mat-sort table is-bordered is-striped is-narrow is-hoverable is-fullwidth']/tr/td[2]"));

    List<Integer> values=new ArrayList<Integer>();
    List<Integer> original=new ArrayList<Integer>();
    for ( WebElement calorie :Calories) {
        String calorieTt = calorie.getText();
        int calValues = Integer.parseInt(calorieTt);
        values.add(calValues);
        original.add(calValues);
    }
        Collections.sort(values);
    if (values.equals(original)){
        System.out.println("sorted"+values);
        System.out.println("org"+original);
        System.out.println("values are equal");
    }else {
        System.out.println("values are not equal");
    }


}


}
