package stepdefinitions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class WebTablePractice {

    WebDriver driver;

    @Test
    public void runTable() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://qavbox.github.io/demo/webtable/?utm_source=chatgpt.com");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        /*List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table01']/tbody/tr"));
        for(int i=1;i<=totalRows.size();i++){
            String testVal= driver.findElement(By.xpath("//table[@id='table01']/tbody/tr["+i+"]/td[2]")).getText();
            if(testVal.equalsIgnoreCase("GUI") || testVal.equalsIgnoreCase("Performance")){
                driver.findElement(By.xpath("//table[@id='table01']/tbody/tr["+i+"]/td[1]")).click();
            }
        }*/
        List<WebElement> totalRows = driver.findElements(By.xpath("//table[@id='table02']/tbody/tr"));
        for(int i=1;i<=totalRows.size();i++){
            String testVal= driver.findElement(By.xpath("//table[@id='table01']/tbody/tr["+i+"]/td[3]")).getText();

        }
    }

}
