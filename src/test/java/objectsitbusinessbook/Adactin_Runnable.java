package objectsitbusinessbook;

import java.time.Duration;

import Utilities.Allure_report;
import Utilities.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({Allure_report.class})
public class Adactin_Runnable {
WebDriver driver;
        @Test
		void runAdactin(){
		BaseClass bs = new BaseClass();
		   bs.brlaunch("edge");
			bs.driver.get("https://adactinhotelapp.com/");
           bs.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
           bs. driver.manage().window().maximize();
			WebElement user_name = bs.driver.findElement(By.xpath("//input[@id='username']"));
			user_name.sendKeys("Vijay0326");
			WebElement pass = bs.driver.findElement(By.xpath("//input[@id='password']"));
//			pass.sendKeys("31H2FU");
			pass.sendKeys("QJO843");
			WebElement login = bs.driver.findElement(By.xpath("//input[@class='login_button']"));
			login.click();
			WebElement location = bs.driver.findElement(By.xpath("//select[@name='location']"));
			Select s  = new Select(location);
            s.selectByVisibleText("Brisbane");
			WebElement hotels = bs.driver.findElement(By.xpath("//select[@name='hotels']"));
			Select s1 = new Select(hotels);
			s1.selectByVisibleText("Hotel Hervey");
			WebElement room_type = bs.driver.findElement(By.xpath("//select[@name='room_type']"));
			Select s3 = new Select(room_type);
			s3.selectByVisibleText("Super Deluxe");
//			WebElement room_no = driver.findElement(By.xpath("//select[@name='room_nos']"));
//			Select s4 = new Select(room_no);
//			s4.selectByVisibleText("3 - Three");
//			WebElement check_in = driver.findElement(By.xpath("//input[@name='datepick_in']"));
//			check_in.sendKeys("07/07/2022");
//			WebElement check_out = driver.findElement(By.xpath("//input[@name='datepick_out']"));
//			check_out.sendKeys("08/07/2022");
//		WebElement adult_per_room = driver.findElement(By.xpath("//select[@name='adult_room']"));
//		Select s5 = new Select(adult_per_room);
//		s5.selectByVisibleText("3 - Three");
//		WebElement children_pr = driver.findElement(By.xpath("//select[@name='child_room']"));
//		Select a = new Select(children_pr);
//		a.selectByVisibleText("1 - One");
//
//		WebElement search_btn = driver.findElement(By.xpath("//input[@id='Submit']"));
//		search_btn.click();
//		WebElement search_hotel = driver.findElement(By.xpath("//input[@name='radiobutton_0']"));
//		search_hotel.click();
//		WebElement continue_btn = driver.findElement(By.xpath("//input[@id='continue']"));
//		continue_btn.click();
//		WebElement First_name = driver.findElement(By.xpath("//input[@id='first_name']"));
//		First_name.sendKeys("Javajava");
//		WebElement last_name = driver.findElement(By.xpath("//input[@id='last_name']"));
//		last_name.sendKeys("python");
//		WebElement text_area = driver.findElement(By.xpath("//textarea[@name='address']"));
//		text_area.sendKeys("info java technilogies, adayar , chennai");
//		WebElement creditcard_no = driver.findElement(By.xpath("//input[@id='cc_num']"));
//		creditcard_no.sendKeys("1234567812345678");
//		WebElement card_type = driver.findElement(By.xpath("//select[@id='cc_type']"));
//		Select  b = new Select(card_type);
//		b.selectByVisibleText("American Express");
//		WebElement expired_mon = driver.findElement(By.xpath("//select[@id='cc_exp_month']"));
//         Select c = new Select(expired_mon);
//		c.selectByVisibleText("November");
//		WebElement expired_year = driver.findElement(By.xpath("//select[@id='cc_exp_year']"));
//		Select d = new Select(expired_year);
//				d.selectByVisibleText("2017");
//				WebElement cvv_no = driver.findElement(By.xpath("//input[@id='cc_cvv']"));
//				cvv_no	.sendKeys("326");
//
//				WebElement book_now_btn= driver.findElement(By.xpath("//input[@id='book_now']"));
//				book_now_btn.click();
//				WebElement logout_btn = driver.findElement(By.xpath("//a[.='Logout']"));
//					//logout_btn.click();
//					driver.close();
		
	}

}
