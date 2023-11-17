package runnerClasses;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

import org.testng.annotations.DataProvider;


@CucumberOptions(
        features = {"C:\\Users\\Friday\\IdeaProjects\\ProjectsPractise\\src\\test\\java\\FeatureFiles\\Login.feature"},
        glue={"stepdefinition"}
//        plugin = {"pretty",
//                "json:Reports/LoginCucumberParallel.json",
//                "html:Reports/LoginCucumberParallel.html",
//                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//        },
//        tags = "@Hooks"
)
public class login extends AbstractTestNGCucumberTests {
// @Override
//  @DataProvider(parallel = true)
//     public Object[] [] scenarios(){
//     return super.scenarios();
//   }


}
