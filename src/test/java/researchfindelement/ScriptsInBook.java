package researchfindelement;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * ScriptsInBook
 *
 * @author Dinglulu
 * @function
 * @createDate 2015/9/6
 * @updateBy Dinglulu
 * @updateDate 2015/9/6
 */
@Log4j
public class ScriptsInBook {

    WebDriver driver = null;

    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10000, TimeUnit.SECONDS);
    }

    @Test
    public void testAlertDialog() throws Exception{
        driver.get("http://sislands.com/coin70/week1/dialogbox.htm");
        WebElement alertButton = driver.findElement(By.xpath("//input[@value='alert']"));
        alertButton.click();
        Thread.sleep(10000);
        Alert jsAlert = driver.switchTo().alert();
        jsAlert.accept();
    }

    @Test
    public void testConfirmDialog() throws Exception{
        driver.get("http://sislands.com/coin70/week1/dialogbox.htm");
        WebElement comfirmButton = driver.findElement(By.xpath("//input[@value='confirm']"));

        comfirmButton.click();
        Thread.sleep(2000);
        Alert jsConfirm = driver.switchTo().alert();
        log.info(jsConfirm.getText());
        jsConfirm.accept();
        Thread.sleep(2000);

        jsConfirm = driver.switchTo().alert();
        log.info(jsConfirm.getText());
        jsConfirm.accept();
        Thread.sleep(2000);

        comfirmButton.click();
        Thread.sleep(2000);
        Alert jsConfirm2 = driver.switchTo().alert();
        log.info(jsConfirm2.getText());
        jsConfirm2.dismiss();
        Thread.sleep(2000);

        jsConfirm2 = driver.switchTo().alert();
        log.info(jsConfirm2.getText());
        jsConfirm2.accept();
    }

//    @AfterTest
    public void closeDriver(){
        if(driver != null){
            driver.close();
        }
    }
}
