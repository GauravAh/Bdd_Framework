package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {
    static ThreadLocal<WebDriver> lDriver = new ThreadLocal<>();

    public static WebDriver setupDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(options);
        lDriver.set(driver);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver getDriver(){
        return lDriver.get();
    }
}
