package researchfindelement;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

/**
 * TestWait
 *
 * @author Dinglulu
 * @function
 * @createDate 2015/9/7
 * @updateBy Dinglulu
 * @updateDate 2015/9/7
 */
public class TestWait {

    WebDriver driver = null;

    @BeforeTest
    public void startDriver(){
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        options.addArguments("--user-data-dir=C:/Users/Administrator/AppData/Local/Google/Chrome/User Data/Default");
        driver = new ChromeDriver(options);
    }

    @Test
    public void testWait() throws Exception{
        driver.get("http://www.baidu.com");
        driver.findElement(By.id("kw")).sendKeys("selenium");
        driver.findElement(By.id("su")).click();
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d){
                return d.getTitle().toLowerCase().startsWith("selenium");
            }
        });

        driver.navigate().back();
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("/selenium2/screenshot.png"));

    }
}
