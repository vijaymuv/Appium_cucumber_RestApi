package Appium;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class calcultorWebElementPage {
    public AppiumDriver dr;
    public calcultorWebElementPage(AppiumDriver dr2) {

        this.dr=dr2;
        PageFactory.initElements(dr,calcultorWebElementPage.this);
    }

    public WebElement getOne() {
        return one;
    }

    public WebElement getTwo() {
        return two;
    }

    public WebElement getThree() {
        return three;
    }

    public WebElement getFour() {
        return four;
    }

    public WebElement getFive() {
        return five;
    }

    public WebElement getSix() {
        return six;
    }

    public WebElement getPlus() {
        return plus;
    }
    public WebElement getEqual() {
        return equal;
    }

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_01")
    private WebElement one;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_02")
    private WebElement two;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_03")
    private WebElement three;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_04")
    private WebElement four;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_05")
    private WebElement five;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_06")
    private WebElement six;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_add")
    private WebElement plus;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_equal")
    private WebElement equal;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_07")
    private WebElement seven;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_08")
    private WebElement eight;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_09")
    private WebElement nine;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_00")
    private WebElement zero;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_dot")
    private WebElement dot;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_sub")
    private WebElement sub;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_mul")
    private WebElement multi;

    @FindBy(id= "com.sec.android.app.popupcalculator:id/calc_keypad_btn_div")
    private WebElement div;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_percentage")
    private WebElement percentage;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_parenthesis")
    private WebElement brackets;

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_clear")
    private WebElement clear;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_edt_formula")
    private WebElement resultPreview;

    public WebElement getResultPreview() {
        return resultPreview;
    }

    public WebElement getSeven() {
        return seven;
    }

    public WebElement getEight() {
        return eight;
    }

    public WebElement getNine() {
        return nine;
    }

    public WebElement getZero() {
        return zero;
    }

    public WebElement getDot() {
        return dot;
    }

    public WebElement getSub() {
        return sub;
    }

    public WebElement getMulti() {
        return multi;
    }

    public WebElement getDiv() {
        return div;
    }

    public WebElement getPercentage() {
        return percentage;
    }

    public WebElement getBrackets() {
        return brackets;
    }

    public WebElement getClear() {
        return clear;
    }

    public WebElement getPlusMin() {
        return plusMin;
    }

    public WebElement getScientificMode() {
        return scientificMode;
    }

    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_keypad_btn_plusminus")
    private WebElement plusMin;
    @FindBy(id="com.sec.android.app.popupcalculator:id/calc_handle_btn_rotation")
    private WebElement scientificMode;
}
