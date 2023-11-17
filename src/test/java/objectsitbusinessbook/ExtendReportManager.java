package objectsitbusinessbook;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;


public class ExtendReportManager implements ITestListener {
    public  ExtentReports extent;
    public  ExtentSparkReporter spark;
    public  ExtentTest test;
    @Override
    public void onStart(ITestContext context) {
        extent=new ExtentReports();
        spark = new ExtentSparkReporter("tst.html");
        //  Desktop.getDesktop().browse(new File("testNGiretry.html").toURI());
        extent.attachReporter(spark);
    }
@Override
    public void onTestSkipped(ITestResult result) {
        test=extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.SKIP,"test Skipped");

    }
    @Override
    public void onTestSuccess(ITestResult result) {
       test=extent.createTest(result.getName());
       test.assignCategory(result.getMethod().getGroups());
       test.createNode(result.getName());
       test.log(Status.PASS,"test passed");
        System.out.println("sucess"+test);
    }
    @Override
    public void onTestFailure(ITestResult result) {
        test=extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        test.log(Status.FAIL,result.getThrowable().getMessage());
        test.fail("faliedtestcaseimg",
                MediaEntityBuilder.createScreenCaptureFromPath("FailedTcScreenShot.png").build());

    }
    @Override
        public void onFinish(ITestContext context) {
        extent.flush();
    }
}