package hooks;

import Utilities.UtilityFiles;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.IOException;

public class HooksScenarios extends UtilityFiles {
    @BeforeStep
    public void beforeSteps(Scenario sc){
       String beforeStepsName = sc.getName();
        String id = sc.getId();
        Status status = sc.getStatus();
        System.out.println("BeforeStepname:"+beforeStepsName);
        System.out.println("id:"+id);
        System.out.println("status"+status);
        
    }
    @AfterStep
    public void afterSteps(Scenario sc){
      boolean afterStepsfailedOrNot = sc.isFailed();
       System.out.println("afterSteps failed Or Not :"+afterStepsfailedOrNot);
    }
    @Before
    public void beforeScenario(Scenario sc ){
        String name = sc.getName();
        System.out.println("scenario name: "+name);
    }
    @After
    public void afterScenario(Scenario sc) throws IOException {
        boolean failed = sc.isFailed();
        if (failed){
            TakesScreenshot ts = (TakesScreenshot) driver;
            byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
            sc.attach(screenshotAs,"image/png","cucumberRev");
//            System.out.println("failed scenario: "+failed);
        }
    }
}
