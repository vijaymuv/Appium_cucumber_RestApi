package KeyWordDriven;

import org.openqa.selenium.By;

public class Locators {

    public static By getId(String locatorValue){
       return By.id(locatorValue);
    }
    public static By getXpath(String locatorValue){
        return By.xpath(locatorValue);
    }
    public static By getTagName(String locatorValue){
        return By.tagName(locatorValue);
    }
    public static By getCssSelectors(String locatorValue){
        return By.cssSelector(locatorValue);
    }
}
