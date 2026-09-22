package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.ConstantClass;
import io.cucumber.testng.PickleWrapper;
import org.testng.*;
import org.testng.xml.XmlSuite;
import utils.ScreenshotUtil;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CustomRep implements IReporter{

    private static ExtentReports reports;
    private static ExtentTest test;

    static String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    static String reportPath = System.getProperty("user.dir") + ConstantClass.reportPath + timestamp + ".html";

    @Override
    public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reports = new ExtentReports();
        reporter.config().setReportName("Automation Cucumber Report");
        reporter.config().setTheme(Theme.DARK);
        reporter.config().setDocumentTitle("Automation Cases");
        reports.setSystemInfo("Browser", "Chrome");
        reports.attachReporter(reporter);

        // Loop through all suites
        for (ISuite suite : suites) {
            // Get results of the suite
            Map<String, ISuiteResult> suiteResults = suite.getResults();
            // Loop through suite results
            for (ISuiteResult suiteResult : suiteResults.values()) {
                // Get TestNG test context
                ITestContext context = suiteResult.getTestContext();
                try {
                    // PASS
                    buildTestNodes(context.getPassedTests().getAllResults(), "PASS");
                    // FAIL
                    buildTestNodes(context.getFailedTests().getAllResults(), "FAIL");
                    // SKIP
                    buildTestNodes(context.getSkippedTests().getAllResults(), "SKIP");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        reports.flush();
    }

    private void buildTestNodes(Set<ITestResult> testResults, String status) throws IOException {
        for (ITestResult result : testResults) {
            Object[] parameters = result.getParameters();
            for (Object parameter : parameters) {
                if (parameter instanceof PickleWrapper) {
                    PickleWrapper pickleWrapper =
                            (PickleWrapper) parameter;
                    String scenarioName =
                            pickleWrapper.getPickle().getName();
                    if(status.equalsIgnoreCase("PASS")){
                        test = reports.createTest(scenarioName);
                        test.pass("Scenario Passed").addScreenCaptureFromPath(ScreenshotUtil.takeScreenShot());
                    }
                }
            }
        }
    }
}

// Meaning of PickleWrapper
// It wraps a Cucumber Scenario so that Cucumber can pass that scenario to TestNG.