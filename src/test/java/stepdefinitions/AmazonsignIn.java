package stepdefinitions;

import base.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SignInPage;
import utils.ExcelUtility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonsignIn {

    SignInPage signInPage;
    private WebDriver driver;

    @Given("I am on Signin page")
    public void i_am_on_signin_page() {
        driver = DriverFactory.getDriver();
        signInPage = new SignInPage(driver);
    }
    @When("I entered an emailid")
    public void i_entered_an_emailid(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
        List<String> sendData = dataTable.asList();
        signInPage.sendEmail(sendData.get(1));
        Thread.sleep(2000);

    }
    @When("I click on Continue button")
    public void i_click_on_continue_button() throws InterruptedException {
        signInPage.clickContinue();
        Thread.sleep(1000);
    }
    @When("I entered valid password as {string}")
    public void i_entered_valid_password_as(String val) {
        signInPage.sendPassword(val);
    }

    @When("I click on signin button")
    public void i_click_on_signin_button() {
        signInPage.clickSignin();
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() throws InterruptedException {
        Thread.sleep(12000);
        driver.navigate().to("https://www.amazon.in/checkout/p/p-404-0370657-0750762/address?pipelineType=Chewbacca&cartItemCount=1&referrer=address");
        signInPage.clickretailCheckout();
        Thread.sleep(4000);
        signInPage.clickdelAddress();
        Thread.sleep(3000);

        ExcelUtility excelUtility = new ExcelUtility(System.getProperty("user.dir") + "\\src\\main\\resources\\TestData.xlsx", "Sheet1");
        List<HashMap<String, Object>> oo = excelUtility.getTestData();
        for(HashMap<String,Object> o : oo){
           String mobNo = o.get("Mobile Number").toString();
           String are = o.get("Area").toString();
           String Flat = o.get("Flat No").toString();
           String Town1 = o.get("Town").toString();
           String FullName1 = o.get("FullName").toString();
            String Landmark1 = o.get("Landmark").toString();
            String Street1 = o.get("Street").toString();
            String Pincode1 = o.get("Pincode").toString();

            signInPage.sendFullName(FullName1);
            signInPage.sendMobileNo(mobNo);
            signInPage.sendPostalAdderess(Pincode1);
        }
    }

}


/*
List<HashMap<String, Object>> oo = excelUtility.getTestData();
        for (HashMap<String, Object> data : oo) {
            for (Map.Entry<String, Object> entry : data.entrySet()) {
                System.out.println(
                        "Key = " + entry.getKey() +
                                ", Value = " + entry.getValue()
                );
            }
            System.out.println("----------------");
        }
 */