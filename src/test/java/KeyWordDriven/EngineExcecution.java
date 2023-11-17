package KeyWordDriven;

import org.openqa.selenium.By;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class EngineExcecution {
    Method[] methods;
    KeywordDrivenMethods keywords;
    public static By locatorElement;
    public void getMethodsFromKeyWordClass(){
         keywords = new KeywordDrivenMethods();
        methods = keywords.getClass().getMethods();
    }
    public void execteMethods() throws InvocationTargetException, IllegalAccessException {
        for (int i = 0; i <methods.length ; i++) {
            if (methods[i].getName().equalsIgnoreCase(ExcelUtility.keywordValues)){
                methods[i].invoke(keywords);
            }
        }
    }
    public void findwebElements(){
        switch (ExcelUtility.locatorName)
        {
            case "id":
                locatorElement  = Locators.getId(ExcelUtility.locatorvalue);
                break;
            case "xpath":
                locatorElement  =   Locators.getXpath(ExcelUtility.locatorvalue);
                break;
            case "tagName":
                locatorElement  =    Locators.getTagName(ExcelUtility.locatorvalue);
                break;
            case "cssSelector":
                locatorElement  =  Locators.getCssSelectors(ExcelUtility.locatorvalue);
                break;
        }
    }
    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException {
        ExcelUtility u = new ExcelUtility();
        u.readExcel(Constant.EXCEL_PATH);
        EngineExcecution engine =new EngineExcecution();
        engine.getMethodsFromKeyWordClass();

        for (int row = 1; row <=ExcelUtility.lastRowNum ; row++) {
            u.getvaluesExcel(row,Constant.LOCATOR_COLUMN,Constant.KEYWORD_COLUMN,Constant.TESTDATA_COLUMN);
            engine.findwebElements();
            engine.execteMethods();
        }
    }
    }
//to overcome this we use reflection api methods
         /*  if(keyword.equalsIgnoreCase("openBrowser")){
           KeywordDrivenMethods.openBrowser();
           } else if (keyword.equalsIgnoreCase("getUrl")) {
           KeywordDrivenMethods.getUrl();
           }else if (keyword.equalsIgnoreCase("enterEmail")) {
           KeywordDrivenMethods.enterEmail();
           }else if (keyword.equalsIgnoreCase("enterpassword")) {
               KeywordDrivenMethods.enterPassword();
           }else if (keyword.equalsIgnoreCase("clicklogin")) {
               KeywordDrivenMethods.clickLogin();
           }else if (keyword.equalsIgnoreCase("clickSignUp")) {
               KeywordDrivenMethods.clickSignUp();
           }
           else if (keyword.equalsIgnoreCase("enterFirstname")) {
               KeywordDrivenMethods.enterFirstname();;
           }
           else if (keyword.equalsIgnoreCase("enterLastname")) {
               KeywordDrivenMethods.enterLastname();
           } */
