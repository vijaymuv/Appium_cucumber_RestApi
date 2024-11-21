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


	public static WebDriver browserLaunch(String browser) {
		if (browser.equalsIgnoreCase(browser)) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);


		} else if (browser.equalsIgnoreCase(browser)) {
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

	public static String getTitle_Url() {
		String url_Tilte = driver.getTitle();
		return url_Tilte;
	}
	
	public static Properties readPropertiesFile(String locatoin) throws IOException {
	    
	      FileInputStream  fis = new FileInputStream(locatoin);
	      Properties properties = new Properties();
	      properties.load(fis);
	      
		return properties;
		}
	
	public static void wait_untill_element(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static String getPagSsourceElement(String url) {
		String pageSource = driver.getPageSource();
		return pageSource;
	}

	public static String CurrentUrlElement() {
		String current_url = driver.getCurrentUrl();
		return current_url;
	}

	public static void closePage() {
		driver.close();
	}

	public static void quitPage() {
		driver.quit();
	}

	public static void navigateTo(String url) {
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

	public static void maximize_Page() {
		driver.manage().window().maximize();
	}

	public static void full_Screen() {
		driver.manage().window().fullscreen();
	}

	public static void get_Size() {
		driver.manage().window().getSize();
	}

	public static void delete_All_Cookies() {
		driver.manage().deleteAllCookies();
	}

	public static void set_size(int width, int height) {
		Dimension dimension = new Dimension(width, height);
		driver.manage().window().setSize(dimension);
	}

	public static void clears(WebElement element) {
		element.clear();
	}

	public static void sendKeysElement(WebElement element,String value) {
		element.sendKeys(value);
	}

	public static void clickBtn(WebElement element) {
		element.click();
	}

	public static String get_Attribute(WebElement element,String value) {
		String attributeValue = element.getAttribute(value);
		return attributeValue;
	}

	public static String get_tagname(WebElement element) {
		String tagName = element.getTagName();
		return tagName;
	}

	public static Point get_location(WebElement element) {
		Point location = element.getLocation();
		return location;
	}

	public static String get_cssvalue(WebElement element, String value) {
		String tagName = element.getCssValue(value);
		return tagName;
	}

	public static Rectangle get_rectange(WebElement element) {
		Rectangle rectangle = element.getRect();
		return rectangle;
	}

	public static void selectVisibleText(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByVisibleText(value);
	}

	public static Select select_dropdown(WebElement element, String selectType, String value) {
		Select select = new Select(element);
		if (selectType.equalsIgnoreCase("visibletext")) {
			select.selectByVisibleText(value);
		} else if (selectType.equalsIgnoreCase("value")) {
			select.selectByValue(value);
		} else if (selectType.equalsIgnoreCase("index")) {
			int parse = Integer.parseInt(value);
			select.selectByIndex(parse);
		}
		return select;
	}

	public static Select deselect_dropdown(WebElement element, String selectType, String data) {
		Select select = new Select(element);
		if (selectType.equalsIgnoreCase("visibletext")) {
			select.deselectByVisibleText(data);
		} else if (selectType.equalsIgnoreCase("value")) {
			select.deselectByValue(data);
		} else if (selectType.equalsIgnoreCase("index")) {
			int parse = Integer.parseInt(data);
			select.deselectByIndex(parse);
		}
		return select;
	}

	public static void deselect_all(WebElement element) {
		Select select = new Select(element);
		select.deselectAll();

	}

	public static void get_all_options(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
		for (WebElement allSelected : allSelectedOptions) {
			System.out.println(allSelected.getText());
		}

	}

	public static void get_options(WebElement element) {
		Select select = new Select(element);
		List<WebElement> allOptions = select.getOptions();
		for (WebElement all : allOptions) {
			System.out.println(all.getText());
		}

	}

	public static void get_firstSelected_Options(WebElement element) {
		Select select = new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		System.out.println(firstSelectedOption.getText());
	}

	public static void moveToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static void frames(int  index) {
		driver.switchTo().frame(index);

	}

	public static void default_frames() {
		driver.switchTo().defaultContent();

	}

	public static  WebDriver Actions_class(WebElement element) {

		Actions action = new Actions(driver);
		action.contextClick(element).perform();
		return driver;
	}

	public static void right_click() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public static void takeScreenshotElement(String location) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(location);
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


