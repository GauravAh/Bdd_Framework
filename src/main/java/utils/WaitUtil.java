package utils;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtil {

    private WebDriverWait wait;

    public WaitUtil(WebDriver driver){
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    public WebElement waitForElement(By locator){
         return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public WebElement waitForElementClickable(By locator){
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public boolean waitForTitle(String titletext){
        return wait.until(ExpectedConditions.titleContains(titletext));
    }
}
