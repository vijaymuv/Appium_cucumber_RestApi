package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	public WebElement getLogin() {
		return login;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getSignIn() {
		return signIn;
	}
	@FindBy(id = "lemail")
	private WebElement login;

	@FindBy(id = "lpassword")
	private WebElement password;

	@FindBy(xpath = "//button[@id='ilogin']")
	private WebElement signIn;
	@FindBy(xpath="//a[text()='Forgot Password?']")
	private WebElement forgetPasswordBtn;

	public WebElement getForgetPasswordBtn() {
		return forgetPasswordBtn;
	}
}
