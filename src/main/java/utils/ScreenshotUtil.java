package utils;

import base.DriverFactory;
import constants.ConstantClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {

    static WebDriver driver;
    static String screenshotPath = System.getProperty("user.dir") + ConstantClass.screenshotPath;

    public static String takeScreenShot() throws IOException {
        driver = DriverFactory.getDriver();
        System.out.println("Title is.." + driver.getTitle());
        String timestamp = LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss_SSS"));
        String screenshotName = screenshotPath + timestamp + ".png" ;
        File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File destFile = new File(screenshotName);
        FileUtils.copyFile(srcFile,destFile);
        return screenshotName;
    }

}
