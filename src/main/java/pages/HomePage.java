package pages;

import base.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.FluentWaitUtility;
import utils.WaitUtil;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private WaitUtil wait;
  //  private FluentWaitUtility wait1;

    public HomePage(){
       driver = DriverFactory.getDriver();
       wait = new WaitUtil(driver);
     //  wait1 = new FluentWaitUtility();
    }

    By logoXpath = By.cssSelector("a[aria-label^='Amazon.in']");
    By listWrapper = By.cssSelector("ul[class$='gwm-window-wrapper']>li>span>div>div>div>a");

    public String returnHomepageTitle(){
        String expectedTitle = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        return expectedTitle;
    }

    public boolean returnLogopath(){
        WebElement logo = wait.waitForElement(logoXpath);
        return logo.isDisplayed();
    }

    public List<WebElement> listgwmWrapper(){
        return driver.findElements(listWrapper);
    }

}
