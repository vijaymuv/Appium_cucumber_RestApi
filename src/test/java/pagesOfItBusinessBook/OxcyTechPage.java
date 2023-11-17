package pagesOfItBusinessBook;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OxcyTechPage {
	public WebDriver driver;
	
	public OxcyTechPage(WebDriver driver2) {
		this.driver=driver2;
		PageFactory.initElements(driver,this);
	}
	public WebElement getJobs() {
		return jobs;
	}

	public WebElement getFindJobs() {
		return findJobs;
	}

	public WebElement getOxcyTech() {
		return OxcyTech;
	}


	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[2]/a") 
	private WebElement jobs;

	@FindBy(xpath="/html/body/div[2]/header/div/div/nav/ul/li[2]/ul/li[1]/a") 
	private WebElement findJobs;
	
	@FindBy(xpath="//a[text()='Oxcytech System']") 
	private WebElement OxcyTech;

}
