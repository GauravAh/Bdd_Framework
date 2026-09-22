package pages;

import base.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

    private WebDriver driver;
    public SignInPage(WebDriver driver){
        this.driver = driver;
        driver = DriverFactory.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "#ap_email_login")
    WebElement txtEmail;

    @FindBy(css = "#ap_password")
    WebElement txtPassword;

    @FindBy(css = "#continue")
    WebElement continueBtn;

    @FindBy(css = "#signInSubmit")
    WebElement signIn;

    @FindBy(css = "input[name='proceedToRetailCheckout']")
    WebElement retailCheckout;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement fullName;

    @FindBy(xpath = "//*[contains(text(),'Add a new delivery address')]")
    WebElement delAddress;

    @FindBy(css = "#address-ui-widgets-enterAddressPhoneNumber")
    WebElement mobAdddress;

    @FindBy(css = "#address-ui-widgets-enterAddressPostalCode")
    WebElement postalAddress;

    public void sendPostalAdderess(String val){
        postalAddress.sendKeys(val);
    }

    public void sendEmail(String val){
        txtEmail.sendKeys(val);
    }

    public void sendMobileNo(String val){
        mobAdddress.sendKeys(val);
    }

    public void sendPassword(String val){
        txtPassword.sendKeys(val);
    }

    public void clickContinue(){
        continueBtn.click();
    }

    public void clickSignin(){
        signIn.click();
    }

    public void clickdelAddress(){
        delAddress.click();
    }

    public void sendFullName(String fName){
        fullName.sendKeys(fName);
    }

    public void clickretailCheckout(){
        retailCheckout.click();
    }

}
