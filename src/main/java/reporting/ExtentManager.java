package reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.ConstantClass;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    static ExtentReports reports;
    static String timestamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    static String reportPath = System.getProperty("user.dir") + ConstantClass.reportPath + timestamp + ".html";

    public static ExtentReports getInstance(){
        if(reports == null) {
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reports = new ExtentReports();
            reporter.config().setReportName("Automation Report");
            reporter.config().setTheme(Theme.DARK);
            reports.setSystemInfo("Operating System","windows");
            reports.setSystemInfo("browser","chrome");
            reports.attachReporter(reporter);
        }
        return reports;
    }

}
