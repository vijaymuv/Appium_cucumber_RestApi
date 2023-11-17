package objectsitbusinessbook;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static Utilities.UtilityFiles.driver;
public class ListenersTstng implements ITestListener {
    @Override
    public void onTestStart(ITestResult result) {

        System.out.println("test started");
    }
    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println("test started");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("test failed");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File dest = new File("C:\\Users\\Friday\\IdeaProjects\\ProjectsPractise\\FailedTestCasesImg\\failedtc.png");
        try {
            FileUtils.copyFile(source,dest);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println("test skipped"+result.getMethod().getConstructorOrMethod().getName());
    }
    @Override
    public void onFinish(ITestContext context) {

        System.out.println("test finished"+context.getName());
    }
}
