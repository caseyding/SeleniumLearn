package researchfindelement;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * TestNavigate
 *
 * @author Dinglulu
 * @function
 * @createDate 2015/9/7
 * @updateBy Dinglulu
 * @updateDate 2015/9/7
 */
@Log4j
public class TestNavigate {
    WebDriver driver = null;

    @BeforeTest
    public void startDriver(){
        log.info("System.getenv(\"USERPROFILE\") = " + System.getenv("USERPROFILE"));
        String sysEnv = System.getenv("USERPROFILE").replace("\\", "/");
        log.info(sysEnv);
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "allow-running-insecure-content", "--test-type");
        options.addArguments("--user-data-dir="+ System.getenv("USERPROFILE").replace("\\", "/") +"/AppData/Local/Google/Chrome/User Data/Default");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver = new FirefoxDriver();
//        driver.manage().window().maximize();
//
//        System.setProperty("webdriver.ie.driver","C:\\Selenium\\IEDriverServer.exe");
//        DesiredCapabilities desiredCapabilities;
//        desiredCapabilities = DesiredCapabilities.internetExplorer();
//        desiredCapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
//        driver = new InternetExplorerDriver(desiredCapabilities);
    }

    @Test
    public void testNavigate() throws Exception{
        driver.get("http://www.baidu.com");
        log.info(driver.getCurrentUrl());
        log.info(driver.getTitle());
        Thread.sleep(2000);

        driver.navigate().to("http://cnblogs.com");
        log.info(driver.getCurrentUrl());
        log.info(driver.getTitle());
        Thread.sleep(2000);
//        driver.navigate().refresh();

        driver.navigate().back();
        log.info(driver.getCurrentUrl());
        log.info(driver.getTitle());

        Thread.sleep(2000);
//        driver.navigate().refresh();
        driver.navigate().forward();
        log.info(driver.getCurrentUrl());
        log.info(driver.getTitle());
        Thread.sleep(2000);
        driver.quit();

    }
}
