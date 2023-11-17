package runnerClasses;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\Friday\\IdeaProjects\\TestNg_Appium\\src\\test\\java\\FeatureFiles\\Login.feature",
        glue={"stepdefinition"},
//        dryRun = !true,
        monochrome = true,
//        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin ={
             "json:Reports/login.json",
             "html:Reports/login.html",
             "junit:Reports/login.xml",
         "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
      }
)
public class LoginRunner  {


}
