package objectsitbusinessbook;

import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.xml.XmlSuite;

import java.util.List;
import java.util.Map;

public class IreporterHtml implements IReporter {

    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        for (ISuite suite:suites) {
            String suitename = suite.getName();
            Map<String, ISuiteResult> results = suite.getResults();
            for (ISuiteResult result:results.values()) {
                ITestContext tc = result.getTestContext();
                System.out.println("all datas" +tc.getName() + " "+ tc.getStartDate()+" "
                        + tc.getEndDate()+ " "+ tc.getOutputDirectory());
                System.out.println("capture passed results " +suitename +
                        "no.of.test cases "+ tc.getPassedTests().getAllResults().size());

                System.out.println("capture failed  results " +suitename +

                        "no.of.test cases "+ tc.getFailedTests().getAllResults().size());

                System.out.println("capture skipped results " +suitename +
                        "no.of.test cases  "+ tc.getSkippedTests().getAllResults().size());
            }

        }

        System.out.println("html report:"+outputDirectory);
    }
}
