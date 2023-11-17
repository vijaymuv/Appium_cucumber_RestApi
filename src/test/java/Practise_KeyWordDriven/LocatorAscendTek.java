package Practise_KeyWordDriven;

import org.openqa.selenium.By;

public class LocatorAscendTek {

    public static By getId(String locatorValues){
       return By.id(locatorValues);
    }
    public static By getXpath(String locatorValues){
        return By.xpath(locatorValues);
    }
    public static By getName(String locatorValues){
        return By.name(locatorValues);
    }
    public static By getTagName(String locatorValues){
        return By.tagName(locatorValues);
    }
    public static By getClassName(String locatorValues){
        return By.className(locatorValues);
    }
    public static By getCssSelector(String locatorValues){
        return By.cssSelector(locatorValues);
    }
    public static By getPartialLinkText(String locatorValues){
        return By.partialLinkText(locatorValues);
    }
}
