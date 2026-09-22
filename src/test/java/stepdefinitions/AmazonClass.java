package stepdefinitions;

import base.BaseClass;
import base.DriverFactory;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import pages.HomePage;
import utils.ScreenshotUtil;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AmazonClass extends BaseClass {

    WebDriver driver;
    private HomePage homePage;

    @Given("I am on Amazon home page")
    public void i_am_on_amazon_home_page() throws InterruptedException {
        homePage = new HomePage();
        driver = DriverFactory.getDriver();
        String expectedTitle = homePage.returnHomepageTitle();
        Thread.sleep(10000);
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @When("I look at the Amazon logo")
    public void i_look_at_the_amazon_logo() throws IOException {
        System.out.println("I look at the Page");
    }
    @Then("The Amazon logo should be displayed.")
    public void the_amazon_logo_should_be_displayed() {
        boolean booleanValue = homePage.returnLogopath();
        Assert.assertTrue(booleanValue);
    }

    @When("I click on Sliders Items")
    public void i_click_on_sliders_items() throws InterruptedException {
        List<WebElement> gwmWrapper = homePage.listgwmWrapper();
        List<String> hrefList = new ArrayList<>();
        for(WebElement gwmList : gwmWrapper){
            hrefList.add(gwmList.getAttribute("href"));
        }
        String parentWindow = driver.getWindowHandle();
        for(String listHref : hrefList){
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.open(arguments[0], '_blank');", listHref);
            break;
        }
        Set<String> allWindows = driver.getWindowHandles();
        for(String childWindow : allWindows){
            if(!childWindow.equalsIgnoreCase(parentWindow)){
                Thread.sleep(5000);
                String txtVal = driver.findElement(By.xpath("//*[@alt='Amazon Fashion']")).getText();
                System.out.println(txtVal);
            }
        }
    }
    @Then("It should be redirected to new tab")
    public void it_should_be_redirected_to_new_tab() {

    }

}
