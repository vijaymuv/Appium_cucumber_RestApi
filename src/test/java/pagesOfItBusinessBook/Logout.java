package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {
    public WebDriver driver;

    public Logout(WebDriver driver2) {
        this.driver = driver2;
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[.='Logout']")
    private WebElement logout;

    public WebElement getLogout() {
        return logout;
    }

    public WebElement getOkButton() {
        return okButton;
    }

    @FindBy(xpath = "//button[.='OK']")
    private WebElement okButton;
}
