package runnerClasses;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class demo_class {
    @Test
   public void test() throws IOException {

        //For Firefox
//        FirefoxOptions options = new FirefoxOptions();
//        options.addArguments("-private");
//        EdgeOptions	 options 	= new EdgeOptions();
//        options.addArguments("--inprivate");
//                //For Chrome
//        ChromeOptions options1 = new ChromeOptions();
//        options1.addArguments("--incognito");
//
//        WebDriver driver = new EdgeDriver(options);
//        driver.get("http://www.google.com");
//        //
//        TakesScreenshot ts = (TakesScreenshot) driver;
//        File f=ts.getScreenshotAs(OutputType.FILE);
//        File location = new File("C:\\Users\\Friday\\demo.png");
//        FileUtils.copyFile(f,location);
//
//        String s="you to have";
//        String[] s1 = s.split(" ");
//        String r=" ";
//        for (String word: s1) {
//            String rev="";
//            for (int i = word.length()-1; i >=0 ; i--) {
//                rev=rev+ word.charAt(i);
//            }
//            r=r+rev+" ";
//        }
//
//        System.out.println(r);


        int a=10;
        int b=20;
        int c;

//        c=a;
//        a=b;
//        b=c;
//        System.out.println(a + " "+b);

//        a=a+b; //30
//        b=a-b;   // 30-20 =10
//        a=a-b; //30+10
//        System.out.println(a+" "+b);
int d =3;
int val=d;
int rem;
int rev=0;
int count=0;
//while(val!=0){
//    rem=val%10;
//    rev= rem+rev;
//    val=val/10;
//    count++;
//}
          for(int i=1;i<=d;i++){
              if(val%i==0){
                  count++;
              }

          }
        if(count==2){
            System.out.println("is prime");
        }else{
            System.out.println("is not prime");
        }

        Random r =new Random();
        System.out.println( r.nextInt(20));
        System.out.println(RandomStringUtils.randomNumeric(20));
        System.out.println(RandomStringUtils.randomAlphabetic(20));
        String s="you to have oo ";
        char[] charArray = s.toCharArray();
int aa=0;
        for (int i = 0; i < charArray.length-1; i++) {
            if(charArray[i]=='o'){
                aa++;
            }
        }

        System.out.println(aa);

        }

    }

