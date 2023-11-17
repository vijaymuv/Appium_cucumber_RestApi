package pagesOfItBusinessBook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUp {
public WebDriver driver;



    @FindBy(xpath = "//a[.='Sign up']")
    private WebElement signUpBtn;

    public WebElement getSignUpBtn() {
        return signUpBtn;
    }

    @FindBy(id = "firstname")
    private WebElement firstname;

    public SignUp(WebDriver driver2){
        this.driver=driver2;
        PageFactory.initElements(driver,this);
    }
    public WebElement getFirstname() {
        return firstname;
    }

    public WebElement getImnotRobot() {
        return imNotRobot;
    }

    public WebElement getLastname() {
        return lastname;
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPass() {
        return pass;
    }

    public WebElement getCheckBox() {
        return checkBox;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    @FindBy(xpath = "//div[@role='presentation']//parent::span")
    private WebElement imNotRobot;

    @FindBy(id = "lastname")
    private WebElement lastname;
    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement pass;

    @FindBy(id = "c2")
    private WebElement checkBox;

    @FindBy(id = "iregister")
    private WebElement registerBtn;
}
