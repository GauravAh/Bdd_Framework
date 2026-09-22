package hooks;

import base.BaseClass;
import base.DriverFactory;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import reporting.ExtentManager;
import reporting.ExtentTestManager;
import utils.ScreenshotUtil;

import java.io.IOException;

public class HookClass {
    WebDriver driver;

    @Before("@Smoke")
    public void setUP(Scenario scenario){
        //  ExtentTest test = ExtentManager.getInstance().createTest(scenario.getName());
        //   ExtentTestManager.setTest(test);
        String urlAmazon = BaseClass.initializeApplication();
        driver = DriverFactory.setupDriver();
        driver.get(urlAmazon);
    }

    @Before("@Regression")
    public void runSignIn(){
        String urlAmazonSignIn = BaseClass.initializeApplicationSignIn();
        driver = DriverFactory.setupDriver();
        driver.get(urlAmazonSignIn);
    }

    @After
    public void quitSetup() throws IOException {
        /*Status getTheStatus = ExtentTestManager.getTest().getStatus();
        String knowStatus =  getTheStatus.getName();
        if(knowStatus.equalsIgnoreCase("Pass")){
            ExtentTestManager.getTest().pass("Scenario Passed").addScreenCaptureFromPath(ScreenshotUtil.takeScreenShot());
        }
        System.out.println("Stat........." + knowStatus);
       ExtentManager.getInstance().flush();*/
    }
}
