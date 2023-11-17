package RestAssured;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Colletions_class {
    public static void main(String[] args) throws IOException, InterruptedException {
        List<Integer> list = new ArrayList<Integer>();
        list.add(46);
        list.add(67);

        list.add(24);
        list.add(16);
        list.add(8);
        list.add(12);
        Integer max = Collections.max(list);
        System.out.println(max);
        Collections.sort(list, Collections.reverseOrder());

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        String command = "(al)G(al)()()G";
        for(int i=0;i<=command.length()-1;i++){
            if(command.charAt(i) == '(' && command.charAt(i+1) == ')'){
                command= command.replace("()","o");
                System.out.println(command);
            }
        }
        String word1="abc";
        String word2="def";
        String value="";
        char c='a';
        for(c='a';c<='z';c++){
            System.out.println(c);
        }

        WebDriverManager.chromedriver().setup();
        Thread.sleep(3000);
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.itbusinessbook.com/");
        //Collects the webelement
        WebElement ele = driver.findElement(By.xpath("//*[@id='lemail']"));
        //Create object of a JavascriptExecutor interface
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //use executeScript() method and pass the arguments
        //Here i pass values based on css style. Yellow background color with solid red color border.
        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", ele);
        driver.findElement(By.id("lemail")).sendKeys("demo@gmail.com");
        String text = driver.findElement(By.id("lemail")).getAttribute("value");
        String text1= driver.findElement(By.id("lemail")).getText();
        System.out.println(text);
        js.executeScript("arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');",
                driver.findElement(By.cssSelector(".container ul li:nth-child(3)")));
        js.executeScript("arguments[0].scrollIntoView()", driver.findElement(By.cssSelector(".container ul li:nth-child(3)")));
        Thread.sleep(3000);
        String str = driver.findElement(By.xpath("//a[.='Sign up']")).getAttribute("href");
        System.out.println(str);


      driver.close();
    }
}


