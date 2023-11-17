package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SettingsPage {
	public WebDriver driver;
	public SettingsPage(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(xpath="//a[.='Settings']")
private WebElement setting;
@FindBy(id="oldpassword")
private WebElement oldPassword;

@FindBy(id="newpassword")
private WebElement newPassword;

public WebDriver getDriver() {
	return driver;
}

public WebElement getSetting() {
	return setting;
}

public WebElement getOldPassword() {
	return oldPassword;
}

public WebElement getNewPassword() {
	return newPassword;
}

public WebElement getConfPassword() {
	return confPassword;
}

public WebElement getSavePassword() {
	return savePassword;
}

@FindBy(id="confpassword")
private WebElement confPassword;

@FindBy(id="cpsubmit")
private WebElement savePassword;


}
