package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.time.Duration;
import java.util.List;

public class UtilityFiles {

	public static WebDriver driver;
	public static WebElement WebElement;
	public static String value;


	public static void calendarPicker(String year, String month, String day) {


		if(Integer.parseInt(day)>32) {
			System.out.println("inalid day format: "+day +" "+month +" "+year);
			return;
		}
		if (month.equals("Feburuary") && Integer.parseInt(day)>29) {
			System.out.println(" feburuary date must not greater than 29"+day +" "+month +" "+year);
		}
		String myear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		System.out.println(myear);
		String month1 = myear.split(" ")[0];
		String year1 = myear.split(" ")[1];
		String day1 = "26";

		while (!(month1.equals(month) && (year1.equals(year)))) {

			driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
			myear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
			month1 = myear.split(" ")[0];
			year1 = myear.split(" ")[1];

		}
		driver.findElement(By.xpath("/html/body/div[4]/table/tbody/tr/td/a[text()="+day1+"]")).click();


	}

	public static WebDriver browserLaunch(String name) {
		if (name.equalsIgnoreCase("chrome")) {
			//System.setProperty("webdriver.chrome.driver", "C:\\A_files\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);


		} else if (name.equalsIgnoreCase("edge")) {
			//System.setProperty("webdriver.edge.driver","C:\\A_files\\drivers\\msedgedriver.exe");
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String url) {

		driver.get(url);
	}

	public static String getTitleElement() {
		String title = driver.getTitle();
		return title;
	}

	public static String getPagSsourceElement(String url) {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	public static String CurrentUrlElement(String url) {
		String url1 = driver.getCurrentUrl();
		return url1;
	}

	public static void closePage() {
		driver.close();
	}

	public static void quitPage() {
		driver.quit();
	}

	public static void navigateto(String url) {
		driver.navigate().to(url);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void navigateForward() {
		driver.navigate().forward();
	}

	public static void navigateRefresh() {
		driver.navigate().refresh();
	}

	public static void maximize_page() {
		driver.manage().window().maximize();
	}

	public static void full_screen() {
		driver.manage().window().fullscreen();
	}

	public static void get_size() {
		driver.manage().window().getSize();
	}

	public static void delete_all_cookies() {
		driver.manage().deleteAllCookies();
	}

	public static void set_size(int width, int height) {
		Dimension d = new Dimension(width, height);
		driver.manage().window().setSize(d);
	}

	public static void clears(WebElement element) {
		element.clear();
	}

	public static void sendKeysElement(WebElement a,String b) {
		a.sendKeys(b);
	}

	public static void clickBtn(WebElement ele) {
		ele.click();
	}

	public static String get_Attribute(WebElement e) {
		String attribute = e.getAttribute("value");
		return attribute;
	}

	public static String get_tagname(WebElement e) {
		String tagName = e.getTagName();
		return tagName;
	}

	public static Point get_location(WebElement e) {
		Point location = e.getLocation();
		return location;
	}

	public static String get_cssvalue(WebElement e, String a) {
		String tagName = e.getCssValue(a);
		return tagName;
	}

	public static Rectangle get_rectange(WebElement e) {
		Rectangle rect = e.getRect();
		return rect;
	}

	public static void selectVisibleText(WebElement a, String A) {
		Select s = new Select(a);
		s.selectByVisibleText(A);
	}

	public static void select_dropdown(WebElement a, String b, String data) {
		Select s = new Select(a);
		if (b.equalsIgnoreCase("text")) {
			s.selectByVisibleText(data);
		} else if (b.equalsIgnoreCase("value")) {
			s.selectByValue(data);
		} else if (b.equalsIgnoreCase("index")) {
			int parse = Integer.parseInt(data);
			s.selectByIndex(parse);
		}
	}

	public static void deselect_dropdown(WebElement a, String b, String data) {
		Select s = new Select(a);
		if (b.equalsIgnoreCase("text")) {
			s.deselectByVisibleText(data);
		} else if (b.equalsIgnoreCase("value")) {
			s.deselectByValue(data);
		} else if (b.equalsIgnoreCase("index")) {
			int parse = Integer.parseInt(data);
			s.deselectByIndex(parse);
		}
	}

	public static void deselect_all(WebElement a) {
		Select s = new Select(a);
		s.deselectAll();

	}

	public static void get_all_options(WebElement a) {
		Select s = new Select(a);
		List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement allSelected : allSelectedOptions) {
			System.out.println(allSelected.getText());
		}

	}

	public static void get_options(WebElement a) {
		Select s = new Select(a);
		List<WebElement> allOptions = s.getOptions();
		for (WebElement all : allOptions) {
			System.out.println(all.getText());
		}

	}

	public static void get_firstSelected_Options(WebElement a) {
		Select s = new Select(a);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

	public static void moveToElement(WebElement e) {
		Actions a = new Actions(driver);
		a.moveToElement(e).build().perform();
	}

	public static void frames(String text, int  a) {
		driver.switchTo().frame(a);

	}

	public static void default_frames() {
		driver.switchTo().defaultContent();

	}

	public static  WebDriver Actions_class(WebElement e) {

		Actions a = new Actions(driver);
		a.contextClick(e).perform();
		return driver;
	}

	public static void right_click() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void takeScreenshotElement() throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\Friday\\IdeaProjects\\ProjectsPractise\\FailedTestCasesImg\\images.png");
		FileUtils.copyFile(source,dest);
	}

	public static String particularCell(String sheet, int row, int cell) throws IOException {

		File file = new File("C:\\Users\\Friday\\Downloads\\datasapi.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(fis);
		Sheet s = work.getSheet(sheet);
		Row r = s.getRow(row);
		Cell c = r.getCell(cell);
		CellType cellType = c.getCellType();
		if (cellType.equals(CellType.STRING)) {
			value = c.getStringCellValue();
			System.out.println(value);
		} else if (cellType.equals(CellType.NUMERIC)) {
			double numericCellValue = c.getNumericCellValue();
			value = String.valueOf(numericCellValue);

			System.out.println(value);

		}
		work.close();
		return value;
	}

	public void allDatas(String sheet) throws IOException {

		File file = new File("C:\\Users\\Friday\\Downloads\\datasapi.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook work = new XSSFWorkbook(fis);
		Sheet s = work.getSheet(sheet);

		int physicalNumberOfRows = s.getPhysicalNumberOfRows();
		for (int i = 0; i <=physicalNumberOfRows; i++) {
			Row row = s.getRow(i);
			int physicalNumberOfCells = row.getPhysicalNumberOfCells();
			for (int j = 0; j <=physicalNumberOfCells ; j++) {
				Cell cell = row.getCell(j);
				CellType cellType = cell.getCellType();
				if (cellType.equals(CellType.STRING)) {
					value = cell.getStringCellValue();
					System.out.println(value);
				} else if (cellType.equals(CellType.NUMERIC)) {
					double numericCellValue = cell.getNumericCellValue();
					value = String.valueOf(numericCellValue);

					System.out.println(value);

				}

			}
		}


	}


}


