package CucumberRevision;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"C:\\Users\\Friday\\IdeaProjects\\TestNG_Appium\\src\\test\\java\\CucumberRevision\\cucumberRev.feature"},
        glue = {"CucumberRevision", "hooks"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}

)
public class Test_Cucumber_Revision extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
