package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgetPasswordPage {
	public WebDriver driver;
	public ForgetPasswordPage(WebDriver driver2) {
		this.driver=driver2;
	PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement forgetButton;

	public WebElement getForgetButton() {
		return forgetButton;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getResetButton() {
		return resetButton;
	}

	@FindBy(id="femail") 
	private WebElement email;
	
	@FindBy(id="rlogin") 
	private WebElement resetButton;
}
