package objectsitbusinessbook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jsoup.select.Elements;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class emailOtp {
    public static ChromeOptions options;
    public static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {

        String css = "span[style='background: #c4c2c2;']";                  //Link of that Button
        String actualOtp = getEmailData("yajiv@1secmail.com", css, 2);
        System.out.println("Actual : " + actualOtp);
        String message = "We received a request to change your password\n" +
                "  Hi,\n" +
                "  Your New Password for Signing Up with ItBusinessBook is:"+actualOtp+
                "\n" +
                " Thanks for your time,\n" +
                " The ItBusinessBook Team";

        System.out.println(message);
        options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--disable-notifications");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://www.itbusinessbook.com/");

        driver.findElement(By.xpath("//*[@id=\"lemail\"]")).sendKeys("yajiv@1secmail.com");
        driver.findElement(By.xpath("//*[@id=\"lpassword\"]")).sendKeys(actualOtp);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"ilogin\"]")).click();


    }

    /**
     * Method to get either the verification URL or the text from the email body.
     *
     * @param email       - String type parameter. The email.
     * @param cssSelector - String type parameter. The CSS selector to select the
     *                    element on the mail body page.
     * @param data        - Integer type parameter. 1 = verification link, 2 = Text
     *                    data
     * @return - String type return value with either URL or the text data. Blank
     *         string if no data found or any exception occurs.
     */
    public static String getEmailData(String email, String cssSelector, int data) {
        try {
            String breakEmail[] = email.split("@");
            URL url = new URL("https://www.1secmail.com/api/v1/?action=getMessages&login=" + breakEmail[0] + "&domain="
                    + breakEmail[1]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
            }
            InputStreamReader content = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(content);
            String output;
            String finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            JSONTokener tokener = new JSONTokener(finalOutput.substring(1, finalOutput.length() - 1));
            JSONObject json = new JSONObject(tokener);
            url = new URL("https://www.1secmail.com/api/v1/?action=readMessage&login=" + breakEmail[0] + "&domain="
                    + breakEmail[1] + "&id=" + json.get("id"));
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP Error code after id retrieval: " + conn.getResponseCode());
            }
            content = new InputStreamReader(conn.getInputStream());
            br = new BufferedReader(content);
            finalOutput = "";
            while ((output = br.readLine()) != null) {
                finalOutput = output;
            }
            conn.disconnect();
            tokener = new JSONTokener(finalOutput);
            json = new JSONObject(tokener);
            Document doc = Jsoup.parse((String) json.get("htmlBody"));
            // body h2 span
            Elements element = doc.select(cssSelector);
            if (data == 1) {
                return element.attr("href");
            } else {
                return element.text();
            }
        } catch (Exception e) {
            return "";
        }

    }


}

