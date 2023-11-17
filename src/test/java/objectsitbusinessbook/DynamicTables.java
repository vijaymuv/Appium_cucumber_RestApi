package objectsitbusinessbook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;
import java.util.List;

public class DynamicTables {

public static WebDriver driver;
    @Test
    void webTables(){
        int team_rank=2;
        String cty="3";
        String points="9";
        String Matches="4";
        FirefoxOptions options1 = new FirefoxOptions();
        options1.addArguments("--incognito");
        WebDriver driver=new FirefoxDriver(options1);
        driver.get("https://www.cricbuzz.com/cricket-stats/points-table/test/icc-world-test-championship");
        List<WebElement> allCountry = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        System.out.println(allCountry.size());
        WebElement country =driver.findElement(By.xpath("//table/tbody/tr["+team_rank+"]/td["+cty+"]"));
        WebElement Points =driver.findElement(By.xpath("//table/tbody/tr["+team_rank+"]/td["+points+"]"));
        System.out.println(country.getText());
        System.out.println(Points.getText());
}
    @Test
    void webtbls() {
        String country = "West Indies";
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //  options.addArguments("--headless");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.cricbuzz.com/cricket-stats/points-table/test/icc-world-test-championship");
        List<WebElement> allCountry = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        System.out.println(allCountry.size());
        for (int i = 1; i <= allCountry.size() - 1; i++) {
            // System.out.println(allCountry.get(i).getText());
            if (allCountry.get(i).getText().equalsIgnoreCase(country)) {
                i++;
                WebElement Pct = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[10]"));
                System.out.println(country + " Pct: " + Pct.getText());
                i--;
            }
        }driver.close();
    }
}
